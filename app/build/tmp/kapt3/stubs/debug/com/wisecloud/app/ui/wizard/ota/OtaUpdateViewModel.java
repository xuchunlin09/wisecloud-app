package com.wisecloud.app.ui.wizard.ota;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.wisecloud.app.data.model.request.OtaTaskRequest;
import com.wisecloud.app.data.model.response.TaskCreateResponse;
import com.wisecloud.app.data.repository.TaskRepository;
import com.wisecloud.app.data.repository.Result;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u0000 :2\u00020\u0001:\u0003:;<B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u000204J\u0006\u00106\u001a\u000204J\u000e\u00107\u001a\u0002042\u0006\u00108\u001a\u00020\u000bJ\u0006\u00109\u001a\u000204R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R \u0010$\u001a\b\u0012\u0004\u0012\u00020\u001c0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u0019\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0012R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0012R\u001a\u0010-\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001e\"\u0004\b/\u0010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u00100\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0018\"\u0004\b2\u0010\u001a\u00a8\u0006="}, d2 = {"Lcom/wisecloud/app/ui/wizard/ota/OtaUpdateViewModel;", "Landroidx/lifecycle/ViewModel;", "taskRepository", "Lcom/wisecloud/app/data/repository/TaskRepository;", "(Lcom/wisecloud/app/data/repository/TaskRepository;)V", "_currentStep", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "_firmwareList", "", "Lcom/wisecloud/app/ui/wizard/ota/OtaUpdateViewModel$FirmwareInfo;", "_selectedFirmware", "_submitResult", "Lcom/wisecloud/app/ui/wizard/ota/OtaUpdateViewModel$SubmitState;", "currentStep", "Landroidx/lifecycle/LiveData;", "getCurrentStep", "()Landroidx/lifecycle/LiveData;", "firmwareList", "getFirmwareList", "idleTimeEnabled", "", "getIdleTimeEnabled", "()Z", "setIdleTimeEnabled", "(Z)V", "idleTimeFrom", "", "getIdleTimeFrom", "()Ljava/lang/String;", "setIdleTimeFrom", "(Ljava/lang/String;)V", "idleTimeTo", "getIdleTimeTo", "setIdleTimeTo", "selectedDeviceSnList", "getSelectedDeviceSnList", "()Ljava/util/List;", "setSelectedDeviceSnList", "(Ljava/util/List;)V", "selectedFirmware", "getSelectedFirmware", "submitResult", "getSubmitResult", "taskName", "getTaskName", "setTaskName", "wifiOnly", "getWifiOnly", "setWifiOnly", "loadFirmwareList", "", "nextStep", "previousStep", "selectFirmware", "firmware", "submitTask", "Companion", "FirmwareInfo", "SubmitState", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class OtaUpdateViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.wisecloud.app.data.repository.TaskRepository taskRepository = null;
    public static final int STEP_CONFIG = 0;
    public static final int STEP_SELECT_FIRMWARE = 1;
    public static final int STEP_SELECT_DEVICES = 2;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _currentStep = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> currentStep = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String taskName = "OTA Update Task";
    private boolean wifiOnly = false;
    private boolean idleTimeEnabled = false;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String idleTimeFrom;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String idleTimeTo;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.wisecloud.app.ui.wizard.ota.OtaUpdateViewModel.FirmwareInfo>> _firmwareList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.wisecloud.app.ui.wizard.ota.OtaUpdateViewModel.FirmwareInfo>> firmwareList = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.wisecloud.app.ui.wizard.ota.OtaUpdateViewModel.FirmwareInfo> _selectedFirmware = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.wisecloud.app.ui.wizard.ota.OtaUpdateViewModel.FirmwareInfo> selectedFirmware = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> selectedDeviceSnList;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.wisecloud.app.ui.wizard.ota.OtaUpdateViewModel.SubmitState> _submitResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.wisecloud.app.ui.wizard.ota.OtaUpdateViewModel.SubmitState> submitResult = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.wisecloud.app.ui.wizard.ota.OtaUpdateViewModel.Companion Companion = null;
    
    @javax.inject.Inject()
    public OtaUpdateViewModel(@org.jetbrains.annotations.NotNull()
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
    
    public final boolean getWifiOnly() {
        return false;
    }
    
    public final void setWifiOnly(boolean p0) {
    }
    
    public final boolean getIdleTimeEnabled() {
        return false;
    }
    
    public final void setIdleTimeEnabled(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getIdleTimeFrom() {
        return null;
    }
    
    public final void setIdleTimeFrom(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getIdleTimeTo() {
        return null;
    }
    
    public final void setIdleTimeTo(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.wisecloud.app.ui.wizard.ota.OtaUpdateViewModel.FirmwareInfo>> getFirmwareList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.wisecloud.app.ui.wizard.ota.OtaUpdateViewModel.FirmwareInfo> getSelectedFirmware() {
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
    public final androidx.lifecycle.LiveData<com.wisecloud.app.ui.wizard.ota.OtaUpdateViewModel.SubmitState> getSubmitResult() {
        return null;
    }
    
    public final void nextStep() {
    }
    
    public final void previousStep() {
    }
    
    public final void loadFirmwareList() {
    }
    
    public final void selectFirmware(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.ui.wizard.ota.OtaUpdateViewModel.FirmwareInfo firmware) {
    }
    
    public final void submitTask() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/wisecloud/app/ui/wizard/ota/OtaUpdateViewModel$Companion;", "", "()V", "STEP_CONFIG", "", "STEP_SELECT_DEVICES", "STEP_SELECT_FIRMWARE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0018"}, d2 = {"Lcom/wisecloud/app/ui/wizard/ota/OtaUpdateViewModel$FirmwareInfo;", "", "id", "", "versionName", "releaseDate", "description", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getId", "getReleaseDate", "getVersionName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class FirmwareInfo {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String id = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String versionName = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String releaseDate = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String description = null;
        
        public FirmwareInfo(@org.jetbrains.annotations.NotNull()
        java.lang.String id, @org.jetbrains.annotations.NotNull()
        java.lang.String versionName, @org.jetbrains.annotations.NotNull()
        java.lang.String releaseDate, @org.jetbrains.annotations.NotNull()
        java.lang.String description) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getVersionName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getReleaseDate() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDescription() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.wisecloud.app.ui.wizard.ota.OtaUpdateViewModel.FirmwareInfo copy(@org.jetbrains.annotations.NotNull()
        java.lang.String id, @org.jetbrains.annotations.NotNull()
        java.lang.String versionName, @org.jetbrains.annotations.NotNull()
        java.lang.String releaseDate, @org.jetbrains.annotations.NotNull()
        java.lang.String description) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/wisecloud/app/ui/wizard/ota/OtaUpdateViewModel$SubmitState;", "", "()V", "Error", "Idle", "Loading", "Success", "Lcom/wisecloud/app/ui/wizard/ota/OtaUpdateViewModel$SubmitState$Error;", "Lcom/wisecloud/app/ui/wizard/ota/OtaUpdateViewModel$SubmitState$Idle;", "Lcom/wisecloud/app/ui/wizard/ota/OtaUpdateViewModel$SubmitState$Loading;", "Lcom/wisecloud/app/ui/wizard/ota/OtaUpdateViewModel$SubmitState$Success;", "app_debug"})
    public static abstract class SubmitState {
        
        private SubmitState() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/wisecloud/app/ui/wizard/ota/OtaUpdateViewModel$SubmitState$Error;", "Lcom/wisecloud/app/ui/wizard/ota/OtaUpdateViewModel$SubmitState;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class Error extends com.wisecloud.app.ui.wizard.ota.OtaUpdateViewModel.SubmitState {
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
            public final com.wisecloud.app.ui.wizard.ota.OtaUpdateViewModel.SubmitState.Error copy(@org.jetbrains.annotations.NotNull()
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
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/wisecloud/app/ui/wizard/ota/OtaUpdateViewModel$SubmitState$Idle;", "Lcom/wisecloud/app/ui/wizard/ota/OtaUpdateViewModel$SubmitState;", "()V", "app_debug"})
        public static final class Idle extends com.wisecloud.app.ui.wizard.ota.OtaUpdateViewModel.SubmitState {
            @org.jetbrains.annotations.NotNull()
            public static final com.wisecloud.app.ui.wizard.ota.OtaUpdateViewModel.SubmitState.Idle INSTANCE = null;
            
            private Idle() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/wisecloud/app/ui/wizard/ota/OtaUpdateViewModel$SubmitState$Loading;", "Lcom/wisecloud/app/ui/wizard/ota/OtaUpdateViewModel$SubmitState;", "()V", "app_debug"})
        public static final class Loading extends com.wisecloud.app.ui.wizard.ota.OtaUpdateViewModel.SubmitState {
            @org.jetbrains.annotations.NotNull()
            public static final com.wisecloud.app.ui.wizard.ota.OtaUpdateViewModel.SubmitState.Loading INSTANCE = null;
            
            private Loading() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/wisecloud/app/ui/wizard/ota/OtaUpdateViewModel$SubmitState$Success;", "Lcom/wisecloud/app/ui/wizard/ota/OtaUpdateViewModel$SubmitState;", "response", "Lcom/wisecloud/app/data/model/response/TaskCreateResponse;", "(Lcom/wisecloud/app/data/model/response/TaskCreateResponse;)V", "getResponse", "()Lcom/wisecloud/app/data/model/response/TaskCreateResponse;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class Success extends com.wisecloud.app.ui.wizard.ota.OtaUpdateViewModel.SubmitState {
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
            public final com.wisecloud.app.ui.wizard.ota.OtaUpdateViewModel.SubmitState.Success copy(@org.jetbrains.annotations.NotNull()
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