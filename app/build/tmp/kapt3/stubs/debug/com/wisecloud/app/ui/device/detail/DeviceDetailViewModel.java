package com.wisecloud.app.ui.device.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.wisecloud.app.data.model.response.DeviceDetailResponse;
import com.wisecloud.app.data.repository.DeviceRepository;
import com.wisecloud.app.data.repository.Result;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010 \u001a\u00020\u001eJ\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\fJ\u0010\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\fH\u0002J\u000e\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\u0007R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u000e0\u000e0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0019\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014\u00a8\u0006\'"}, d2 = {"Lcom/wisecloud/app/ui/device/detail/DeviceDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "deviceRepository", "Lcom/wisecloud/app/data/repository/DeviceRepository;", "(Lcom/wisecloud/app/data/repository/DeviceRepository;)V", "_chartPeriod", "Landroidx/lifecycle/MutableLiveData;", "Lcom/wisecloud/app/ui/device/detail/ChartPeriod;", "kotlin.jvm.PlatformType", "_deviceDetail", "Lcom/wisecloud/app/data/model/response/DeviceDetailResponse;", "_errorMessage", "", "_isLoading", "", "_lockResult", "Lcom/wisecloud/app/ui/device/detail/RemoteActionResult;", "chartPeriod", "Landroidx/lifecycle/LiveData;", "getChartPeriod", "()Landroidx/lifecycle/LiveData;", "currentSn", "deviceDetail", "getDeviceDetail", "errorMessage", "getErrorMessage", "isLoading", "lockResult", "getLockResult", "clearActionResult", "", "confirmLockDevice", "confirmUnlockDevice", "loadDeviceDetail", "sn", "performRemoteAction", "action", "setChartPeriod", "period", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class DeviceDetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.wisecloud.app.data.repository.DeviceRepository deviceRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.wisecloud.app.data.model.response.DeviceDetailResponse> _deviceDetail = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.wisecloud.app.data.model.response.DeviceDetailResponse> deviceDetail = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.wisecloud.app.ui.device.detail.RemoteActionResult> _lockResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.wisecloud.app.ui.device.detail.RemoteActionResult> lockResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.wisecloud.app.ui.device.detail.ChartPeriod> _chartPeriod = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.wisecloud.app.ui.device.detail.ChartPeriod> chartPeriod = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String currentSn = "";
    
    @javax.inject.Inject()
    public DeviceDetailViewModel(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.repository.DeviceRepository deviceRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.wisecloud.app.data.model.response.DeviceDetailResponse> getDeviceDetail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.wisecloud.app.ui.device.detail.RemoteActionResult> getLockResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.wisecloud.app.ui.device.detail.ChartPeriod> getChartPeriod() {
        return null;
    }
    
    public final void loadDeviceDetail(@org.jetbrains.annotations.NotNull()
    java.lang.String sn) {
    }
    
    public final void setChartPeriod(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.ui.device.detail.ChartPeriod period) {
    }
    
    public final void confirmLockDevice() {
    }
    
    public final void confirmUnlockDevice() {
    }
    
    private final void performRemoteAction(java.lang.String action) {
    }
    
    public final void clearActionResult() {
    }
}