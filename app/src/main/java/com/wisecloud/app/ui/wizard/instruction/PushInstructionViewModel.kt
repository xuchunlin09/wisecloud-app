package com.wisecloud.app.ui.wizard.instruction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wisecloud.app.data.model.request.InstructionTaskRequest
import com.wisecloud.app.data.model.response.TaskCreateResponse
import com.wisecloud.app.data.repository.TaskRepository
import com.wisecloud.app.data.repository.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PushInstructionViewModel @Inject constructor(
    private val taskRepository: TaskRepository
) : ViewModel() {

    companion object {
        const val STEP_CONFIG = 0
        const val STEP_SELECT_INSTRUCTION = 1
        const val STEP_SELECT_DEVICES = 2
    }

    data class InstructionType(
        val key: String,
        val name: String,
        val description: String,
        val paramFields: List<ParamField>
    )

    data class ParamField(
        val key: String,
        val label: String,
        val type: ParamFieldType = ParamFieldType.TEXT
    )

    enum class ParamFieldType { TEXT, NUMBER, BOOLEAN }

    private val _currentStep = MutableLiveData(STEP_CONFIG)
    val currentStep: LiveData<Int> = _currentStep

    // Step 1
    var taskName: String = "Push Instruction Task"

    // Step 2
    private val _instructionTypes = MutableLiveData<List<InstructionType>>()
    val instructionTypes: LiveData<List<InstructionType>> = _instructionTypes

    private val _selectedInstruction = MutableLiveData<InstructionType?>()
    val selectedInstruction: LiveData<InstructionType?> = _selectedInstruction

    val paramValues = mutableMapOf<String, Any>()

    // Step 3
    var selectedDeviceSnList: List<String> = emptyList()

    // Submission
    private val _submitResult = MutableLiveData<SubmitState>()
    val submitResult: LiveData<SubmitState> = _submitResult

    sealed class SubmitState {
        object Idle : SubmitState()
        object Loading : SubmitState()
        data class Success(val response: TaskCreateResponse) : SubmitState()
        data class Error(val message: String) : SubmitState()
    }

    fun nextStep() {
        val current = _currentStep.value ?: STEP_CONFIG
        if (current < STEP_SELECT_DEVICES) _currentStep.value = current + 1
    }

    fun previousStep() {
        val current = _currentStep.value ?: STEP_CONFIG
        if (current > STEP_CONFIG) _currentStep.value = current - 1
    }

    fun loadInstructionTypes() {
        _instructionTypes.value = listOf(
            InstructionType("reboot", "Reboot Device", "Remotely restart the device", emptyList()),
            InstructionType("enableAdb", "Enable ADB", "Enable ADB debugging mode",
                listOf(ParamField("timeout", "Timeout (minutes)", ParamFieldType.NUMBER))),
            InstructionType("disableAdb", "Disable ADB", "Disable ADB debugging mode", emptyList()),
            InstructionType("setVolume", "Set Volume", "Set device volume level",
                listOf(ParamField("level", "Volume Level (0-15)", ParamFieldType.NUMBER))),
            InstructionType("customCommand", "Custom Command", "Send a custom shell command",
                listOf(ParamField("command", "Shell Command", ParamFieldType.TEXT)))
        )
    }

    fun selectInstruction(instruction: InstructionType) {
        _selectedInstruction.value = instruction
        paramValues.clear()
    }

    fun setParamValue(key: String, value: Any) {
        paramValues[key] = value
    }

    fun submitTask() {
        val instruction = _selectedInstruction.value ?: return
        if (selectedDeviceSnList.isEmpty()) return

        _submitResult.value = SubmitState.Loading
        viewModelScope.launch {
            val request = InstructionTaskRequest(
                taskName = taskName,
                instructionKey = instruction.key,
                param = paramValues.toMap(),
                snList = selectedDeviceSnList
            )
            when (val result = taskRepository.createInstructionTask(request)) {
                is Result.Success -> _submitResult.value = SubmitState.Success(result.data)
                is Result.Error -> _submitResult.value = SubmitState.Error(result.message)
                is Result.NetworkError -> _submitResult.value = SubmitState.Error("Network error")
                is Result.Loading -> {}
            }
        }
    }
}
