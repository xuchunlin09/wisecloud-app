package com.wisecloud.app.ui.device.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wisecloud.app.data.model.response.DeviceSummary
import com.wisecloud.app.data.repository.DeviceRepository
import com.wisecloud.app.data.repository.Result
import com.wisecloud.app.util.DeviceFilterUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeviceListViewModel @Inject constructor(
    private val deviceRepository: DeviceRepository
) : ViewModel() {

    companion object {
        const val PAGE_SIZE = 20
    }

    private val _devices = MutableLiveData<List<DeviceSummary>>(emptyList())
    val devices: LiveData<List<DeviceSummary>> = _devices

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _isRefreshing = MutableLiveData(false)
    val isRefreshing: LiveData<Boolean> = _isRefreshing

    private val _isEmpty = MutableLiveData(false)
    val isEmpty: LiveData<Boolean> = _isEmpty

    private val _hasMore = MutableLiveData(true)
    val hasMore: LiveData<Boolean> = _hasMore

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    private val _onlineFilter = MutableLiveData(DeviceFilterUtil.OnlineFilter.ALL)
    val onlineFilter: LiveData<DeviceFilterUtil.OnlineFilter> = _onlineFilter

    private val searchQuery = MutableStateFlow("")

    private var currentPage = 1
    private var allDevices = mutableListOf<DeviceSummary>()
    private var isLoadingMore = false

    init {
        viewModelScope.launch {
            @OptIn(kotlinx.coroutines.FlowPreview::class)
            searchQuery
                .debounce(300)
                .collectLatest {
                    refresh()
                }
        }
    }

    fun onSearchQueryChanged(query: String) {
        searchQuery.value = query
    }

    fun setOnlineFilter(filter: DeviceFilterUtil.OnlineFilter) {
        if (_onlineFilter.value == filter) return
        _onlineFilter.value = filter
        refresh()
    }

    fun refresh() {
        currentPage = 1
        allDevices.clear()
        _hasMore.value = true
        _isRefreshing.value = true
        loadPage(currentPage)
    }

    fun loadNextPage() {
        if (isLoadingMore || _hasMore.value != true) return
        currentPage++
        loadPage(currentPage)
    }

    private fun loadPage(page: Int) {
        if (page > 1) isLoadingMore = true else _isLoading.value = true

        viewModelScope.launch {
            val statusParam = when (_onlineFilter.value) {
                DeviceFilterUtil.OnlineFilter.ONLINE -> 1
                DeviceFilterUtil.OnlineFilter.OFFLINE -> 2
                else -> null
            }

            when (val result = deviceRepository.getDeviceList(page, statusParam)) {
                is Result.Success -> {
                    val pagedData = result.data
                    val newItems = pagedData.content

                    val query = searchQuery.value.trim()
                    val filtered = if (query.isNotEmpty()) {
                        newItems.filter { it.sn.contains(query, ignoreCase = true) }
                    } else {
                        newItems
                    }

                    if (page == 1) {
                        allDevices.clear()
                    }
                    allDevices.addAll(filtered)
                    _devices.value = allDevices.toList()
                    _hasMore.value = pagedData.currentPage < pagedData.totalPages
                    _isEmpty.value = allDevices.isEmpty()
                    _errorMessage.value = null
                }
                is Result.Error -> {
                    _errorMessage.value = result.message
                    if (page == 1) {
                        _isEmpty.value = allDevices.isEmpty()
                    }
                }
                is Result.NetworkError -> {
                    _errorMessage.value = "Network unavailable. Please check your connection."
                    if (page == 1) {
                        _isEmpty.value = allDevices.isEmpty()
                    }
                }
                is Result.Loading -> { /* no-op */ }
            }

            _isLoading.value = false
            _isRefreshing.value = false
            isLoadingMore = false
        }
    }
}
