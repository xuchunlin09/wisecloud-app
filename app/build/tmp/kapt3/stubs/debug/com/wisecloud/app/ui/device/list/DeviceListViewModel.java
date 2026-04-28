package com.wisecloud.app.ui.device.list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.wisecloud.app.data.model.response.DeviceSummary;
import com.wisecloud.app.data.repository.DeviceRepository;
import com.wisecloud.app.data.repository.Result;
import com.wisecloud.app.util.DeviceFilterUtil;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\'\u001a\u00020(J\u0010\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u0016H\u0002J\u000e\u0010+\u001a\u00020(2\u0006\u0010,\u001a\u00020\nJ\u0006\u0010-\u001a\u00020(J\u000e\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\u0012R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00120\u00120\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0017\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u000e\u0010!\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\f0\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00120\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0&X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/wisecloud/app/ui/device/list/DeviceListViewModel;", "Landroidx/lifecycle/ViewModel;", "deviceRepository", "Lcom/wisecloud/app/data/repository/DeviceRepository;", "(Lcom/wisecloud/app/data/repository/DeviceRepository;)V", "_devices", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/wisecloud/app/data/model/response/DeviceSummary;", "_errorMessage", "", "_hasMore", "", "kotlin.jvm.PlatformType", "_isEmpty", "_isLoading", "_isRefreshing", "_onlineFilter", "Lcom/wisecloud/app/util/DeviceFilterUtil$OnlineFilter;", "allDevices", "", "currentPage", "", "devices", "Landroidx/lifecycle/LiveData;", "getDevices", "()Landroidx/lifecycle/LiveData;", "errorMessage", "getErrorMessage", "hasMore", "getHasMore", "isEmpty", "isLoading", "isLoadingMore", "isRefreshing", "onlineFilter", "getOnlineFilter", "searchQuery", "Lkotlinx/coroutines/flow/MutableStateFlow;", "loadNextPage", "", "loadPage", "page", "onSearchQueryChanged", "query", "refresh", "setOnlineFilter", "filter", "Companion", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class DeviceListViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.wisecloud.app.data.repository.DeviceRepository deviceRepository = null;
    public static final int PAGE_SIZE = 20;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.wisecloud.app.data.model.response.DeviceSummary>> _devices = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.wisecloud.app.data.model.response.DeviceSummary>> devices = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isRefreshing = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isRefreshing = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isEmpty = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isEmpty = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _hasMore = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> hasMore = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.wisecloud.app.util.DeviceFilterUtil.OnlineFilter> _onlineFilter = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.wisecloud.app.util.DeviceFilterUtil.OnlineFilter> onlineFilter = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> searchQuery = null;
    private int currentPage = 1;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.wisecloud.app.data.model.response.DeviceSummary> allDevices;
    private boolean isLoadingMore = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.wisecloud.app.ui.device.list.DeviceListViewModel.Companion Companion = null;
    
    @javax.inject.Inject()
    public DeviceListViewModel(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.repository.DeviceRepository deviceRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.wisecloud.app.data.model.response.DeviceSummary>> getDevices() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isRefreshing() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isEmpty() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getHasMore() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.wisecloud.app.util.DeviceFilterUtil.OnlineFilter> getOnlineFilter() {
        return null;
    }
    
    public final void onSearchQueryChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    public final void setOnlineFilter(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.util.DeviceFilterUtil.OnlineFilter filter) {
    }
    
    public final void refresh() {
    }
    
    public final void loadNextPage() {
    }
    
    private final void loadPage(int page) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/wisecloud/app/ui/device/list/DeviceListViewModel$Companion;", "", "()V", "PAGE_SIZE", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}