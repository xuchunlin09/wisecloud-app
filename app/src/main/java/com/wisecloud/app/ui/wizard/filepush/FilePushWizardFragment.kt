package com.wisecloud.app.ui.wizard.filepush

import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.wisecloud.app.R
import com.wisecloud.app.databinding.FragmentFilePushWizardBinding
import com.wisecloud.app.ui.wizard.common.DeviceTagSelectFragment
import com.wisecloud.app.util.showToast
import com.wisecloud.app.util.visible
import com.wisecloud.app.util.visibleIf
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilePushWizardFragment : Fragment() {

    private var _binding: FragmentFilePushWizardBinding? = null
    private val binding get() = _binding!!

    private val viewModel: FilePushViewModel by viewModels()
    private var tagFragment: DeviceTagSelectFragment? = null

    private val filePickerLauncher = registerForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { handleFileSelected(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilePushWizardBinding.inflate(inflater, container, false)
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
        binding.etTargetPath.setText(viewModel.targetPath)
    }

    private fun setupStepIndicator() {
        binding.stepIndicator.setSteps(listOf(
            getString(R.string.step_task_config),
            getString(R.string.step_select_file),
            getString(R.string.step_select_devices)
        ))
    }

    private fun setupStep2() {
        binding.btnSelectFile.setOnClickListener {
            filePickerLauncher.launch("*/*")
        }
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

    private fun handleFileSelected(uri: Uri) {
        val cursor = requireContext().contentResolver.query(uri, null, null, null, null)
        cursor?.use {
            if (it.moveToFirst()) {
                val nameIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                val sizeIndex = it.getColumnIndex(OpenableColumns.SIZE)
                val name = if (nameIndex >= 0) it.getString(nameIndex) else "Unknown"
                val size = if (sizeIndex >= 0) it.getLong(sizeIndex) else 0L
                val mimeType = requireContext().contentResolver.getType(uri)

                val file = FilePushViewModel.SelectedFile(uri, name, size, mimeType)
                viewModel.setFile(file)
            }
        }
    }

    private fun onNextClicked() {
        when (viewModel.currentStep.value) {
            FilePushViewModel.STEP_CONFIG -> {
                viewModel.taskName = binding.etTaskName.text.toString().ifBlank { "File Push Task" }
                viewModel.nextStep()
            }
            FilePushViewModel.STEP_SELECT_FILE -> {
                if (viewModel.selectedFile.value == null) {
                    requireContext().showToast(getString(R.string.please_select_file))
                    return
                }
                viewModel.targetPath = binding.etTargetPath.text.toString().ifBlank { "/sdcard/Download/" }
                viewModel.nextStep()
            }
            FilePushViewModel.STEP_SELECT_DEVICES -> {
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
            binding.layoutStep1.visibleIf(step == FilePushViewModel.STEP_CONFIG)
            binding.layoutStep2.visibleIf(step == FilePushViewModel.STEP_SELECT_FILE)
            binding.layoutStep3.visibleIf(step == FilePushViewModel.STEP_SELECT_DEVICES)
            binding.btnPrevious.visibleIf(step > FilePushViewModel.STEP_CONFIG)
            binding.btnNext.text = if (step == FilePushViewModel.STEP_SELECT_DEVICES)
                getString(R.string.btn_submit) else getString(R.string.btn_next)
        }

        viewModel.selectedFile.observe(viewLifecycleOwner) { file ->
            if (file != null) {
                binding.cardFileInfo.visible()
                binding.tvFileName.text = file.name
                binding.tvFileSize.text = formatFileSize(file.size)
                binding.tvFileType.text = file.mimeType ?: getString(R.string.unknown_type)
            }
        }

        viewModel.submitResult.observe(viewLifecycleOwner) { state ->
            when (state) {
                is FilePushViewModel.SubmitState.Loading -> binding.btnNext.isEnabled = false
                is FilePushViewModel.SubmitState.Success -> {
                    binding.btnNext.isEnabled = true
                    requireContext().showToast(getString(R.string.task_submit_success))
                    navigateToTaskDetail(state.response.traceId)
                }
                is FilePushViewModel.SubmitState.Error -> {
                    binding.btnNext.isEnabled = true
                    requireContext().showToast(state.message)
                }
                else -> binding.btnNext.isEnabled = true
            }
        }
    }

    private fun formatFileSize(bytes: Long): String {
        return when {
            bytes >= 1_048_576 -> String.format("%.1f MB", bytes / 1_048_576.0)
            bytes >= 1024 -> String.format("%.1f KB", bytes / 1024.0)
            else -> "$bytes B"
        }
    }

    private fun navigateToTaskDetail(traceId: String) {
        try {
            val bundle = Bundle().apply { putString("traceId", traceId) }
            androidx.navigation.fragment.findNavController(this).navigate(
                R.id.action_filePush_to_taskDetail, bundle
            )
        } catch (e: Exception) { /* nav not wired yet */ }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
