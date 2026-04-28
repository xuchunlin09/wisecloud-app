package com.wisecloud.app.ui.wizard.wiseos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.wisecloud.app.data.model.request.WiseOSSettingRequest;
import com.wisecloud.app.data.model.response.TaskCreateResponse;
import com.wisecloud.app.data.repository.TaskRepository;
import com.wisecloud.app.data.repository.Result;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u0000 .2\u00020\u0001:\u0005./012B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010&\u001a\u00020\'J\u0006\u0010(\u001a\u00020\'J\u0006\u0010)\u001a\u00020\'J\u0016\u0010*\u001a\u00020\'2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u001cJ\u0006\u0010-\u001a\u00020\'R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u001d\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001c0\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0011R\u001a\u0010!\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/wisecloud/app/ui/wizard/wiseos/WiseOSSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "taskRepository", "Lcom/wisecloud/app/data/repository/TaskRepository;", "(Lcom/wisecloud/app/data/repository/TaskRepository;)V", "_currentStep", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "_settingGroups", "", "Lcom/wisecloud/app/ui/wizard/wiseos/WiseOSSettingViewModel$SettingGroup;", "_submitResult", "Lcom/wisecloud/app/ui/wizard/wiseos/WiseOSSettingViewModel$SubmitState;", "currentStep", "Landroidx/lifecycle/LiveData;", "getCurrentStep", "()Landroidx/lifecycle/LiveData;", "selectedDeviceSnList", "", "getSelectedDeviceSnList", "()Ljava/util/List;", "setSelectedDeviceSnList", "(Ljava/util/List;)V", "settingGroups", "getSettingGroups", "settingValues", "", "", "getSettingValues", "()Ljava/util/Map;", "submitResult", "getSubmitResult", "taskName", "getTaskName", "()Ljava/lang/String;", "setTaskName", "(Ljava/lang/String;)V", "loadSettingGroups", "", "nextStep", "previousStep", "setSettingValue", "key", "value", "submitTask", "Companion", "SettingGroup", "SettingItem", "SettingType", "SubmitState", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class WiseOSSettingViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.wisecloud.app.data.repository.TaskRepository taskRepository = null;
    public static final int STEP_CONFIG = 0;
    public static final int STEP_CONFIGURE_SETTINGS = 1;
    public static final int STEP_SELECT_DEVICES = 2;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _currentStep = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> currentStep = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String taskName = "WiseOS Setting Task";
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SettingGroup>> _settingGroups = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SettingGroup>> settingGroups = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.Object> settingValues = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> selectedDeviceSnList;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SubmitState> _submitResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SubmitState> submitResult = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.Companion Companion = null;
    
    @javax.inject.Inject()
    public WiseOSSettingViewModel(@org.jetbrains.annotations.NotNull()
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
    public final androidx.lifecycle.LiveData<java.util.List<com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SettingGroup>> getSettingGroups() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Object> getSettingValues() {
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
    public final androidx.lifecycle.LiveData<com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SubmitState> getSubmitResult() {
        return null;
    }
    
    public final void nextStep() {
    }
    
    public final void previousStep() {
    }
    
    public final void loadSettingGroups() {
    }
    
    public final void setSettingValue(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.lang.Object value) {
    }
    
    public final void submitTask() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/wisecloud/app/ui/wizard/wiseos/WiseOSSettingViewModel$Companion;", "", "()V", "STEP_CONFIG", "", "STEP_CONFIGURE_SETTINGS", "STEP_SELECT_DEVICES", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/wisecloud/app/ui/wizard/wiseos/WiseOSSettingViewModel$SettingGroup;", "", "title", "", "items", "", "Lcom/wisecloud/app/ui/wizard/wiseos/WiseOSSettingViewModel$SettingItem;", "(Ljava/lang/String;Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class SettingGroup {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String title = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SettingItem> items = null;
        
        public SettingGroup(@org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.util.List<com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SettingItem> items) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SettingItem> getItems() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SettingItem> component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SettingGroup copy(@org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.util.List<com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SettingItem> items) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u00c6\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bH\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/wisecloud/app/ui/wizard/wiseos/WiseOSSettingViewModel$SettingItem;", "", "key", "", "label", "type", "Lcom/wisecloud/app/ui/wizard/wiseos/WiseOSSettingViewModel$SettingType;", "options", "", "(Ljava/lang/String;Ljava/lang/String;Lcom/wisecloud/app/ui/wizard/wiseos/WiseOSSettingViewModel$SettingType;Ljava/util/List;)V", "getKey", "()Ljava/lang/String;", "getLabel", "getOptions", "()Ljava/util/List;", "getType", "()Lcom/wisecloud/app/ui/wizard/wiseos/WiseOSSettingViewModel$SettingType;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class SettingItem {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String key = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String label = null;
        @org.jetbrains.annotations.NotNull()
        private final com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SettingType type = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<java.lang.String> options = null;
        
        public SettingItem(@org.jetbrains.annotations.NotNull()
        java.lang.String key, @org.jetbrains.annotations.NotNull()
        java.lang.String label, @org.jetbrains.annotations.NotNull()
        com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SettingType type, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> options) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKey() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getLabel() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SettingType getType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getOptions() {
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
        public final com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SettingType component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SettingItem copy(@org.jetbrains.annotations.NotNull()
        java.lang.String key, @org.jetbrains.annotations.NotNull()
        java.lang.String label, @org.jetbrains.annotations.NotNull()
        com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SettingType type, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> options) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/wisecloud/app/ui/wizard/wiseos/WiseOSSettingViewModel$SettingType;", "", "(Ljava/lang/String;I)V", "SWITCH", "DROPDOWN", "TEXT", "app_debug"})
    public static enum SettingType {
        /*public static final*/ SWITCH /* = new SWITCH() */,
        /*public static final*/ DROPDOWN /* = new DROPDOWN() */,
        /*public static final*/ TEXT /* = new TEXT() */;
        
        SettingType() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SettingType> getEntries() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/wisecloud/app/ui/wizard/wiseos/WiseOSSettingViewModel$SubmitState;", "", "()V", "Error", "Idle", "Loading", "Success", "Lcom/wisecloud/app/ui/wizard/wiseos/WiseOSSettingViewModel$SubmitState$Error;", "Lcom/wisecloud/app/ui/wizard/wiseos/WiseOSSettingViewModel$SubmitState$Idle;", "Lcom/wisecloud/app/ui/wizard/wiseos/WiseOSSettingViewModel$SubmitState$Loading;", "Lcom/wisecloud/app/ui/wizard/wiseos/WiseOSSettingViewModel$SubmitState$Success;", "app_debug"})
    public static abstract class SubmitState {
        
        private SubmitState() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/wisecloud/app/ui/wizard/wiseos/WiseOSSettingViewModel$SubmitState$Error;", "Lcom/wisecloud/app/ui/wizard/wiseos/WiseOSSettingViewModel$SubmitState;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class Error extends com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SubmitState {
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
            public final com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SubmitState.Error copy(@org.jetbrains.annotations.NotNull()
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
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/wisecloud/app/ui/wizard/wiseos/WiseOSSettingViewModel$SubmitState$Idle;", "Lcom/wisecloud/app/ui/wizard/wiseos/WiseOSSettingViewModel$SubmitState;", "()V", "app_debug"})
        public static final class Idle extends com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SubmitState {
            @org.jetbrains.annotations.NotNull()
            public static final com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SubmitState.Idle INSTANCE = null;
            
            private Idle() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/wisecloud/app/ui/wizard/wiseos/WiseOSSettingViewModel$SubmitState$Loading;", "Lcom/wisecloud/app/ui/wizard/wiseos/WiseOSSettingViewModel$SubmitState;", "()V", "app_debug"})
        public static final class Loading extends com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SubmitState {
            @org.jetbrains.annotations.NotNull()
            public static final com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SubmitState.Loading INSTANCE = null;
            
            private Loading() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/wisecloud/app/ui/wizard/wiseos/WiseOSSettingViewModel$SubmitState$Success;", "Lcom/wisecloud/app/ui/wizard/wiseos/WiseOSSettingViewModel$SubmitState;", "response", "Lcom/wisecloud/app/data/model/response/TaskCreateResponse;", "(Lcom/wisecloud/app/data/model/response/TaskCreateResponse;)V", "getResponse", "()Lcom/wisecloud/app/data/model/response/TaskCreateResponse;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class Success extends com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SubmitState {
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
            public final com.wisecloud.app.ui.wizard.wiseos.WiseOSSettingViewModel.SubmitState.Success copy(@org.jetbrains.annotations.NotNull()
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