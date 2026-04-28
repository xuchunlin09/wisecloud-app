package com.wisecloud.app.ui.wizard.filepush

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wisecloud.app.data.model.request.FilePushRequest
import com.wisecloud.app.data.model.response.TaskCreateResponse
import com.wisecloud.app.data.repository.TaskRepository
import com.wisecloud.app.data.repository.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilePushViewModel @Inject constructor(
    private val taskRepository: TaskRepository
) : ViewModel() {

    companion object {
        const val STEP_CONFIG = 0
        const val STEP_SELECT_FILE = 1
        const val STEP_SELECT_DEVICES = 2
    }

    private val _currentStep = MutableLiveData(STEP_CONFIG)
    val currentStep: LiveData<Int> = _currentStep

    // Step 1
    var taskName: String = "File Push Task"

    // Step 2: File selection
    data class SelectedFile(
        val uri: Uri,
        val name: String,
        val size: Long,
        val mimeType: String?
    )

    private val _selectedFile = MutableLiveData<SelectedFile?>()
    val selectedFile: LiveData<SelectedFile?> = _selectedFile

    var targetPath: String = "/sdcard/Download/"

    // For submission — in production, file would be uploaded first to get a fileId
    var fileId: String = ""

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

    fun setFile(file: SelectedFile) {
        _selectedFile.value = file
        // In production, upload file here and set fileId from response
        fileId = "uploaded_${file.name}"
    }

    fun submitTask() {
        if (fileId.isBlank() || selectedDeviceSnList.isEmpty()) return

        _submitResult.value = SubmitState.Loading
        viewModelScope.launch {
            val request = FilePushRequest(
                taskName = taskName,
                fileId = fileId,
                targetPath = targetPath,
                snList = selectedDeviceSnList
            )
            when (val result = taskRepository.createFilePushTask(request)) {
                is Result.Success -> _submitResult.value = SubmitState.Success(result.data)
                is Result.Error -> _submitResult.value = SubmitState.Error(result.message)
                is Result.NetworkError -> _submitResult.value = SubmitState.Error("Network error")
                is Result.Loading -> {}
            }
        }
    }
}
