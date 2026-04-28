package com.wisecloud.app.ui.wizard.ota

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wisecloud.app.data.model.request.OtaTaskRequest
import com.wisecloud.app.data.model.response.TaskCreateResponse
import com.wisecloud.app.data.repository.TaskRepository
import com.wisecloud.app.data.repository.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OtaUpdateViewModel @Inject constructor(
    private val taskRepository: TaskRepository
) : ViewModel() {

    companion object {
        const val STEP_CONFIG = 0
        const val STEP_SELECT_FIRMWARE = 1
        const val STEP_SELECT_DEVICES = 2
    }

    private val _currentStep = MutableLiveData(STEP_CONFIG)
    val currentStep: LiveData<Int> = _currentStep

    // Step 1
    var taskName: String = "OTA Update Task"
    var wifiOnly: Boolean = false
    var idleTimeEnabled: Boolean = false
    var idleTimeFrom: String? = null
    var idleTimeTo: String? = null

    // Step 2: Firmware selection
    data class FirmwareInfo(
        val id: String,
        val versionName: String,
        val releaseDate: String,
        val description: String
    )

    private val _firmwareList = MutableLiveData<List<FirmwareInfo>>()
    val firmwareList: LiveData<List<FirmwareInfo>> = _firmwareList

    private val _selectedFirmware = MutableLiveData<FirmwareInfo?>()
    val selectedFirmware: LiveData<FirmwareInfo?> = _selectedFirmware

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

    fun loadFirmwareList() {
        // In production, this would call an API endpoint
        _firmwareList.value = listOf(
            FirmwareInfo("fw1", "v2.1.0", "2024-01-15", "Security patches and performance improvements"),
            FirmwareInfo("fw2", "v2.0.5", "2024-01-01", "Bug fixes"),
            FirmwareInfo("fw3", "v2.0.0", "2023-12-15", "Major update with new features")
        )
    }

    fun selectFirmware(firmware: FirmwareInfo) {
        _selectedFirmware.value = firmware
    }

    fun submitTask() {
        val firmware = _selectedFirmware.value ?: return
        if (selectedDeviceSnList.isEmpty()) return

        _submitResult.value = SubmitState.Loading
        viewModelScope.launch {
            val request = OtaTaskRequest(
                taskName = taskName,
                firmwareId = firmware.id,
                snList = selectedDeviceSnList,
                wifiOnly = wifiOnly,
                idleTimeEnabled = idleTimeEnabled,
                idleTimeFrom = idleTimeFrom,
                idleTimeTo = idleTimeTo
            )
            when (val result = taskRepository.createOtaTask(request)) {
                is Result.Success -> _submitResult.value = SubmitState.Success(result.data)
                is Result.Error -> _submitResult.value = SubmitState.Error(result.message)
                is Result.NetworkError -> _submitResult.value = SubmitState.Error("Network error")
                is Result.Loading -> {}
            }
        }
    }
}
