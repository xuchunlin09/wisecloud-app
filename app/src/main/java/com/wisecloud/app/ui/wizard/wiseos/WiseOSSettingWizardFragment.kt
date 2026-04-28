package com.wisecloud.app.ui.wizard.wiseos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.LinearLayout
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.card.MaterialCardView
import com.google.android.material.materialswitch.MaterialSwitch
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.wisecloud.app.R
import com.wisecloud.app.databinding.FragmentWiseosSettingWizardBinding
import com.wisecloud.app.ui.wizard.common.DeviceTagSelectFragment
import com.wisecloud.app.util.showToast
import com.wisecloud.app.util.visibleIf
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.findNavController

@AndroidEntryPoint
class WiseOSSettingWizardFragment : Fragment() {

    private var _binding: FragmentWiseosSettingWizardBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WiseOSSettingViewModel by viewModels()
    private var tagFragment: DeviceTagSelectFragment? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWiseosSettingWizardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupStepIndicator()
        setupStep3()
        setupNavButtons()
        observeViewModel()

        binding.toolbar.setNavigationOnClickListener { requireActivity().onBackPressedDispatcher.onBackPressed() }
        binding.etTaskName.setText(viewModel.taskName)
    }

    private fun setupStepIndicator() {
        binding.stepIndicator.setSteps(listOf(
            getString(R.string.step_task_config),
            getString(R.string.step_configure_settings),
            getString(R.string.step_select_devices)
        ))
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
            WiseOSSettingViewModel.STEP_CONFIG -> {
                viewModel.taskName = binding.etTaskName.text.toString().ifBlank { "WiseOS Setting Task" }
                viewModel.nextStep()
                viewModel.loadSettingGroups()
            }
            WiseOSSettingViewModel.STEP_CONFIGURE_SETTINGS -> {
                viewModel.nextStep()
            }
            WiseOSSettingViewModel.STEP_SELECT_DEVICES -> {
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
            binding.layoutStep1.visibleIf(step == WiseOSSettingViewModel.STEP_CONFIG)
            binding.layoutStep2.visibleIf(step == WiseOSSettingViewModel.STEP_CONFIGURE_SETTINGS)
            binding.layoutStep3.visibleIf(step == WiseOSSettingViewModel.STEP_SELECT_DEVICES)
            binding.btnPrevious.visibleIf(step > WiseOSSettingViewModel.STEP_CONFIG)
            binding.btnNext.text = if (step == WiseOSSettingViewModel.STEP_SELECT_DEVICES)
                getString(R.string.btn_submit) else getString(R.string.btn_next)
        }

        viewModel.settingGroups.observe(viewLifecycleOwner) { groups ->
            buildSettingCards(groups)
        }

        viewModel.submitResult.observe(viewLifecycleOwner) { state ->
            when (state) {
                is WiseOSSettingViewModel.SubmitState.Loading -> binding.btnNext.isEnabled = false
                is WiseOSSettingViewModel.SubmitState.Success -> {
                    binding.btnNext.isEnabled = true
                    requireContext().showToast(getString(R.string.task_submit_success))
                    navigateToTaskDetail(state.response.traceId)
                }
                is WiseOSSettingViewModel.SubmitState.Error -> {
                    binding.btnNext.isEnabled = true
                    requireContext().showToast(state.message)
                }
                else -> binding.btnNext.isEnabled = true
            }
        }
    }

    private fun buildSettingCards(groups: List<WiseOSSettingViewModel.SettingGroup>) {
        binding.layoutSettingCards.removeAllViews()
        val dp16 = (16 * resources.displayMetrics.density).toInt()
        val dp8 = (8 * resources.displayMetrics.density).toInt()

        for (group in groups) {
            val card = MaterialCardView(requireContext()).apply {
                layoutParams = ViewGroup.MarginLayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply { bottomMargin = dp16 }
                radius = dp8.toFloat()
                cardElevation = (2 * resources.displayMetrics.density)
            }

            val cardContent = LinearLayout(requireContext()).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(dp16, dp16, dp16, dp16)
            }

            // Group title
            val titleView = android.widget.TextView(requireContext()).apply {
                text = group.title
                textSize = 16f
                setTypeface(typeface, android.graphics.Typeface.BOLD)
                setPadding(0, 0, 0, dp8)
            }
            cardContent.addView(titleView)

            // Setting items
            for (item in group.items) {
                when (item.type) {
                    WiseOSSettingViewModel.SettingType.SWITCH -> {
                        val switch = MaterialSwitch(requireContext()).apply {
                            text = item.label
                            layoutParams = ViewGroup.MarginLayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT
                            ).apply { topMargin = dp8 }
                            setOnCheckedChangeListener { _, checked ->
                                viewModel.setSettingValue(item.key, checked)
                            }
                        }
                        cardContent.addView(switch)
                    }
                    WiseOSSettingViewModel.SettingType.DROPDOWN -> {
                        val inputLayout = TextInputLayout(
                            requireContext(),
                            null,
                            com.google.android.material.R.attr.textInputOutlinedExposedDropdownMenuStyle
                        ).apply {
                            layoutParams = ViewGroup.MarginLayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT
                            ).apply { topMargin = dp8 }
                            hint = item.label
                        }
                        val autoComplete = AutoCompleteTextView(requireContext()).apply {
                            layoutParams = ViewGroup.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT
                            )
                            setAdapter(ArrayAdapter(requireContext(),
                                android.R.layout.simple_dropdown_item_1line, item.options))
                            setOnItemClickListener { _, _, pos, _ ->
                                viewModel.setSettingValue(item.key, item.options[pos])
                            }
                        }
                        inputLayout.addView(autoComplete)
                        cardContent.addView(inputLayout)
                    }
                    WiseOSSettingViewModel.SettingType.TEXT -> {
                        val inputLayout = TextInputLayout(
                            requireContext(),
                            null,
                            com.google.android.material.R.attr.textInputOutlinedStyle
                        ).apply {
                            layoutParams = ViewGroup.MarginLayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT
                            ).apply { topMargin = dp8 }
                            hint = item.label
                        }
                        val editText = TextInputEditText(requireContext()).apply {
                            layoutParams = ViewGroup.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT
                            )
                            doAfterTextChanged { text ->
                                viewModel.setSettingValue(item.key, text?.toString().orEmpty())
                            }
                        }
                        inputLayout.addView(editText)
                        cardContent.addView(inputLayout)
                    }
                }
            }

            card.addView(cardContent)
            binding.layoutSettingCards.addView(card)
        }
    }

    private fun navigateToTaskDetail(traceId: String) {
        try {
            val bundle = Bundle().apply { putString("traceId", traceId) }
            findNavController().navigate(
                R.id.action_wiseosSetting_to_taskDetail, bundle
            )
        } catch (e: Exception) { /* nav not wired yet */ }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
