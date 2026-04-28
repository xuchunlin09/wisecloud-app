package com.wisecloud.app.widget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.wisecloud.app.databinding.BottomSheetBatchMenuBinding

class BatchMenuBottomSheet : BottomSheetDialogFragment() {

    private var _binding: BottomSheetBatchMenuBinding? = null
    private val binding get() = _binding!!

    var onMenuItemSelected: ((MenuItem) -> Unit)? = null

    enum class MenuItem {
        APP_INSTALL,
        OTA_UPDATE,
        APP_UNINSTALL,
        PUSH_INSTRUCTION,
        WISEOS_SETTING
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetBatchMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.menuAppInstall.setOnClickListener {
            onMenuItemSelected?.invoke(MenuItem.APP_INSTALL)
            dismiss()
        }
        binding.menuOtaUpdate.setOnClickListener {
            onMenuItemSelected?.invoke(MenuItem.OTA_UPDATE)
            dismiss()
        }
        binding.menuAppUninstall.setOnClickListener {
            onMenuItemSelected?.invoke(MenuItem.APP_UNINSTALL)
            dismiss()
        }
        binding.menuPushInstruction.setOnClickListener {
            onMenuItemSelected?.invoke(MenuItem.PUSH_INSTRUCTION)
            dismiss()
        }
        binding.menuWiseosSetting.setOnClickListener {
            onMenuItemSelected?.invoke(MenuItem.WISEOS_SETTING)
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "BatchMenuBottomSheet"

        fun newInstance(): BatchMenuBottomSheet = BatchMenuBottomSheet()
    }
}
