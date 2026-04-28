package com.wisecloud.app.ui.wizard.uninstall

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wisecloud.app.R
import com.wisecloud.app.data.model.response.ApplicationInfo
import com.wisecloud.app.databinding.FragmentBatchUninstallWizardBinding
import com.wisecloud.app.ui.wizard.common.DeviceTagSelectFragment
import com.wisecloud.app.util.showToast
import com.wisecloud.app.util.visibleIf
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.findNavController

@AndroidEntryPoint
class BatchUninstallWizardFragment : Fragment() {

    private var _binding: FragmentBatchUninstallWizardBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BatchUninstallViewModel by viewModels()
    private var tagFragment: DeviceTagSelectFragment? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBatchUninstallWizardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupStepIndicator()
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

    private fun setupStep2() {
        binding.rvApps.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setupStep3() {
        tagFragment = DeviceTagSelectFragment.newInstance()
        childFragmentManager.beginTransaction()
            .replace(R.id.layoutStep3, tagFragment!!)
            .commit()
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
            BatchUninstallViewModel.STEP_CONFIG -> {
                viewModel.taskName = binding.etTaskName.text.toString().ifBlank { "Uninstall Task" }
                viewModel.nextStep()
                viewModel.loadApplications()
            }
            BatchUninstallViewModel.STEP_SELECT_APP -> {
                if (viewModel.selectedPackages.isEmpty()) {
                    requireContext().showToast(getString(R.string.please_select_app))
                    return
                }
                viewModel.nextStep()
            }
            BatchUninstallViewModel.STEP_SELECT_DEVICES -> {
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
            binding.layoutStep1.visibleIf(step == BatchUninstallViewModel.STEP_CONFIG)
            binding.layoutStep2.visibleIf(step == BatchUninstallViewModel.STEP_SELECT_APP)
            binding.layoutStep3.visibleIf(step == BatchUninstallViewModel.STEP_SELECT_DEVICES)
            binding.btnPrevious.visibleIf(step > BatchUninstallViewModel.STEP_CONFIG)
            binding.btnNext.text = if (step == BatchUninstallViewModel.STEP_SELECT_DEVICES)
                getString(R.string.btn_submit) else getString(R.string.btn_next)
        }

        viewModel.applications.observe(viewLifecycleOwner) { apps ->
            binding.rvApps.adapter = UninstallAppAdapter(apps, viewModel.selectedPackages) { pkg ->
                viewModel.toggleAppSelection(pkg)
            }
        }

        viewModel.isLoadingApps.observe(viewLifecycleOwner) { loading ->
            binding.progressApps.visibleIf(loading)
        }

        viewModel.submitResult.observe(viewLifecycleOwner) { state ->
            when (state) {
                is BatchUninstallViewModel.SubmitState.Loading -> binding.btnNext.isEnabled = false
                is BatchUninstallViewModel.SubmitState.Success -> {
                    binding.btnNext.isEnabled = true
                    requireContext().showToast(getString(R.string.task_submit_success))
                    navigateToTaskDetail(state.response.traceId)
                }
                is BatchUninstallViewModel.SubmitState.Error -> {
                    binding.btnNext.isEnabled = true
                    requireContext().showToast(state.message)
                }
                else -> binding.btnNext.isEnabled = true
            }
        }
    }

    private fun navigateToTaskDetail(traceId: String) {
        try {
            val bundle = Bundle().apply { putString("traceId", traceId) }
            findNavController().navigate(
                R.id.action_batchUninstall_to_taskDetail, bundle
            )
        } catch (e: Exception) { /* nav not wired yet */ }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

/** Simple multi-select adapter for uninstall app list */
private class UninstallAppAdapter(
    private val apps: List<ApplicationInfo>,
    private val selectedPkgs: Set<String>,
    private val onToggle: (String) -> Unit
) : RecyclerView.Adapter<UninstallAppAdapter.VH>() {

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cb: CheckBox = itemView.findViewById(R.id.cbApp)
        val tvName: TextView = itemView.findViewById(R.id.tvAppName)
        val tvPkg: TextView = itemView.findViewById(R.id.tvAppPackage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_uninstall_app, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val app = apps[position]
        holder.tvName.text = app.appName
        holder.tvPkg.text = app.appPackage
        holder.cb.isChecked = app.appPackage in selectedPkgs

        val toggle = {
            onToggle(app.appPackage)
            holder.cb.isChecked = app.appPackage in selectedPkgs
        }
        holder.cb.setOnClickListener { toggle() }
        holder.itemView.setOnClickListener { toggle() }
    }

    override fun getItemCount() = apps.size
}
