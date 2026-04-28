package com.wisecloud.app.ui.wizard.uninstall;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.wisecloud.app.data.model.request.UninstallTaskRequest;
import com.wisecloud.app.data.model.response.ApplicationInfo;
import com.wisecloud.app.data.model.response.TaskCreateResponse;
import com.wisecloud.app.data.repository.ApplicationRepository;
import com.wisecloud.app.data.repository.TaskRepository;
import com.wisecloud.app.data.repository.Result;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 12\u00020\u0001:\u000212B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020+J\u0006\u0010-\u001a\u00020+J\u0006\u0010.\u001a\u00020+J\u000e\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020\u001aR\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u000f0\u000f0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0 \u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u001a\u0010%\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/wisecloud/app/ui/wizard/uninstall/BatchUninstallViewModel;", "Landroidx/lifecycle/ViewModel;", "applicationRepository", "Lcom/wisecloud/app/data/repository/ApplicationRepository;", "taskRepository", "Lcom/wisecloud/app/data/repository/TaskRepository;", "(Lcom/wisecloud/app/data/repository/ApplicationRepository;Lcom/wisecloud/app/data/repository/TaskRepository;)V", "_applications", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/wisecloud/app/data/model/response/ApplicationInfo;", "_currentStep", "", "kotlin.jvm.PlatformType", "_isLoadingApps", "", "_submitResult", "Lcom/wisecloud/app/ui/wizard/uninstall/BatchUninstallViewModel$SubmitState;", "applications", "Landroidx/lifecycle/LiveData;", "getApplications", "()Landroidx/lifecycle/LiveData;", "currentStep", "getCurrentStep", "isLoadingApps", "selectedDeviceSnList", "", "getSelectedDeviceSnList", "()Ljava/util/List;", "setSelectedDeviceSnList", "(Ljava/util/List;)V", "selectedPackages", "", "getSelectedPackages", "()Ljava/util/Set;", "submitResult", "getSubmitResult", "taskName", "getTaskName", "()Ljava/lang/String;", "setTaskName", "(Ljava/lang/String;)V", "loadApplications", "", "nextStep", "previousStep", "submitTask", "toggleAppSelection", "pkgName", "Companion", "SubmitState", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class BatchUninstallViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.wisecloud.app.data.repository.ApplicationRepository applicationRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.wisecloud.app.data.repository.TaskRepository taskRepository = null;
    public static final int STEP_CONFIG = 0;
    public static final int STEP_SELECT_APP = 1;
    public static final int STEP_SELECT_DEVICES = 2;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _currentStep = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> currentStep = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String taskName = "Uninstall Task";
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.wisecloud.app.data.model.response.ApplicationInfo>> _applications = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.wisecloud.app.data.model.response.ApplicationInfo>> applications = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoadingApps = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLoadingApps = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Set<java.lang.String> selectedPackages = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> selectedDeviceSnList;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.wisecloud.app.ui.wizard.uninstall.BatchUninstallViewModel.SubmitState> _submitResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.wisecloud.app.ui.wizard.uninstall.BatchUninstallViewModel.SubmitState> submitResult = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.wisecloud.app.ui.wizard.uninstall.BatchUninstallViewModel.Companion Companion = null;
    
    @javax.inject.Inject()
    public BatchUninstallViewModel(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.repository.ApplicationRepository applicationRepository, @org.jetbrains.annotations.NotNull()
    com.wisecloud.app.data.repository.TaskRepository taskRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getCurrentStep() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTaskName() {
        return null;
    }
    
    public final void setTaskName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.wisecloud.app.data.model.response.ApplicationInfo>> getApplications() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoadingApps() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Set<java.lang.String> getSelectedPackages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getSelectedDeviceSnList() {
        return null;
    }
    
    public final void setSelectedDeviceSnList(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.wisecloud.app.ui.wizard.uninstall.BatchUninstallViewModel.SubmitState> getSubmitResult() {
        return null;
    }
    
    public final void nextStep() {
    }
    
    public final void previousStep() {
    }
    
    public final void loadApplications() {
    }
    
    public final void toggleAppSelection(@org.jetbrains.annotations.NotNull()
    java.lang.String pkgName) {
    }
    
    public final void submitTask() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/wisecloud/app/ui/wizard/uninstall/BatchUninstallViewModel$Companion;", "", "()V", "STEP_CONFIG", "", "STEP_SELECT_APP", "STEP_SELECT_DEVICES", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/wisecloud/app/ui/wizard/uninstall/BatchUninstallViewModel$SubmitState;", "", "()V", "Error", "Idle", "Loading", "Success", "Lcom/wisecloud/app/ui/wizard/uninstall/BatchUninstallViewModel$SubmitState$Error;", "Lcom/wisecloud/app/ui/wizard/uninstall/BatchUninstallViewModel$SubmitState$Idle;", "Lcom/wisecloud/app/ui/wizard/uninstall/BatchUninstallViewModel$SubmitState$Loading;", "Lcom/wisecloud/app/ui/wizard/uninstall/BatchUninstallViewModel$SubmitState$Success;", "app_debug"})
    public static abstract class SubmitState {
        
        private SubmitState() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/wisecloud/app/ui/wizard/uninstall/BatchUninstallViewModel$SubmitState$Error;", "Lcom/wisecloud/app/ui/wizard/uninstall/BatchUninstallViewModel$SubmitState;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class Error extends com.wisecloud.app.ui.wizard.uninstall.BatchUninstallViewModel.SubmitState {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String message = null;
            
            public Error(@org.jetbrains.annotations.NotNull()
            java.lang.String message) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getMessage() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.wisecloud.app.ui.wizard.uninstall.BatchUninstallViewModel.SubmitState.Error copy(@org.jetbrains.annotations.NotNull()
            java.lang.String message) {
                return null;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override()
            @org.jetbrains.annotations.NotNull()
            public java.lang.String toString() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/wisecloud/app/ui/wizard/uninstall/BatchUninstallViewModel$SubmitState$Idle;", "Lcom/wisecloud/app/ui/wizard/uninstall/BatchUninstallViewModel$SubmitState;", "()V", "app_debug"})
        public static final class Idle extends com.wisecloud.app.ui.wizard.uninstall.BatchUninstallViewModel.SubmitState {
            @org.jetbrains.annotations.NotNull()
            public static final com.wisecloud.app.ui.wizard.uninstall.BatchUninstallViewModel.SubmitState.Idle INSTANCE = null;
            
            private Idle() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/wisecloud/app/ui/wizard/uninstall/BatchUninstallViewModel$SubmitState$Loading;", "Lcom/wisecloud/app/ui/wizard/uninstall/BatchUninstallViewModel$SubmitState;", "()V", "app_debug"})
        public static final class Loading extends com.wisecloud.app.ui.wizard.uninstall.BatchUninstallViewModel.SubmitState {
            @org.jetbrains.annotations.NotNull()
            public static final com.wisecloud.app.ui.wizard.uninstall.BatchUninstallViewModel.SubmitState.Loading INSTANCE = null;
            
            private Loading() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/wisecloud/app/ui/wizard/uninstall/BatchUninstallViewModel$SubmitState$Success;", "Lcom/wisecloud/app/ui/wizard/uninstall/BatchUninstallViewModel$SubmitState;", "response", "Lcom/wisecloud/app/data/model/response/TaskCreateResponse;", "(Lcom/wisecloud/app/data/model/response/TaskCreateResponse;)V", "getResponse", "()Lcom/wisecloud/app/data/model/response/TaskCreateResponse;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class Success extends com.wisecloud.app.ui.wizard.uninstall.BatchUninstallViewModel.SubmitState {
            @org.jetbrains.annotations.NotNull()
            private final com.wisecloud.app.data.model.response.TaskCreateResponse response = null;
            
            public Success(@org.jetbrains.annotations.NotNull()
            com.wisecloud.app.data.model.response.TaskCreateResponse response) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.wisecloud.app.data.model.response.TaskCreateResponse getResponse() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.wisecloud.app.data.model.response.TaskCreateResponse component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.wisecloud.app.ui.wizard.uninstall.BatchUninstallViewModel.SubmitState.Success copy(@org.jetbrains.annotations.NotNull()
            com.wisecloud.app.data.model.response.TaskCreateResponse response) {
                return null;
            }
            
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object other) {
                return false;
            }
            
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            @java.lang.Override()
            @org.jetbrains.annotations.NotNull()
            public java.lang.String toString() {
                return null;
            }
        }
    }
}