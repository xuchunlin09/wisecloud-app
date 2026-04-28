package com.wisecloud.app.ui.wizard.install

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wisecloud.app.data.model.request.InstallTaskRequest
import com.wisecloud.app.data.model.response.AppVersion
import com.wisecloud.app.data.model.response.ApplicationInfo
import com.wisecloud.app.data.model.response.TaskCreateResponse
import com.wisecloud.app.data.repository.ApplicationRepository
import com.wisecloud.app.data.repository.TaskRepository
import com.wisecloud.app.data.repository.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BatchInstallViewModel @Inject constructor(
    private val applicationRepository: ApplicationRepository,
    private val taskRepository: TaskRepository
) : ViewModel() {

    companion object {
        const val STEP_CONFIG = 0
        const val STEP_SELECT_APP = 1
        const val STEP_SELECT_DEVICES = 2
        const val TOTAL_STEPS = 3
    }

    private val _currentStep = MutableLiveData(STEP_CONFIG)
    val currentStep: LiveData<Int> = _currentStep

    // Step 1: Task Config
    var taskName: String = "Install Task"
    var wifiOnly: Boolean = false
    var idleTimeEnabled: Boolean = false
    var idleTimeFrom: String? = null
    var idleTimeTo: String? = null

    // Step 2: App Selection
    private val _applications = MutableLiveData<List<ApplicationInfo>>()
    val applications: LiveData<List<ApplicationInfo>> = _applications

    private val _selectedApp = MutableLiveData<ApplicationInfo?>()
    val selectedApp: LiveData<ApplicationInfo?> = _selectedApp

    private val _selectedVersion = MutableLiveData<AppVersion?>()
    val selectedVersion: LiveData<AppVersion?> = _selectedVersion

    private val _isLoadingApps = MutableLiveData(false)
    val isLoadingApps: LiveData<Boolean> = _isLoadingApps

    // Step 3: Device Tags
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
        if (current < STEP_SELECT_DEVICES) {
            _currentStep.value = current + 1
        }
    }

    fun previousStep() {
        val current = _currentStep.value ?: STEP_CONFIG
        if (current > STEP_CONFIG) {
            _currentStep.value = current - 1
        }
    }

    fun goToStep(step: Int) {
        _currentStep.value = step.coerceIn(STEP_CONFIG, STEP_SELECT_DEVICES)
    }

    fun loadApplications() {
        _isLoadingApps.value = true
        viewModelScope.launch {
            when (val result = applicationRepository.getApplicationList()) {
                is Result.Success -> _applications.value = result.data
                else -> _applications.value = emptyList()
            }
            _isLoadingApps.value = false
        }
    }

    fun selectApp(app: ApplicationInfo) {
        _selectedApp.value = app
        _selectedVersion.value = null
    }

    fun selectVersion(version: AppVersion) {
        _selectedVersion.value = version
    }

    fun submitTask() {
        val app = _selectedApp.value ?: return
        val version = _selectedVersion.value ?: return
        if (selectedDeviceSnList.isEmpty()) return

        _submitResult.value = SubmitState.Loading
        viewModelScope.launch {
            val request = InstallTaskRequest(
                taskName = taskName,
                versionMD5 = version.versionMD5,
                versionNumber = version.versionNumber,
                versionName = version.versionName,
                appName = app.appName,
                snList = selectedDeviceSnList,
                wifiOnly = wifiOnly,
                idleTimeEnabled = idleTimeEnabled,
                idleTimeFrom = idleTimeFrom,
                idleTimeTo = idleTimeTo
            )
            when (val result = taskRepository.createInstallTask(request)) {
                is Result.Success -> _submitResult.value = SubmitState.Success(result.data)
                is Result.Error -> _submitResult.value = SubmitState.Error(result.message)
                is Result.NetworkError -> _submitResult.value = SubmitState.Error("Network error")
                is Result.Loading -> { /* no-op */ }
            }
        }
    }
}
