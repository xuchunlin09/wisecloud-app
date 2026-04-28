package com.wisecloud.app.ui.wizard.instruction;

import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.wisecloud.app.R;
import com.wisecloud.app.databinding.FragmentPushInstructionWizardBinding;
import com.wisecloud.app.ui.wizard.common.DeviceTagSelectFragment;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0002J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0011H\u0016J\b\u0010\"\u001a\u00020\u0011H\u0002J\u001a\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010%\u001a\u00020\u0011H\u0002J\b\u0010&\u001a\u00020\u0011H\u0002J\b\u0010\'\u001a\u00020\u0011H\u0002J\b\u0010(\u001a\u00020\u0011H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u00a8\u0006)"}, d2 = {"Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionWizardFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/wisecloud/app/databinding/FragmentPushInstructionWizardBinding;", "binding", "getBinding", "()Lcom/wisecloud/app/databinding/FragmentPushInstructionWizardBinding;", "tagFragment", "Lcom/wisecloud/app/ui/wizard/common/DeviceTagSelectFragment;", "viewModel", "Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel;", "getViewModel", "()Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "buildParamForm", "", "fields", "", "Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel$ParamField;", "navigateToTaskDetail", "traceId", "", "observeViewModel", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onNextClicked", "onViewCreated", "view", "setupNavButtons", "setupStep2", "setupStep3", "setupStepIndicator", "app_debug"})
public final class PushInstructionWizardFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.wisecloud.app.databinding.FragmentPushInstructionWizardBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private com.wisecloud.app.ui.wizard.common.DeviceTagSelectFragment tagFragment;
    
    public PushInstructionWizardFragment() {
        super();
    }
    
    private final com.wisecloud.app.databinding.FragmentPushInstructionWizardBinding getBinding() {
        return null;
    }
    
    private final com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupStepIndicator() {
    }
    
    private final void setupStep2() {
    }
    
    private final void setupStep3() {
    }
    
    private final void setupNavButtons() {
    }
    
    private final void onNextClicked() {
    }
    
    private final void observeViewModel() {
    }
    
    private final void buildParamForm(java.util.List<com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.ParamField> fields) {
    }
    
    private final void navigateToTaskDetail(java.lang.String traceId) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}