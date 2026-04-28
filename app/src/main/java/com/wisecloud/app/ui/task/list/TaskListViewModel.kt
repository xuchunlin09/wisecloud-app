package com.wisecloud.app.ui.task.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wisecloud.app.data.model.response.TaskSummary
import com.wisecloud.app.data.repository.Result
import com.wisecloud.app.data.repository.TaskRepository
import com.wisecloud.app.util.TaskFilterUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(
    private val taskRepository: TaskRepository
) : ViewModel() {

    private val _tasks = MutableLiveData<List<TaskSummary>>(emptyList())
    val tasks: LiveData<List<TaskSummary>> = _tasks

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _isEmpty = MutableLiveData(false)
    val isEmpty: LiveData<Boolean> = _isEmpty

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    private val _selectedTab = MutableLiveData(NavTab.ALL)
    val selectedTab: LiveData<NavTab> = _selectedTab

    private val _selectedTypeFilter = MutableLiveData<String?>(null)
    val selectedTypeFilter: LiveData<String?> = _selectedTypeFilter

    private val _filterExpanded = MutableLiveData(false)
    val filterExpanded: LiveData<Boolean> = _filterExpanded

    private val searchQuery = MutableStateFlow("")

    private var allTasks = listOf<TaskSummary>()

    init {
        @OptIn(FlowPreview::class)
        viewModelScope.launch {
            searchQuery
                .debounce(300)
                .collectLatest { loadTasks() }
        }
    }

    fun onSearchQueryChanged(query: String) {
        searchQuery.value = query
    }

    fun setNavTab(tab: NavTab) {
        if (_selectedTab.value == tab) return
        _selectedTab.value = tab
        loadTasks()
    }

    fun setTypeFilter(type: String?) {
        _selectedTypeFilter.value = type
        applyFilters()
    }

    fun toggleFilterExpanded() {
        _filterExpanded.value = _filterExpanded.value != true
    }

    fun loadTasks() {
        _isLoading.value = true
        viewModelScope.launch {
            val keyword = searchQuery.value.trim().ifEmpty { null }
            when (val result = taskRepository.getTaskList(keyword = keyword)) {
                is Result.Success -> {
                    allTasks = result.data
                    applyFilters()
                    _errorMessage.value = null
                }
                is Result.Error -> {
                    _errorMessage.value = result.message
                    _isEmpty.value = allTasks.isEmpty()
                }
                is Result.NetworkError -> {
                    _errorMessage.value = "Network unavailable. Please check your connection."
                    _isEmpty.value = allTasks.isEmpty()
                }
                is Result.Loading -> { /* no-op */ }
            }
            _isLoading.value = false
        }
    }

    private fun applyFilters() {
        val filtered = TaskFilterUtil.filterByType(allTasks, _selectedTypeFilter.value)
        _tasks.value = filtered
        _isEmpty.value = filtered.isEmpty()
    }

    enum class NavTab { ALL, MY_FOLLOWING, PARTNER }

    companion object {
        val TYPE_FILTERS = listOf(
            null to "All",
            "ota" to "OTA update",
            "install" to "Push app",
            "instruction" to "Push instruction",
            "addDevice" to "Add device",
            "filepush" to "File push",
            "uninstall" to "App uninstall",
            "suspend" to "Suspend or resume"
        )
    }
}
