package com.wisecloud.app.ui.wizard.ota

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.wisecloud.app.R
import com.wisecloud.app.databinding.FragmentOtaUpdateWizardBinding
import com.wisecloud.app.ui.wizard.common.DeviceTagSelectFragment
import com.wisecloud.app.util.showToast
import com.wisecloud.app.util.visibleIf
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OtaUpdateWizardFragment : Fragment() {

    private var _binding: FragmentOtaUpdateWizardBinding? = null
    private val binding get() = _binding!!

    private val viewModel: OtaUpdateViewModel by viewModels()
    private var tagFragment: DeviceTagSelectFragment? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOtaUpdateWizardBinding.inflate(inflater, container, false)
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
            getString(R.string.step_select_firmware),
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
        binding.rvFirmware.layoutManager = LinearLayoutManager(requireContext())
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
            OtaUpdateViewModel.STEP_CONFIG -> {
                viewModel.taskName = binding.etTaskName.text.toString().ifBlank { "OTA Update Task" }
                viewModel.idleTimeFrom = binding.etIdleFrom.text.toString().ifBlank { null }
                viewModel.idleTimeTo = binding.etIdleTo.text.toString().ifBlank { null }
                viewModel.nextStep()
                viewModel.loadFirmwareList()
            }
            OtaUpdateViewModel.STEP_SELECT_FIRMWARE -> {
                if (viewModel.selectedFirmware.value == null) {
                    requireContext().showToast(getString(R.string.please_select_firmware))
                    return
                }
                viewModel.nextStep()
            }
            OtaUpdateViewModel.STEP_SELECT_DEVICES -> {
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
            binding.layoutStep1.visibleIf(step == OtaUpdateViewModel.STEP_CONFIG)
            binding.layoutStep2.visibleIf(step == OtaUpdateViewModel.STEP_SELECT_FIRMWARE)
            binding.layoutStep3.visibleIf(step == OtaUpdateViewModel.STEP_SELECT_DEVICES)
            binding.btnPrevious.visibleIf(step > OtaUpdateViewModel.STEP_CONFIG)
            binding.btnNext.text = if (step == OtaUpdateViewModel.STEP_SELECT_DEVICES)
                getString(R.string.btn_submit) else getString(R.string.btn_next)
        }

        viewModel.firmwareList.observe(viewLifecycleOwner) { list ->
            binding.rvFirmware.adapter = FirmwareAdapter(list) { fw ->
                viewModel.selectFirmware(fw)
            }
        }

        viewModel.submitResult.observe(viewLifecycleOwner) { state ->
            when (state) {
                is OtaUpdateViewModel.SubmitState.Loading -> binding.btnNext.isEnabled = false
                is OtaUpdateViewModel.SubmitState.Success -> {
                    binding.btnNext.isEnabled = true
                    requireContext().showToast(getString(R.string.task_submit_success))
                    navigateToTaskDetail(state.response.traceId)
                }
                is OtaUpdateViewModel.SubmitState.Error -> {
                    binding.btnNext.isEnabled = true
                    requireContext().showToast(state.message)
                }
                else -> binding.btnNext.isEnabled = true
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
            androidx.navigation.fragment.findNavController(this).navigate(
                R.id.action_otaUpdate_to_taskDetail, bundle
            )
        } catch (e: Exception) { /* nav not wired yet */ }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

/** Adapter for firmware version list with single selection */
private class FirmwareAdapter(
    private val items: List<OtaUpdateViewModel.FirmwareInfo>,
    private val onSelected: (OtaUpdateViewModel.FirmwareInfo) -> Unit
) : RecyclerView.Adapter<FirmwareAdapter.VH>() {

    private var selectedIndex = -1

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rb: RadioButton = itemView.findViewById(R.id.rbFirmware)
        val tvVersion: TextView = itemView.findViewById(R.id.tvFirmwareVersion)
        val tvDate: TextView = itemView.findViewById(R.id.tvFirmwareDate)
        val tvDesc: TextView = itemView.findViewById(R.id.tvFirmwareDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_firmware, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val fw = items[position]
        holder.tvVersion.text = fw.versionName
        holder.tvDate.text = fw.releaseDate
        holder.tvDesc.text = fw.description
        holder.rb.isChecked = position == selectedIndex

        val select = {
            val prev = selectedIndex
            selectedIndex = holder.bindingAdapterPosition
            if (prev >= 0) notifyItemChanged(prev)
            notifyItemChanged(selectedIndex)
            onSelected(fw)
        }
        holder.rb.setOnClickListener { select() }
        holder.itemView.setOnClickListener { select() }
    }

    override fun getItemCount() = items.size
}
