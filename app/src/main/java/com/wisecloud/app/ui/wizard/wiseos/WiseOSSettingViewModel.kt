package com.wisecloud.app.ui.wizard.wiseos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wisecloud.app.data.model.request.WiseOSSettingRequest
import com.wisecloud.app.data.model.response.TaskCreateResponse
import com.wisecloud.app.data.repository.TaskRepository
import com.wisecloud.app.data.repository.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WiseOSSettingViewModel @Inject constructor(
    private val taskRepository: TaskRepository
) : ViewModel() {

    companion object {
        const val STEP_CONFIG = 0
        const val STEP_CONFIGURE_SETTINGS = 1
        const val STEP_SELECT_DEVICES = 2
    }

    data class SettingGroup(
        val title: String,
        val items: List<SettingItem>
    )

    data class SettingItem(
        val key: String,
        val label: String,
        val type: SettingType,
        val options: List<String> = emptyList() // for DROPDOWN type
    )

    enum class SettingType { SWITCH, DROPDOWN, TEXT }

    private val _currentStep = MutableLiveData(STEP_CONFIG)
    val currentStep: LiveData<Int> = _currentStep

    // Step 1
    var taskName: String = "WiseOS Setting Task"

    // Step 2: Settings
    private val _settingGroups = MutableLiveData<List<SettingGroup>>()
    val settingGroups: LiveData<List<SettingGroup>> = _settingGroups

    val settingValues = mutableMapOf<String, Any>()

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

    fun loadSettingGroups() {
        _settingGroups.value = listOf(
            SettingGroup("Network", listOf(
                SettingItem("wifi_enabled", "WiFi Enabled", SettingType.SWITCH),
                SettingItem("bluetooth_enabled", "Bluetooth Enabled", SettingType.SWITCH),
                SettingItem("proxy_host", "Proxy Host", SettingType.TEXT)
            )),
            SettingGroup("Security", listOf(
                SettingItem("screen_lock", "Screen Lock", SettingType.SWITCH),
                SettingItem("usb_debug", "USB Debugging", SettingType.SWITCH),
                SettingItem("install_from_unknown", "Install from Unknown Sources", SettingType.SWITCH)
            )),
            SettingGroup("Display", listOf(
                SettingItem("brightness", "Brightness Level", SettingType.TEXT),
                SettingItem("screen_timeout", "Screen Timeout", SettingType.DROPDOWN,
                    listOf("30s", "1min", "2min", "5min", "10min", "Never")),
                SettingItem("auto_rotate", "Auto Rotate", SettingType.SWITCH)
            ))
        )
    }

    fun setSettingValue(key: String, value: Any) {
        settingValues[key] = value
    }

    fun submitTask() {
        if (selectedDeviceSnList.isEmpty()) return

        _submitResult.value = SubmitState.Loading
        viewModelScope.launch {
            val request = WiseOSSettingRequest(
                taskName = taskName,
                settings = settingValues.toMap(),
                snList = selectedDeviceSnList
            )
            when (val result = taskRepository.createWiseOSSettingTask(request)) {
                is Result.Success -> _submitResult.value = SubmitState.Success(result.data)
                is Result.Error -> _submitResult.value = SubmitState.Error(result.message)
                is Result.NetworkError -> _submitResult.value = SubmitState.Error("Network error")
                is Result.Loading -> {}
            }
        }
    }
}
