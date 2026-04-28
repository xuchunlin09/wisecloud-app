package com.wisecloud.app.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.wisecloud.app.R
import com.wisecloud.app.data.model.response.DailyActivity
import com.wisecloud.app.data.model.response.DeviceSummary
import com.wisecloud.app.databinding.FragmentDashboardBinding
import com.wisecloud.app.util.gone
import com.wisecloud.app.util.visible
import com.wisecloud.app.widget.BatchMenuBottomSheet
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.findNavController

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DashboardViewModel by viewModels()
    private lateinit var searchAdapter: SearchResultAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSearchResults()
        setupListeners()
        observeViewModel()
        startFabPulseAnimation()

        viewModel.loadOverview()
        viewModel.loadWeeklyActivity()

        binding.tvWelcome.text = getString(R.string.welcome_format, viewModel.username)
    }

    private fun setupSearchResults() {
        searchAdapter = SearchResultAdapter { device ->
            navigateToDeviceDetail(device.sn)
        }
        binding.rvSearchResults.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = searchAdapter
        }
    }

    private fun setupListeners() {
        binding.etSearch.doAfterTextChanged { text ->
            viewModel.onSearchQueryChanged(text?.toString().orEmpty())
        }

        binding.cardTaskManagement.setOnClickListener {
            navigateToTaskManagement()
        }

        binding.fabBatchMenu.setOnClickListener {
            showBatchMenu()
        }
    }

    private fun observeViewModel() {
        viewModel.overview.observe(viewLifecycleOwner) { overview ->
            binding.tvTotalDevices.text = overview.totalCount.toString()
            binding.tvOnlineDevices.text = overview.onlineCount.toString()
            binding.tvOnlineRate.text = overview.onlineRate
        }

        viewModel.searchResults.observe(viewLifecycleOwner) { results ->
            if (results.isNullOrEmpty()) {
                binding.rvSearchResults.gone()
            } else {
                binding.rvSearchResults.visible()
                searchAdapter.submitList(results)
            }
        }

        viewModel.weeklyActivity.observe(viewLifecycleOwner) { activities ->
            setupBarChart(activities)
        }
    }

    private fun setupBarChart(activities: List<DailyActivity>) {
        val entries = activities.mapIndexed { index, activity ->
            BarEntry(index.toFloat(), activity.activeCount.toFloat())
        }
        val labels = activities.map { it.date }

        val dataSet = BarDataSet(entries, getString(R.string.active_devices)).apply {
            color = requireContext().getColor(R.color.primary)
            valueTextSize = 10f
            setDrawValues(true)
        }

        binding.chartWeeklyActivity.apply {
            data = BarData(dataSet).apply { barWidth = 0.6f }
            description.isEnabled = false
            legend.isEnabled = false
            setFitBars(true)
            animateY(500)

            xAxis.apply {
                position = XAxis.XAxisPosition.BOTTOM
                valueFormatter = IndexAxisValueFormatter(labels)
                granularity = 1f
                setDrawGridLines(false)
            }
            axisLeft.apply {
                axisMinimum = 0f
                setDrawGridLines(true)
                gridColor = requireContext().getColor(R.color.offline)
            }
            axisRight.isEnabled = false
            invalidate()
        }
    }

    private fun startFabPulseAnimation() {
        val pulseAnim = AnimationUtils.loadAnimation(requireContext(), R.anim.pulse)
        binding.fabBatchMenu.startAnimation(pulseAnim)
    }

    private fun showBatchMenu() {
        binding.fabBatchMenu.clearAnimation()
        val bottomSheet = BatchMenuBottomSheet.newInstance()
        bottomSheet.onMenuItemSelected = { menuItem ->
            when (menuItem) {
                BatchMenuBottomSheet.MenuItem.APP_INSTALL -> navigateToWizard(R.id.action_dashboard_to_batchInstall)
                BatchMenuBottomSheet.MenuItem.OTA_UPDATE -> navigateToWizard(R.id.action_dashboard_to_otaUpdate)
                BatchMenuBottomSheet.MenuItem.APP_UNINSTALL -> navigateToWizard(R.id.action_dashboard_to_batchUninstall)
                BatchMenuBottomSheet.MenuItem.PUSH_INSTRUCTION -> navigateToWizard(R.id.action_dashboard_to_pushInstruction)
                BatchMenuBottomSheet.MenuItem.WISEOS_SETTING -> navigateToWizard(R.id.action_dashboard_to_wiseosSetting)
            }
            startFabPulseAnimation()
        }
        bottomSheet.show(childFragmentManager, BatchMenuBottomSheet.TAG)
    }

    private fun navigateToWizard(actionId: Int) {
        try {
            findNavController().navigate(actionId)
        } catch (e: Exception) {
            // Navigation action not yet defined — will be wired in task 22
        }
    }

    private fun navigateToDeviceDetail(sn: String) {
        try {
            val bundle = Bundle().apply { putString("sn", sn) }
            findNavController().navigate(
                R.id.action_dashboard_to_deviceDetail, bundle
            )
        } catch (e: Exception) {
            // Navigation action not yet defined — will be wired in task 22
        }
    }

    private fun navigateToTaskManagement() {
        try {
            findNavController().navigate(
                R.id.action_dashboard_to_taskList
            )
        } catch (e: Exception) {
            // Navigation action not yet defined — will be wired in task 22
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
