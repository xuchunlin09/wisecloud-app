package com.wisecloud.app.ui.task.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.wisecloud.app.data.model.response.TaskDetailResponse;
import com.wisecloud.app.data.model.response.TaskDeviceStatus;
import com.wisecloud.app.data.repository.Result;
import com.wisecloud.app.data.repository.TaskRepository;
import com.wisecloud.app.util.TaskProgressUtil;
import com.wisecloud.app.util.TaskStatusGroups;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001?B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u00102\u001a\u000203H\u0002J\u000e\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\u000bJ\b\u00106\u001a\u000203H\u0014J\u000e\u00107\u001a\u0002032\u0006\u00108\u001a\u00020\u000bJ\u000e\u00109\u001a\u0002032\u0006\u0010:\u001a\u00020\u0007J\u000e\u0010;\u001a\u0002032\u0006\u0010<\u001a\u00020\u0007J\u000e\u0010=\u001a\u0002032\u0006\u00105\u001a\u00020\u000bJ\u0006\u0010>\u001a\u000203R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00100\u00100\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00100\u00100\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u000e\u0010 \u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00100\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001dR\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0010\u0010\'\u001a\u0004\u0018\u00010(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00130\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u000e\u0010+\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00150\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00170\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u00070\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001d\u00a8\u0006@"}, d2 = {"Lcom/wisecloud/app/ui/task/detail/TaskDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "taskRepository", "Lcom/wisecloud/app/data/repository/TaskRepository;", "(Lcom/wisecloud/app/data/repository/TaskRepository;)V", "_currentPage", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "_currentTab", "_errorMessage", "", "_filteredDevices", "", "Lcom/wisecloud/app/data/model/response/TaskDeviceStatus;", "_isLoading", "", "_isPolling", "_progress", "Lcom/wisecloud/app/util/TaskProgressUtil$TaskProgress;", "_statusGroups", "Lcom/wisecloud/app/util/TaskStatusGroups;", "_taskDetail", "Lcom/wisecloud/app/data/model/response/TaskDetailResponse;", "_totalPages", "allStatuses", "currentPage", "Landroidx/lifecycle/LiveData;", "getCurrentPage", "()Landroidx/lifecycle/LiveData;", "currentTab", "getCurrentTab", "currentTraceId", "errorMessage", "getErrorMessage", "filteredDevices", "getFilteredDevices", "isLoading", "isPolling", "pollingJob", "Lkotlinx/coroutines/Job;", "progress", "getProgress", "snSearchQuery", "statusGroups", "getStatusGroups", "taskDetail", "getTaskDetail", "totalPages", "getTotalPages", "applySnFilter", "", "loadTaskDetails", "traceId", "onCleared", "onSnSearchChanged", "query", "setPage", "page", "setTab", "statusValue", "startPolling", "stopPolling", "Companion", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class TaskDetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.wisecloud.app.data.repository.TaskRepository taskRepository = null;
    public static final long POLL_INTERVAL_MS = 10000L;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.wisecloud.app.data.model.response.TaskDetailResponse> _taskDetail = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.wisecloud.app.data.model.response.TaskDetailResponse> taskDetail = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.wisecloud.app.util.TaskStatusGroups> _statusGroups = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.wisecloud.app.util.TaskStatusGroups> statusGroups = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.wisecloud.app.util.TaskProgressUtil.TaskProgress> _progress = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.wisecloud.app.util.TaskProgressUtil.TaskProgress> progress = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.wisecloud.app.data.model.response.TaskDeviceStatus>> _filteredDevices = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.wisecloud.app.data.model.response.TaskDeviceStatus>> filteredDevices = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isPolling = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isPolling = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _currentTab = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> currentTab = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _currentPage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> currentPage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _totalPages = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> totalPages = null;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job pollingJob;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String currentTraceId = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String snSearchQuery = "";
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.wisecloud.app.data.model.response.TaskDeviceStatus> allStatuses;
    @org.jetbrains.annotations.NotNull()
    public static final com.wisecloud.app.ui.task.detail.TaskDetailViewModel.Companion Companion = null;
    
    @javax.inject.Inject()
    public TaskDetailViewModel(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.repository.TaskRepository taskRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.wisecloud.app.data.model.response.TaskDetailResponse> getTaskDetail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.wisecloud.app.util.TaskStatusGroups> getStatusGroups() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.wisecloud.app.util.TaskProgressUtil.TaskProgress> getProgress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.wisecloud.app.data.model.response.TaskDeviceStatus>> getFilteredDevices() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isPolling() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getCurrentTab() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getCurrentPage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getTotalPages() {
        return null;
    }
    
    public final void loadTaskDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String traceId) {
    }
    
    public final void setTab(int statusValue) {
    }
    
    public final void setPage(int page) {
    }
    
    public final void onSnSearchChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    private final void applySnFilter() {
    }
    
    /**
     * Start polling every 10 seconds. Auto-stops when all devices reach terminal state.
     */
    public final void startPolling(@org.jetbrains.annotations.NotNull()
    java.lang.String traceId) {
    }
    
    public final void stopPolling() {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/wisecloud/app/ui/task/detail/TaskDetailViewModel$Companion;", "", "()V", "POLL_INTERVAL_MS", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}