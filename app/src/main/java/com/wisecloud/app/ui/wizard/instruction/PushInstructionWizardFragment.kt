package com.wisecloud.app.ui.wizard.instruction

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.wisecloud.app.R
import com.wisecloud.app.databinding.FragmentPushInstructionWizardBinding
import com.wisecloud.app.ui.wizard.common.DeviceTagSelectFragment
import com.wisecloud.app.util.showToast
import com.wisecloud.app.util.visibleIf
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.findNavController

@AndroidEntryPoint
class PushInstructionWizardFragment : Fragment() {

    private var _binding: FragmentPushInstructionWizardBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PushInstructionViewModel by viewModels()
    private var tagFragment: DeviceTagSelectFragment? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPushInstructionWizardBinding.inflate(inflater, container, false)
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
            getString(R.string.step_select_instruction),
            getString(R.string.step_select_devices)
        ))
    }

    private fun setupStep2() {
        binding.rvInstructions.layoutManager = LinearLayoutManager(requireContext())
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
            PushInstructionViewModel.STEP_CONFIG -> {
                viewModel.taskName = binding.etTaskName.text.toString().ifBlank { "Push Instruction Task" }
                viewModel.nextStep()
                viewModel.loadInstructionTypes()
            }
            PushInstructionViewModel.STEP_SELECT_INSTRUCTION -> {
                if (viewModel.selectedInstruction.value == null) {
                    requireContext().showToast(getString(R.string.please_select_instruction))
                    return
                }
                viewModel.nextStep()
            }
            PushInstructionViewModel.STEP_SELECT_DEVICES -> {
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
            binding.layoutStep1.visibleIf(step == PushInstructionViewModel.STEP_CONFIG)
            binding.layoutStep2.visibleIf(step == PushInstructionViewModel.STEP_SELECT_INSTRUCTION)
            binding.layoutStep3.visibleIf(step == PushInstructionViewModel.STEP_SELECT_DEVICES)
            binding.btnPrevious.visibleIf(step > PushInstructionViewModel.STEP_CONFIG)
            binding.btnNext.text = if (step == PushInstructionViewModel.STEP_SELECT_DEVICES)
                getString(R.string.btn_submit) else getString(R.string.btn_next)
        }

        viewModel.instructionTypes.observe(viewLifecycleOwner) { types ->
            binding.rvInstructions.adapter = InstructionAdapter(types) { instruction ->
                viewModel.selectInstruction(instruction)
                buildParamForm(instruction.paramFields)
            }
        }

        viewModel.submitResult.observe(viewLifecycleOwner) { state ->
            when (state) {
                is PushInstructionViewModel.SubmitState.Loading -> binding.btnNext.isEnabled = false
                is PushInstructionViewModel.SubmitState.Success -> {
                    binding.btnNext.isEnabled = true
                    requireContext().showToast(getString(R.string.task_submit_success))
                    navigateToTaskDetail(state.response.traceId)
                }
                is PushInstructionViewModel.SubmitState.Error -> {
                    binding.btnNext.isEnabled = true
                    requireContext().showToast(state.message)
                }
                else -> binding.btnNext.isEnabled = true
            }
        }
    }

    private fun buildParamForm(fields: List<PushInstructionViewModel.ParamField>) {
        binding.layoutParams.removeAllViews()
        if (fields.isEmpty()) {
            binding.layoutParams.visibleIf(false)
            return
        }
        binding.layoutParams.visibleIf(true)

        for (field in fields) {
            val inputLayout = TextInputLayout(
                requireContext(),
                null,
                com.google.android.material.R.attr.textInputOutlinedStyle
            ).apply {
                layoutParams = ViewGroup.MarginLayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply { topMargin = 8 }
                hint = field.label
            }

            val editText = TextInputEditText(requireContext()).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
                inputType = when (field.type) {
                    PushInstructionViewModel.ParamFieldType.NUMBER -> InputType.TYPE_CLASS_NUMBER
                    else -> InputType.TYPE_CLASS_TEXT
                }
                doAfterTextChanged { text ->
                    viewModel.setParamValue(field.key, text?.toString().orEmpty())
                }
            }

            inputLayout.addView(editText)
            binding.layoutParams.addView(inputLayout)
        }
    }

    private fun navigateToTaskDetail(traceId: String) {
        try {
            val bundle = Bundle().apply { putString("traceId", traceId) }
            findNavController().navigate(
                R.id.action_pushInstruction_to_taskDetail, bundle
            )
        } catch (e: Exception) { /* nav not wired yet */ }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

/** Adapter for instruction type list with single selection */
private class InstructionAdapter(
    private val items: List<PushInstructionViewModel.InstructionType>,
    private val onSelected: (PushInstructionViewModel.InstructionType) -> Unit
) : RecyclerView.Adapter<InstructionAdapter.VH>() {

    private var selectedIndex = -1

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rb: RadioButton = itemView.findViewById(R.id.rbInstruction)
        val tvName: TextView = itemView.findViewById(R.id.tvInstructionName)
        val tvDesc: TextView = itemView.findViewById(R.id.tvInstructionDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_instruction, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        holder.tvName.text = item.name
        holder.tvDesc.text = item.description
        holder.rb.isChecked = position == selectedIndex

        val select = {
            val prev = selectedIndex
            selectedIndex = holder.bindingAdapterPosition
            if (prev >= 0) notifyItemChanged(prev)
            notifyItemChanged(selectedIndex)
            onSelected(item)
        }
        holder.rb.setOnClickListener { select() }
        holder.itemView.setOnClickListener { select() }
    }

    override fun getItemCount() = items.size
}
