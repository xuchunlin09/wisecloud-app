package com.wisecloud.app.ui.wizard.uninstall

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wisecloud.app.data.model.request.UninstallTaskRequest
import com.wisecloud.app.data.model.response.ApplicationInfo
import com.wisecloud.app.data.model.response.TaskCreateResponse
import com.wisecloud.app.data.repository.ApplicationRepository
import com.wisecloud.app.data.repository.TaskRepository
import com.wisecloud.app.data.repository.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BatchUninstallViewModel @Inject constructor(
    private val applicationRepository: ApplicationRepository,
    private val taskRepository: TaskRepository
) : ViewModel() {

    companion object {
        const val STEP_CONFIG = 0
        const val STEP_SELECT_APP = 1
        const val STEP_SELECT_DEVICES = 2
    }

    private val _currentStep = MutableLiveData(STEP_CONFIG)
    val currentStep: LiveData<Int> = _currentStep

    // Step 1
    var taskName: String = "Uninstall Task"

    // Step 2: Multi-select apps
    private val _applications = MutableLiveData<List<ApplicationInfo>>()
    val applications: LiveData<List<ApplicationInfo>> = _applications

    private val _isLoadingApps = MutableLiveData(false)
    val isLoadingApps: LiveData<Boolean> = _isLoadingApps

    val selectedPackages = mutableSetOf<String>()

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

    fun toggleAppSelection(pkgName: String) {
        if (pkgName in selectedPackages) selectedPackages.remove(pkgName)
        else selectedPackages.add(pkgName)
    }

    fun submitTask() {
        if (selectedPackages.isEmpty() || selectedDeviceSnList.isEmpty()) return

        _submitResult.value = SubmitState.Loading
        viewModelScope.launch {
            // Submit one uninstall task per selected package
            var lastResponse: TaskCreateResponse? = null
            var errorMsg: String? = null

            for (pkg in selectedPackages) {
                val request = UninstallTaskRequest(
                    taskName = taskName,
                    pkgName = pkg,
                    snList = selectedDeviceSnList
                )
                when (val result = taskRepository.createUninstallTask(request)) {
                    is Result.Success -> lastResponse = result.data
                    is Result.Error -> { errorMsg = result.message; break }
                    is Result.NetworkError -> { errorMsg = "Network error"; break }
                    is Result.Loading -> {}
                }
            }

            if (errorMsg != null) {
                _submitResult.value = SubmitState.Error(errorMsg!!)
            } else if (lastResponse != null) {
                _submitResult.value = SubmitState.Success(lastResponse!!)
            }
        }
    }
}
