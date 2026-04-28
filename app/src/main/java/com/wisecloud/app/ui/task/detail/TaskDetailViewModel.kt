package com.wisecloud.app.ui.task.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wisecloud.app.data.model.response.TaskDetailResponse
import com.wisecloud.app.data.model.response.TaskDeviceStatus
import com.wisecloud.app.data.repository.Result
import com.wisecloud.app.data.repository.TaskRepository
import com.wisecloud.app.util.TaskProgressUtil
import com.wisecloud.app.util.TaskStatusGroups
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskDetailViewModel @Inject constructor(
    private val taskRepository: TaskRepository
) : ViewModel() {

    companion object {
        const val POLL_INTERVAL_MS = 10_000L
    }

    private val _taskDetail = MutableLiveData<TaskDetailResponse>()
    val taskDetail: LiveData<TaskDetailResponse> = _taskDetail

    private val _statusGroups = MutableLiveData<TaskStatusGroups>()
    val statusGroups: LiveData<TaskStatusGroups> = _statusGroups

    private val _progress = MutableLiveData<TaskProgressUtil.TaskProgress>()
    val progress: LiveData<TaskProgressUtil.TaskProgress> = _progress

    private val _filteredDevices = MutableLiveData<List<TaskDeviceStatus>>(emptyList())
    val filteredDevices: LiveData<List<TaskDeviceStatus>> = _filteredDevices

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _isPolling = MutableLiveData(false)
    val isPolling: LiveData<Boolean> = _isPolling

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    private val _currentTab = MutableLiveData(3) // default: Completed tab
    val currentTab: LiveData<Int> = _currentTab

    private val _currentPage = MutableLiveData(1)
    val currentPage: LiveData<Int> = _currentPage

    private val _totalPages = MutableLiveData(1)
    val totalPages: LiveData<Int> = _totalPages

    private var pollingJob: Job? = null
    private var currentTraceId: String = ""
    private var snSearchQuery: String = ""
    private var allStatuses: List<TaskDeviceStatus> = emptyList()

    fun loadTaskDetails(traceId: String) {
        currentTraceId = traceId
        _isLoading.value = true
        viewModelScope.launch {
            val statusFilter = _currentTab.value
            val page = _currentPage.value ?: 1
            when (val result = taskRepository.getTaskDetails(traceId, statusFilter, page)) {
                is Result.Success -> {
                    val data = result.data
                    _taskDetail.value = data
                    allStatuses = data.statuses
                    _statusGroups.value = TaskProgressUtil.groupByStatus(data.statuses)
                    _progress.value = TaskProgressUtil.calculateProgress(data.statuses)
                    _totalPages.value = data.totalPages
                    applySnFilter()
                    _errorMessage.value = null
                }
                is Result.Error -> {
                    _errorMessage.value = result.message
                }
                is Result.NetworkError -> {
                    _errorMessage.value = "Network unavailable. Please check your connection."
                }
                is Result.Loading -> { /* no-op */ }
            }
            _isLoading.value = false
        }
    }

    fun setTab(statusValue: Int) {
        if (_currentTab.value == statusValue) return
        _currentTab.value = statusValue
        _currentPage.value = 1
        loadTaskDetails(currentTraceId)
    }

    fun setPage(page: Int) {
        _currentPage.value = page
        loadTaskDetails(currentTraceId)
    }

    fun onSnSearchChanged(query: String) {
        snSearchQuery = query.trim()
        applySnFilter()
    }

    private fun applySnFilter() {
        val filtered = if (snSearchQuery.isEmpty()) {
            allStatuses
        } else {
            allStatuses.filter { it.sn.contains(snSearchQuery, ignoreCase = true) }
        }
        _filteredDevices.value = filtered
    }

    /**
     * Start polling every 10 seconds. Auto-stops when all devices reach terminal state.
     */
    fun startPolling(traceId: String) {
        currentTraceId = traceId
        pollingJob?.cancel()
        _isPolling.value = true
        pollingJob = viewModelScope.launch {
            while (isActive) {
                val statusFilter = _currentTab.value
                val page = _currentPage.value ?: 1
                when (val result = taskRepository.getTaskDetails(traceId, statusFilter, page)) {
                    is Result.Success -> {
                        val data = result.data
                        _taskDetail.value = data
                        allStatuses = data.statuses
                        _statusGroups.value = TaskProgressUtil.groupByStatus(data.statuses)
                        _progress.value = TaskProgressUtil.calculateProgress(data.statuses)
                        _totalPages.value = data.totalPages
                        applySnFilter()

                        if (TaskProgressUtil.isAllTerminal(data.statuses)) {
                            _isPolling.value = false
                            break
                        }
                    }
                    is Result.Error -> { /* continue polling */ }
                    is Result.NetworkError -> { /* continue polling */ }
                    is Result.Loading -> { /* no-op */ }
                }
                delay(POLL_INTERVAL_MS)
            }
        }
    }

    fun stopPolling() {
        pollingJob?.cancel()
        _isPolling.value = false
    }

    override fun onCleared() {
        super.onCleared()
        stopPolling()
    }
}
