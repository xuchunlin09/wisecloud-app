package com.wisecloud.app.ui.wizard.install;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;
import com.wisecloud.app.R;
import com.wisecloud.app.data.model.response.AppVersion;
import com.wisecloud.app.data.model.response.ApplicationInfo;
import com.wisecloud.app.databinding.FragmentBatchInstallWizardBinding;
import com.wisecloud.app.ui.wizard.common.DeviceTagSelectFragment;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016J\b\u0010 \u001a\u00020\u0013H\u0002J\u001a\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010#\u001a\u00020\u0013H\u0002J\b\u0010$\u001a\u00020\u0013H\u0002J\b\u0010%\u001a\u00020\u0013H\u0002J\b\u0010&\u001a\u00020\u0013H\u0002J\b\u0010\'\u001a\u00020\u0013H\u0002J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006+"}, d2 = {"Lcom/wisecloud/app/ui/wizard/install/BatchInstallWizardFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/wisecloud/app/databinding/FragmentBatchInstallWizardBinding;", "appAdapter", "Lcom/wisecloud/app/ui/wizard/install/AppListAdapter;", "binding", "getBinding", "()Lcom/wisecloud/app/databinding/FragmentBatchInstallWizardBinding;", "tagFragment", "Lcom/wisecloud/app/ui/wizard/common/DeviceTagSelectFragment;", "viewModel", "Lcom/wisecloud/app/ui/wizard/install/BatchInstallViewModel;", "getViewModel", "()Lcom/wisecloud/app/ui/wizard/install/BatchInstallViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "navigateToTaskDetail", "", "traceId", "", "observeViewModel", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onNextClicked", "onViewCreated", "view", "setupNavButtons", "setupStep1", "setupStep2", "setupStep3", "setupStepIndicator", "showTimePicker", "isFrom", "", "app_debug"})
public final class BatchInstallWizardFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.wisecloud.app.databinding.FragmentBatchInstallWizardBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.wisecloud.app.ui.wizard.install.AppListAdapter appAdapter;
    @org.jetbrains.annotations.Nullable()
    private com.wisecloud.app.ui.wizard.common.DeviceTagSelectFragment tagFragment;
    
    public BatchInstallWizardFragment() {
        super();
    }
    
    private final com.wisecloud.app.databinding.FragmentBatchInstallWizardBinding getBinding() {
        return null;
    }
    
    private final com.wisecloud.app.ui.wizard.install.BatchInstallViewModel getViewModel() {
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
    
    private final void setupStep1() {
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
    
    private final void showTimePicker(boolean isFrom) {
    }
    
    private final void navigateToTaskDetail(java.lang.String traceId) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}