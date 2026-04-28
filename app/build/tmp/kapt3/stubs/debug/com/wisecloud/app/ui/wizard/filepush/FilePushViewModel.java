package com.wisecloud.app.ui.wizard.filepush;

import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.wisecloud.app.data.model.request.FilePushRequest;
import com.wisecloud.app.data.model.response.TaskCreateResponse;
import com.wisecloud.app.data.repository.TaskRepository;
import com.wisecloud.app.data.repository.Result;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\b\b\u0007\u0018\u0000 -2\u00020\u0001:\u0003-./B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\'\u001a\u00020(J\u0006\u0010)\u001a\u00020(J\u000e\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020\nJ\u0006\u0010,\u001a\u00020(R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0019\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0010R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0010R\u001a\u0010!\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016R\u001a\u0010$\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0014\"\u0004\b&\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/wisecloud/app/ui/wizard/filepush/FilePushViewModel;", "Landroidx/lifecycle/ViewModel;", "taskRepository", "Lcom/wisecloud/app/data/repository/TaskRepository;", "(Lcom/wisecloud/app/data/repository/TaskRepository;)V", "_currentStep", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "_selectedFile", "Lcom/wisecloud/app/ui/wizard/filepush/FilePushViewModel$SelectedFile;", "_submitResult", "Lcom/wisecloud/app/ui/wizard/filepush/FilePushViewModel$SubmitState;", "currentStep", "Landroidx/lifecycle/LiveData;", "getCurrentStep", "()Landroidx/lifecycle/LiveData;", "fileId", "", "getFileId", "()Ljava/lang/String;", "setFileId", "(Ljava/lang/String;)V", "selectedDeviceSnList", "", "getSelectedDeviceSnList", "()Ljava/util/List;", "setSelectedDeviceSnList", "(Ljava/util/List;)V", "selectedFile", "getSelectedFile", "submitResult", "getSubmitResult", "targetPath", "getTargetPath", "setTargetPath", "taskName", "getTaskName", "setTaskName", "nextStep", "", "previousStep", "setFile", "file", "submitTask", "Companion", "SelectedFile", "SubmitState", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class FilePushViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.wisecloud.app.data.repository.TaskRepository taskRepository = null;
    public static final int STEP_CONFIG = 0;
    public static final int STEP_SELECT_FILE = 1;
    public static final int STEP_SELECT_DEVICES = 2;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _currentStep = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> currentStep = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String taskName = "File Push Task";
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.wisecloud.app.ui.wizard.filepush.FilePushViewModel.SelectedFile> _selectedFile = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.wisecloud.app.ui.wizard.filepush.FilePushViewModel.SelectedFile> selectedFile = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String targetPath = "/sdcard/Download/";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fileId = "";
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> selectedDeviceSnList;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.wisecloud.app.ui.wizard.filepush.FilePushViewModel.SubmitState> _submitResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.wisecloud.app.ui.wizard.filepush.FilePushViewModel.SubmitState> submitResult = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.wisecloud.app.ui.wizard.filepush.FilePushViewModel.Companion Companion = null;
    
    @javax.inject.Inject()
    public FilePushViewModel(@org.jetbrains.annotations.NotNull()
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
    public final androidx.lifecycle.LiveData<com.wisecloud.app.ui.wizard.filepush.FilePushViewModel.SelectedFile> getSelectedFile() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTargetPath() {
        return null;
    }
    
    public final void setTargetPath(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFileId() {
        return null;
    }
    
    public final void setFileId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getSelectedDeviceSnList() {
        return null;
    }
    
    public final void setSelectedDeviceSnList(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.wisecloud.app.ui.wizard.filepush.FilePushViewModel.SubmitState> getSubmitResult() {
        return null;
    }
    
    public final void nextStep() {
    }
    
    public final void previousStep() {
    }
    
    public final void setFile(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.ui.wizard.filepush.FilePushViewModel.SelectedFile file) {
    }
    
    public final void submitTask() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/wisecloud/app/ui/wizard/filepush/FilePushViewModel$Companion;", "", "()V", "STEP_CONFIG", "", "STEP_SELECT_DEVICES", "STEP_SELECT_FILE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0007H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0005H\u00d6\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/wisecloud/app/ui/wizard/filepush/FilePushViewModel$SelectedFile;", "", "uri", "Landroid/net/Uri;", "name", "", "size", "", "mimeType", "(Landroid/net/Uri;Ljava/lang/String;JLjava/lang/String;)V", "getMimeType", "()Ljava/lang/String;", "getName", "getSize", "()J", "getUri", "()Landroid/net/Uri;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class SelectedFile {
        @org.jetbrains.annotations.NotNull()
        private final android.net.Uri uri = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String name = null;
        private final long size = 0L;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String mimeType = null;
        
        public SelectedFile(@org.jetbrains.annotations.NotNull()
        android.net.Uri uri, @org.jetbrains.annotations.NotNull()
        java.lang.String name, long size, @org.jetbrains.annotations.Nullable()
        java.lang.String mimeType) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.net.Uri getUri() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getName() {
            return null;
        }
        
        public final long getSize() {
            return 0L;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getMimeType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.net.Uri component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        public final long component3() {
            return 0L;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.wisecloud.app.ui.wizard.filepush.FilePushViewModel.SelectedFile copy(@org.jetbrains.annotations.NotNull()
        android.net.Uri uri, @org.jetbrains.annotations.NotNull()
        java.lang.String name, long size, @org.jetbrains.annotations.Nullable()
        java.lang.String mimeType) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/wisecloud/app/ui/wizard/filepush/FilePushViewModel$SubmitState;", "", "()V", "Error", "Idle", "Loading", "Success", "Lcom/wisecloud/app/ui/wizard/filepush/FilePushViewModel$SubmitState$Error;", "Lcom/wisecloud/app/ui/wizard/filepush/FilePushViewModel$SubmitState$Idle;", "Lcom/wisecloud/app/ui/wizard/filepush/FilePushViewModel$SubmitState$Loading;", "Lcom/wisecloud/app/ui/wizard/filepush/FilePushViewModel$SubmitState$Success;", "app_debug"})
    public static abstract class SubmitState {
        
        private SubmitState() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/wisecloud/app/ui/wizard/filepush/FilePushViewModel$SubmitState$Error;", "Lcom/wisecloud/app/ui/wizard/filepush/FilePushViewModel$SubmitState;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class Error extends com.wisecloud.app.ui.wizard.filepush.FilePushViewModel.SubmitState {
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
            public final com.wisecloud.app.ui.wizard.filepush.FilePushViewModel.SubmitState.Error copy(@org.jetbrains.annotations.NotNull()
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
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/wisecloud/app/ui/wizard/filepush/FilePushViewModel$SubmitState$Idle;", "Lcom/wisecloud/app/ui/wizard/filepush/FilePushViewModel$SubmitState;", "()V", "app_debug"})
        public static final class Idle extends com.wisecloud.app.ui.wizard.filepush.FilePushViewModel.SubmitState {
            @org.jetbrains.annotations.NotNull()
            public static final com.wisecloud.app.ui.wizard.filepush.FilePushViewModel.SubmitState.Idle INSTANCE = null;
            
            private Idle() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/wisecloud/app/ui/wizard/filepush/FilePushViewModel$SubmitState$Loading;", "Lcom/wisecloud/app/ui/wizard/filepush/FilePushViewModel$SubmitState;", "()V", "app_debug"})
        public static final class Loading extends com.wisecloud.app.ui.wizard.filepush.FilePushViewModel.SubmitState {
            @org.jetbrains.annotations.NotNull()
            public static final com.wisecloud.app.ui.wizard.filepush.FilePushViewModel.SubmitState.Loading INSTANCE = null;
            
            private Loading() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/wisecloud/app/ui/wizard/filepush/FilePushViewModel$SubmitState$Success;", "Lcom/wisecloud/app/ui/wizard/filepush/FilePushViewModel$SubmitState;", "response", "Lcom/wisecloud/app/data/model/response/TaskCreateResponse;", "(Lcom/wisecloud/app/data/model/response/TaskCreateResponse;)V", "getResponse", "()Lcom/wisecloud/app/data/model/response/TaskCreateResponse;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class Success extends com.wisecloud.app.ui.wizard.filepush.FilePushViewModel.SubmitState {
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
            public final com.wisecloud.app.ui.wizard.filepush.FilePushViewModel.SubmitState.Success copy(@org.jetbrains.annotations.NotNull()
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