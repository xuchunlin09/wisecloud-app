package com.wisecloud.app.ui.task.list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.wisecloud.app.data.model.response.TaskSummary;
import com.wisecloud.app.data.repository.Result;
import com.wisecloud.app.data.repository.TaskRepository;
import com.wisecloud.app.util.TaskFilterUtil;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.FlowPreview;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 .2\u00020\u0001:\u0002./B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010$\u001a\u00020%H\u0002J\u0006\u0010&\u001a\u00020%J\u000e\u0010\'\u001a\u00020%2\u0006\u0010(\u001a\u00020\u0007J\u000e\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\u000eJ\u0010\u0010+\u001a\u00020%2\b\u0010,\u001a\u0004\u0018\u00010\u0007J\u0006\u0010-\u001a\u00020%R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000e0\u000e0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017\u00a8\u00060"}, d2 = {"Lcom/wisecloud/app/ui/task/list/TaskListViewModel;", "Landroidx/lifecycle/ViewModel;", "taskRepository", "Lcom/wisecloud/app/data/repository/TaskRepository;", "(Lcom/wisecloud/app/data/repository/TaskRepository;)V", "_errorMessage", "Landroidx/lifecycle/MutableLiveData;", "", "_filterExpanded", "", "kotlin.jvm.PlatformType", "_isEmpty", "_isLoading", "_selectedTab", "Lcom/wisecloud/app/ui/task/list/TaskListViewModel$NavTab;", "_selectedTypeFilter", "_tasks", "", "Lcom/wisecloud/app/data/model/response/TaskSummary;", "allTasks", "errorMessage", "Landroidx/lifecycle/LiveData;", "getErrorMessage", "()Landroidx/lifecycle/LiveData;", "filterExpanded", "getFilterExpanded", "isEmpty", "isLoading", "searchQuery", "Lkotlinx/coroutines/flow/MutableStateFlow;", "selectedTab", "getSelectedTab", "selectedTypeFilter", "getSelectedTypeFilter", "tasks", "getTasks", "applyFilters", "", "loadTasks", "onSearchQueryChanged", "query", "setNavTab", "tab", "setTypeFilter", "type", "toggleFilterExpanded", "Companion", "NavTab", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class TaskListViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.wisecloud.app.data.repository.TaskRepository taskRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.wisecloud.app.data.model.response.TaskSummary>> _tasks = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.wisecloud.app.data.model.response.TaskSummary>> tasks = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isEmpty = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isEmpty = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.wisecloud.app.ui.task.list.TaskListViewModel.NavTab> _selectedTab = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.wisecloud.app.ui.task.list.TaskListViewModel.NavTab> selectedTab = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _selectedTypeFilter = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> selectedTypeFilter = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _filterExpanded = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> filterExpanded = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> searchQuery = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.wisecloud.app.data.model.response.TaskSummary> allTasks;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<kotlin.Pair<java.lang.String, java.lang.String>> TYPE_FILTERS = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.wisecloud.app.ui.task.list.TaskListViewModel.Companion Companion = null;
    
    @javax.inject.Inject()
    public TaskListViewModel(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.repository.TaskRepository taskRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.wisecloud.app.data.model.response.TaskSummary>> getTasks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isEmpty() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.wisecloud.app.ui.task.list.TaskListViewModel.NavTab> getSelectedTab() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getSelectedTypeFilter() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> getFilterExpanded() {
        return null;
    }
    
    public final void onSearchQueryChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    public final void setNavTab(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.ui.task.list.TaskListViewModel.NavTab tab) {
    }
    
    public final void setTypeFilter(@org.jetbrains.annotations.Nullable()
    java.lang.String type) {
    }
    
    public final void toggleFilterExpanded() {
    }
    
    public final void loadTasks() {
    }
    
    private final void applyFilters() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R%\u0010\u0003\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/wisecloud/app/ui/task/list/TaskListViewModel$Companion;", "", "()V", "TYPE_FILTERS", "", "Lkotlin/Pair;", "", "getTYPE_FILTERS", "()Ljava/util/List;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<kotlin.Pair<java.lang.String, java.lang.String>> getTYPE_FILTERS() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/wisecloud/app/ui/task/list/TaskListViewModel$NavTab;", "", "(Ljava/lang/String;I)V", "ALL", "MY_FOLLOWING", "PARTNER", "app_debug"})
    public static enum NavTab {
        /*public static final*/ ALL /* = new ALL() */,
        /*public static final*/ MY_FOLLOWING /* = new MY_FOLLOWING() */,
        /*public static final*/ PARTNER /* = new PARTNER() */;
        
        NavTab() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.wisecloud.app.ui.task.list.TaskListViewModel.NavTab> getEntries() {
            return null;
        }
    }
}