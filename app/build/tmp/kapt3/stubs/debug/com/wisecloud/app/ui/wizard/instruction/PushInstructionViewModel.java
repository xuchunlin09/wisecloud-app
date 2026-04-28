package com.wisecloud.app.ui.wizard.instruction;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.wisecloud.app.data.model.request.InstructionTaskRequest;
import com.wisecloud.app.data.model.response.TaskCreateResponse;
import com.wisecloud.app.data.repository.TaskRepository;
import com.wisecloud.app.data.repository.Result;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 32\u00020\u0001:\u000534567B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020*J\u0006\u0010,\u001a\u00020*J\u000e\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020\u000bJ\u0016\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u0018J\u0006\u00102\u001a\u00020*R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00170\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0012R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0012R\u001a\u0010$\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel;", "Landroidx/lifecycle/ViewModel;", "taskRepository", "Lcom/wisecloud/app/data/repository/TaskRepository;", "(Lcom/wisecloud/app/data/repository/TaskRepository;)V", "_currentStep", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "_instructionTypes", "", "Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel$InstructionType;", "_selectedInstruction", "_submitResult", "Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel$SubmitState;", "currentStep", "Landroidx/lifecycle/LiveData;", "getCurrentStep", "()Landroidx/lifecycle/LiveData;", "instructionTypes", "getInstructionTypes", "paramValues", "", "", "", "getParamValues", "()Ljava/util/Map;", "selectedDeviceSnList", "getSelectedDeviceSnList", "()Ljava/util/List;", "setSelectedDeviceSnList", "(Ljava/util/List;)V", "selectedInstruction", "getSelectedInstruction", "submitResult", "getSubmitResult", "taskName", "getTaskName", "()Ljava/lang/String;", "setTaskName", "(Ljava/lang/String;)V", "loadInstructionTypes", "", "nextStep", "previousStep", "selectInstruction", "instruction", "setParamValue", "key", "value", "submitTask", "Companion", "InstructionType", "ParamField", "ParamFieldType", "SubmitState", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class PushInstructionViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.wisecloud.app.data.repository.TaskRepository taskRepository = null;
    public static final int STEP_CONFIG = 0;
    public static final int STEP_SELECT_INSTRUCTION = 1;
    public static final int STEP_SELECT_DEVICES = 2;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _currentStep = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> currentStep = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String taskName = "Push Instruction Task";
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.InstructionType>> _instructionTypes = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.InstructionType>> instructionTypes = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.InstructionType> _selectedInstruction = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.InstructionType> selectedInstruction = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.Object> paramValues = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> selectedDeviceSnList;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.SubmitState> _submitResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.SubmitState> submitResult = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.Companion Companion = null;
    
    @javax.inject.Inject()
    public PushInstructionViewModel(@org.jetbrains.annotations.NotNull()
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
    public final androidx.lifecycle.LiveData<java.util.List<com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.InstructionType>> getInstructionTypes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.InstructionType> getSelectedInstruction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Object> getParamValues() {
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
    public final androidx.lifecycle.LiveData<com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.SubmitState> getSubmitResult() {
        return null;
    }
    
    public final void nextStep() {
    }
    
    public final void previousStep() {
    }
    
    public final void loadInstructionTypes() {
    }
    
    public final void selectInstruction(@org.jetbrains.annotations.NotNull()
    com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.InstructionType instruction) {
    }
    
    public final void setParamValue(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.lang.Object value) {
    }
    
    public final void submitTask() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel$Companion;", "", "()V", "STEP_CONFIG", "", "STEP_SELECT_DEVICES", "STEP_SELECT_INSTRUCTION", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel$InstructionType;", "", "key", "", "name", "description", "paramFields", "", "Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel$ParamField;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getDescription", "()Ljava/lang/String;", "getKey", "getName", "getParamFields", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class InstructionType {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String key = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String name = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String description = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.ParamField> paramFields = null;
        
        public InstructionType(@org.jetbrains.annotations.NotNull()
        java.lang.String key, @org.jetbrains.annotations.NotNull()
        java.lang.String name, @org.jetbrains.annotations.NotNull()
        java.lang.String description, @org.jetbrains.annotations.NotNull()
        java.util.List<com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.ParamField> paramFields) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getKey() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDescription() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.ParamField> getParamFields() {
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
        public final java.util.List<com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.ParamField> component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.InstructionType copy(@org.jetbrains.annotations.NotNull()
        java.lang.String key, @org.jetbrains.annotations.NotNull()
        java.lang.String name, @org.jetbrains.annotations.NotNull()
        java.lang.String description, @org.jetbrains.annotations.NotNull()
        java.util.List<com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.ParamField> paramFields) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J\'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel$ParamField;", "", "key", "", "label", "type", "Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel$ParamFieldType;", "(Ljava/lang/String;Ljava/lang/String;Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel$ParamFieldType;)V", "getKey", "()Ljava/lang/String;", "getLabel", "getType", "()Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel$ParamFieldType;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class ParamField {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String key = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String label = null;
        @org.jetbrains.annotations.NotNull()
        private final com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.ParamFieldType type = null;
        
        public ParamField(@org.jetbrains.annotations.NotNull()
        java.lang.String key, @org.jetbrains.annotations.NotNull()
        java.lang.String label, @org.jetbrains.annotations.NotNull()
        com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.ParamFieldType type) {
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
        public final com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.ParamFieldType getType() {
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
        public final com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.ParamFieldType component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.ParamField copy(@org.jetbrains.annotations.NotNull()
        java.lang.String key, @org.jetbrains.annotations.NotNull()
        java.lang.String label, @org.jetbrains.annotations.NotNull()
        com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.ParamFieldType type) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel$ParamFieldType;", "", "(Ljava/lang/String;I)V", "TEXT", "NUMBER", "BOOLEAN", "app_debug"})
    public static enum ParamFieldType {
        /*public static final*/ TEXT /* = new TEXT() */,
        /*public static final*/ NUMBER /* = new NUMBER() */,
        /*public static final*/ BOOLEAN /* = new BOOLEAN() */;
        
        ParamFieldType() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.ParamFieldType> getEntries() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel$SubmitState;", "", "()V", "Error", "Idle", "Loading", "Success", "Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel$SubmitState$Error;", "Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel$SubmitState$Idle;", "Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel$SubmitState$Loading;", "Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel$SubmitState$Success;", "app_debug"})
    public static abstract class SubmitState {
        
        private SubmitState() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel$SubmitState$Error;", "Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel$SubmitState;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class Error extends com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.SubmitState {
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
            public final com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.SubmitState.Error copy(@org.jetbrains.annotations.NotNull()
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
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel$SubmitState$Idle;", "Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel$SubmitState;", "()V", "app_debug"})
        public static final class Idle extends com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.SubmitState {
            @org.jetbrains.annotations.NotNull()
            public static final com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.SubmitState.Idle INSTANCE = null;
            
            private Idle() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel$SubmitState$Loading;", "Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel$SubmitState;", "()V", "app_debug"})
        public static final class Loading extends com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.SubmitState {
            @org.jetbrains.annotations.NotNull()
            public static final com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.SubmitState.Loading INSTANCE = null;
            
            private Loading() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel$SubmitState$Success;", "Lcom/wisecloud/app/ui/wizard/instruction/PushInstructionViewModel$SubmitState;", "response", "Lcom/wisecloud/app/data/model/response/TaskCreateResponse;", "(Lcom/wisecloud/app/data/model/response/TaskCreateResponse;)V", "getResponse", "()Lcom/wisecloud/app/data/model/response/TaskCreateResponse;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class Success extends com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.SubmitState {
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
            public final com.wisecloud.app.ui.wizard.instruction.PushInstructionViewModel.SubmitState.Success copy(@org.jetbrains.annotations.NotNull()
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