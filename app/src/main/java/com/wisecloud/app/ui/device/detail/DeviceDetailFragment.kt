package com.wisecloud.app.ui.device.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.wisecloud.app.R
import com.wisecloud.app.data.model.response.DeviceDetailResponse
import com.wisecloud.app.data.model.response.InstalledApp
import com.wisecloud.app.databinding.BottomSheetInstalledAppsBinding
import com.wisecloud.app.databinding.BottomSheetRemoteActionsBinding
import com.wisecloud.app.databinding.FragmentDeviceDetailBinding
import com.wisecloud.app.util.BatteryColorUtil
import com.wisecloud.app.util.formatDateTime
import com.wisecloud.app.util.gone
import com.wisecloud.app.util.showToast
import com.wisecloud.app.util.visible
import com.wisecloud.app.util.visibleIf
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.findNavController

@AndroidEntryPoint
class DeviceDetailFragment : Fragment() {

    private var _binding: FragmentDeviceDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DeviceDetailViewModel by viewModels()
    private lateinit var gridAdapter: InstalledAppGridAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDeviceDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupBackButton()
        setupInstalledAppsGrid()
        setupChartPeriodChips()
        setupFab()
        observeViewModel()

        val sn = arguments?.getString("sn").orEmpty()
        if (sn.isNotEmpty()) {
            viewModel.loadDeviceDetail(sn)
        }
    }

    private fun setupBackButton() {
        binding.btnBack.setOnClickListener {
            try {
                findNavController().navigateUp()
            } catch (e: Exception) {
                activity?.onBackPressedDispatcher?.onBackPressed()
            }
        }
    }

    private fun setupInstalledAppsGrid() {
        gridAdapter = InstalledAppGridAdapter()
        binding.rvInstalledAppsGrid.apply {
            layoutManager = GridLayoutManager(requireContext(), 4)
            adapter = gridAdapter
            isNestedScrollingEnabled = false
        }

        binding.btnExpandApps.setOnClickListener {
            viewModel.deviceDetail.value?.installApps?.let { apps ->
                showInstalledAppsBottomSheet(apps)
            }
        }
    }

    private fun setupChartPeriodChips() {
        binding.chipToday.setOnClickListener {
            viewModel.setChartPeriod(ChartPeriod.TODAY)
        }
        binding.chipSevenDays.setOnClickListener {
            viewModel.setChartPeriod(ChartPeriod.SEVEN_DAYS)
        }
        binding.chipThirtyDays.setOnClickListener {
            viewModel.setChartPeriod(ChartPeriod.THIRTY_DAYS)
        }
    }

    private fun setupFab() {
        binding.fabRemoteAction.setOnClickListener {
            showRemoteActionsBottomSheet()
        }
    }

    private fun observeViewModel() {
        viewModel.deviceDetail.observe(viewLifecycleOwner) { detail ->
            bindDeviceDetail(detail)
        }

        viewModel.isLoading.observe(viewLifecycleOwner) { loading ->
            binding.progressBar.visibleIf(loading)
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) { message ->
            message?.let { requireContext().showToast(it) }
        }

        viewModel.chartPeriod.observe(viewLifecycleOwner) { period ->
            updateChart(period)
        }

        viewModel.lockResult.observe(viewLifecycleOwner) { result ->
            result ?: return@observe
            val msg = when {
                result.isSuccess && result.action == "lock" -> getString(R.string.lock_success)
                result.isSuccess && result.action == "unlock" -> getString(R.string.unlock_success)
                else -> getString(R.string.operation_failed, result.errorMessage.orEmpty())
            }
            requireContext().showToast(msg)
            viewModel.clearActionResult()
        }
    }

    private fun bindDeviceDetail(detail: DeviceDetailResponse) {
        // Header
        binding.tvSn.text = detail.sn
        binding.tvDeviceType.text = detail.deviceType

        val isOnline = detail.onlineStatus == 1
        binding.chipOnlineStatus.text = if (isOnline) {
            getString(R.string.status_online)
        } else {
            getString(R.string.status_offline)
        }
        binding.chipOnlineStatus.setChipBackgroundColorResource(
            if (isOnline) R.color.online else R.color.offline
        )
        binding.chipOnlineStatus.setTextColor(
            ContextCompat.getColor(requireContext(), R.color.on_primary)
        )

        // Basic Info
        binding.tvAndroidVersion.text = detail.otaVersionName.ifEmpty { getString(R.string.na) }
        binding.tvRomVersion.text = detail.otaVersion.ifEmpty { getString(R.string.na) }
        binding.tvSpVersion.text = getString(R.string.na)
        binding.tvDmsVersion.text = getString(R.string.na)
        binding.tvOemVersion.text = getString(R.string.na)

        // Device Status - Battery
        val batteryLevel = detail.electricRate.replace("%", "").toIntOrNull() ?: 0
        binding.progressBattery.progress = batteryLevel
        binding.tvBatteryPercent.text = getString(R.string.battery_percent_format, batteryLevel)
        val batteryColorRes = BatteryColorUtil.getColor(batteryLevel)
        binding.progressBattery.setIndicatorColor(
            ContextCompat.getColor(requireContext(), batteryColorRes)
        )

        // Network Signal
        binding.tvNetworkSignal.text = if (detail.wifiStatus == 1) {
            getString(R.string.wifi_connected)
        } else {
            getString(R.string.wifi_disconnected)
        }

        // Last Online Time
        binding.tvLastOnlineTime.text = detail.lastOnlineTime.formatDateTime()

        // Installed Apps Grid (show first 8)
        val appsToShow = detail.installApps.take(8)
        gridAdapter.submitList(appsToShow)
        binding.btnExpandApps.visibleIf(detail.installApps.size > 8)

        // Map
        setupLeafletMap(detail.latitude, detail.longitude)
        if (detail.latitude.isNotEmpty() && detail.longitude.isNotEmpty()) {
            binding.tvCoordinates.text = getString(
                R.string.coordinates_format, detail.latitude, detail.longitude
            )
            binding.tvLocationUpdated.text = "${getString(R.string.location_updated)}: ${detail.lastOnlineTime.formatDateTime()}"
        } else {
            binding.tvCoordinates.text = getString(R.string.no_location)
            binding.tvLocationUpdated.gone()
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupLeafletMap(lat: String, lng: String) {
        val latitude = lat.toDoubleOrNull() ?: 0.0
        val longitude = lng.toDoubleOrNull() ?: 0.0

        binding.webViewMap.apply {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            webViewClient = WebViewClient()

            val html = """
                <!DOCTYPE html>
                <html>
                <head>
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.9.4/dist/leaflet.css" />
                    <script src="https://unpkg.com/leaflet@1.9.4/dist/leaflet.js"></script>
                    <style>
                        html, body, #map { height: 100%; margin: 0; padding: 0; }
                    </style>
                </head>
                <body>
                    <div id="map"></div>
                    <script>
                        var map = L.map('map').setView([$latitude, $longitude], 15);
                        L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
                            attribution: '© OpenStreetMap'
                        }).addTo(map);
                        L.marker([$latitude, $longitude]).addTo(map);
                    </script>
                </body>
                </html>
            """.trimIndent()

            loadDataWithBaseURL(null, html, "text/html", "UTF-8", null)
        }
    }

    private fun updateChart(period: ChartPeriod) {
        // Generate sample data based on period
        val count = when (period) {
            ChartPeriod.TODAY -> 24
            ChartPeriod.SEVEN_DAYS -> 7
            ChartPeriod.THIRTY_DAYS -> 30
        }

        val entries = (0 until count).map { i ->
            BarEntry(i.toFloat(), 0f)
        }

        val dataSet = BarDataSet(entries, getString(R.string.running_status)).apply {
            color = requireContext().getColor(R.color.primary)
            valueTextSize = 0f
        }

        binding.chartRunningStatus.apply {
            data = BarData(dataSet).apply { barWidth = 0.6f }
            description.isEnabled = false
            legend.isEnabled = false
            setFitBars(true)
            animateY(500)

            xAxis.apply {
                position = XAxis.XAxisPosition.BOTTOM
                granularity = 1f
                setDrawGridLines(false)
            }
            axisLeft.apply {
                axisMinimum = 0f
                setDrawGridLines(true)
            }
            axisRight.isEnabled = false
            invalidate()
        }
    }

    private fun showInstalledAppsBottomSheet(apps: List<InstalledApp>) {
        val dialog = BottomSheetDialog(requireContext())
        val sheetBinding = BottomSheetInstalledAppsBinding.inflate(layoutInflater)

        val listAdapter = InstalledAppListAdapter()
        sheetBinding.rvInstalledAppsList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = listAdapter
        }
        listAdapter.submitList(apps)

        dialog.setContentView(sheetBinding.root)
        dialog.show()
    }

    private fun showRemoteActionsBottomSheet() {
        val dialog = BottomSheetDialog(requireContext())
        val sheetBinding = BottomSheetRemoteActionsBinding.inflate(layoutInflater)

        sheetBinding.btnWiseViewer.setOnClickListener {
            dialog.dismiss()
            // WiseViewer navigation — will be wired in task 22
            requireContext().showToast("WiseViewer launching...")
        }

        sheetBinding.btnLockDevice.setOnClickListener {
            dialog.dismiss()
            showConfirmDialog(
                title = getString(R.string.confirm_lock_title),
                message = getString(R.string.confirm_lock_message),
                onConfirm = { viewModel.confirmLockDevice() }
            )
        }

        sheetBinding.btnUnlockDevice.setOnClickListener {
            dialog.dismiss()
            showConfirmDialog(
                title = getString(R.string.confirm_unlock_title),
                message = getString(R.string.confirm_unlock_message),
                onConfirm = { viewModel.confirmUnlockDevice() }
            )
        }

        dialog.setContentView(sheetBinding.root)
        dialog.show()
    }

    private fun showConfirmDialog(title: String, message: String, onConfirm: () -> Unit) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(getString(R.string.confirm)) { _, _ -> onConfirm() }
            .setNegativeButton(getString(R.string.cancel), null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.webViewMap.destroy()
        _binding = null
    }
}
