package com.wisecloud.app.ui.wizard.install

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.wisecloud.app.R
import com.wisecloud.app.data.model.response.AppVersion
import com.wisecloud.app.data.model.response.ApplicationInfo
import com.wisecloud.app.databinding.FragmentBatchInstallWizardBinding
import com.wisecloud.app.ui.wizard.common.DeviceTagSelectFragment
import com.wisecloud.app.util.gone
import com.wisecloud.app.util.showToast
import com.wisecloud.app.util.visible
import com.wisecloud.app.util.visibleIf
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.findNavController

@AndroidEntryPoint
class BatchInstallWizardFragment : Fragment() {

    private var _binding: FragmentBatchInstallWizardBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BatchInstallViewModel by viewModels()
    private lateinit var appAdapter: AppListAdapter
    private var tagFragment: DeviceTagSelectFragment? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBatchInstallWizardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupStepIndicator()
        setupStep1()
        setupStep2()
        setupStep3()
        setupNavButtons()
        observeViewModel()

        binding.toolbar.setNavigationOnClickListener { requireActivity().onBackPressedDispatcher.onBackPressed() }
        binding.etTaskName.setText(viewModel.taskName)
    }

    private fun setupStepIndicator() {
        binding.stepIndicator.setSteps(listOf(
            getString(R.string.step_task_config),
            getString(R.string.step_select_app),
            getString(R.string.step_select_devices)
        ))
    }

    private fun setupStep1() {
        binding.switchWifiOnly.setOnCheckedChangeListener { _, checked -> viewModel.wifiOnly = checked }
        binding.switchIdleTime.setOnCheckedChangeListener { _, checked ->
            viewModel.idleTimeEnabled = checked
            binding.layoutIdleTimeRange.visibleIf(checked)
        }
        binding.etIdleFrom.setOnClickListener { showTimePicker(true) }
        binding.etIdleTo.setOnClickListener { showTimePicker(false) }
    }

    private fun setupStep2() {
        appAdapter = AppListAdapter(
            onAppSelected = { app -> viewModel.selectApp(app) },
            onVersionSelected = { version -> viewModel.selectVersion(version) }
        )
        binding.rvApps.layoutManager = LinearLayoutManager(requireContext())
        binding.rvApps.adapter = appAdapter
    }

    private fun setupStep3() {
        tagFragment = DeviceTagSelectFragment.newInstance()
        childFragmentManager.beginTransaction()
            .replace(R.id.layoutStep3, tagFragment!!)
            .commit()
        // Populate with sample tags — in production these come from API
        tagFragment?.setTags(listOf(
            DeviceTagSelectFragment.DeviceTag("1", "Store A Devices", 25),
            DeviceTagSelectFragment.DeviceTag("2", "Store B Devices", 18),
            DeviceTagSelectFragment.DeviceTag("3", "Warehouse", 42)
        ))
    }

    private fun setupNavButtons() {
        binding.btnNext.setOnClickListener { onNextClicked() }
        binding.btnPrevious.setOnClickListener { viewModel.previousStep() }
    }

    private fun onNextClicked() {
        when (viewModel.currentStep.value) {
            BatchInstallViewModel.STEP_CONFIG -> {
                viewModel.taskName = binding.etTaskName.text.toString().ifBlank { "Install Task" }
                viewModel.idleTimeFrom = binding.etIdleFrom.text.toString().ifBlank { null }
                viewModel.idleTimeTo = binding.etIdleTo.text.toString().ifBlank { null }
                viewModel.nextStep()
                viewModel.loadApplications()
            }
            BatchInstallViewModel.STEP_SELECT_APP -> {
                if (viewModel.selectedVersion.value == null) {
                    requireContext().showToast(getString(R.string.please_select_version))
                    return
                }
                viewModel.nextStep()
            }
            BatchInstallViewModel.STEP_SELECT_DEVICES -> {
                viewModel.selectedDeviceSnList = tagFragment?.getSelectedTagIds() ?: emptyList()
                if (viewModel.selectedDeviceSnList.isEmpty()) {
                    requireContext().showToast(getString(R.string.please_select_devices))
                    return
                }
                viewModel.submitTask()
            }
        }
    }

    private fun observeViewModel() {
        viewModel.currentStep.observe(viewLifecycleOwner) { step ->
            binding.stepIndicator.setCurrentStep(step)
            binding.layoutStep1.visibleIf(step == BatchInstallViewModel.STEP_CONFIG)
            binding.layoutStep2.visibleIf(step == BatchInstallViewModel.STEP_SELECT_APP)
            binding.layoutStep3.visibleIf(step == BatchInstallViewModel.STEP_SELECT_DEVICES)
            binding.btnPrevious.visibleIf(step > BatchInstallViewModel.STEP_CONFIG)
            binding.btnNext.text = if (step == BatchInstallViewModel.STEP_SELECT_DEVICES)
                getString(R.string.btn_submit) else getString(R.string.btn_next)
        }

        viewModel.applications.observe(viewLifecycleOwner) { apps ->
            appAdapter.submitList(apps)
        }

        viewModel.isLoadingApps.observe(viewLifecycleOwner) { loading ->
            binding.progressApps.visibleIf(loading)
        }

        viewModel.selectedApp.observe(viewLifecycleOwner) { app ->
            if (app != null) {
                binding.cardSelectedVersion.visible()
                binding.tvSelectedAppName.text = app.appName
            }
        }

        viewModel.selectedVersion.observe(viewLifecycleOwner) { version ->
            if (version != null) {
                binding.tvSelectedVersionInfo.text = getString(
                    R.string.version_info_format,
                    version.versionNumber, version.versionName
                )
            }
        }

        viewModel.submitResult.observe(viewLifecycleOwner) { state ->
            when (state) {
                is BatchInstallViewModel.SubmitState.Loading -> {
                    binding.btnNext.isEnabled = false
                }
                is BatchInstallViewModel.SubmitState.Success -> {
                    binding.btnNext.isEnabled = true
                    requireContext().showToast(getString(R.string.task_submit_success))
                    navigateToTaskDetail(state.response.traceId)
                }
                is BatchInstallViewModel.SubmitState.Error -> {
                    binding.btnNext.isEnabled = true
                    requireContext().showToast(state.message)
                }
                else -> { binding.btnNext.isEnabled = true }
            }
        }
    }

    private fun showTimePicker(isFrom: Boolean) {
        val picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_24H)
            .setTitleText(if (isFrom) getString(R.string.idle_from) else getString(R.string.idle_to))
            .build()
        picker.addOnPositiveButtonClickListener {
            val time = String.format("%02d:%02d", picker.hour, picker.minute)
            if (isFrom) binding.etIdleFrom.setText(time) else binding.etIdleTo.setText(time)
        }
        picker.show(childFragmentManager, "time_picker")
    }

    private fun navigateToTaskDetail(traceId: String) {
        try {
            val bundle = Bundle().apply { putString("traceId", traceId) }
            findNavController().navigate(
                R.id.action_batchInstall_to_taskDetail, bundle
            )
        } catch (e: Exception) {
            // Navigation not yet wired — will be configured in task 22
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
