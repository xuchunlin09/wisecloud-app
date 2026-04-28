package com.wisecloud.app.ui.device.detail;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.wisecloud.app.R;
import com.wisecloud.app.data.model.response.DeviceDetailResponse;
import com.wisecloud.app.data.model.response.InstalledApp;
import com.wisecloud.app.databinding.BottomSheetInstalledAppsBinding;
import com.wisecloud.app.databinding.BottomSheetRemoteActionsBinding;
import com.wisecloud.app.databinding.FragmentDeviceDetailBinding;
import com.wisecloud.app.util.BatteryColorUtil;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0011H\u0002J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\u001a\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010 \u001a\u00020\u0011H\u0002J\b\u0010!\u001a\u00020\u0011H\u0002J\b\u0010\"\u001a\u00020\u0011H\u0002J\b\u0010#\u001a\u00020\u0011H\u0002J\u0018\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020&H\u0003J&\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020&2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00110,H\u0002J\u0016\u0010-\u001a\u00020\u00112\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/H\u0002J\b\u00101\u001a\u00020\u0011H\u0002J\u0010\u00102\u001a\u00020\u00112\u0006\u00103\u001a\u000204H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u00a8\u00065"}, d2 = {"Lcom/wisecloud/app/ui/device/detail/DeviceDetailFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/wisecloud/app/databinding/FragmentDeviceDetailBinding;", "binding", "getBinding", "()Lcom/wisecloud/app/databinding/FragmentDeviceDetailBinding;", "gridAdapter", "Lcom/wisecloud/app/ui/device/detail/InstalledAppGridAdapter;", "viewModel", "Lcom/wisecloud/app/ui/device/detail/DeviceDetailViewModel;", "getViewModel", "()Lcom/wisecloud/app/ui/device/detail/DeviceDetailViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "bindDeviceDetail", "", "detail", "Lcom/wisecloud/app/data/model/response/DeviceDetailResponse;", "observeViewModel", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupBackButton", "setupChartPeriodChips", "setupFab", "setupInstalledAppsGrid", "setupLeafletMap", "lat", "", "lng", "showConfirmDialog", "title", "message", "onConfirm", "Lkotlin/Function0;", "showInstalledAppsBottomSheet", "apps", "", "Lcom/wisecloud/app/data/model/response/InstalledApp;", "showRemoteActionsBottomSheet", "updateChart", "period", "Lcom/wisecloud/app/ui/device/detail/ChartPeriod;", "app_debug"})
public final class DeviceDetailFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.wisecloud.app.databinding.FragmentDeviceDetailBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.wisecloud.app.ui.device.detail.InstalledAppGridAdapter gridAdapter;
    
    public DeviceDetailFragment() {
        super();
    }
    
    private final com.wisecloud.app.databinding.FragmentDeviceDetailBinding getBinding() {
        return null;
    }
    
    private final com.wisecloud.app.ui.device.detail.DeviceDetailViewModel getViewModel() {
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
    
    private final void setupBackButton() {
    }
    
    private final void setupInstalledAppsGrid() {
    }
    
    private final void setupChartPeriodChips() {
    }
    
    private final void setupFab() {
    }
    
    private final void observeViewModel() {
    }
    
    private final void bindDeviceDetail(com.wisecloud.app.data.model.response.DeviceDetailResponse detail) {
    }
    
    @android.annotation.SuppressLint(value = {"SetJavaScriptEnabled"})
    private final void setupLeafletMap(java.lang.String lat, java.lang.String lng) {
    }
    
    private final void updateChart(com.wisecloud.app.ui.device.detail.ChartPeriod period) {
    }
    
    private final void showInstalledAppsBottomSheet(java.util.List<com.wisecloud.app.data.model.response.InstalledApp> apps) {
    }
    
    private final void showRemoteActionsBottomSheet() {
    }
    
    private final void showConfirmDialog(java.lang.String title, java.lang.String message, kotlin.jvm.functions.Function0<kotlin.Unit> onConfirm) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}