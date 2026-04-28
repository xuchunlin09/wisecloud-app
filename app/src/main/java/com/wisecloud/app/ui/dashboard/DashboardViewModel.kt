package com.wisecloud.app.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wisecloud.app.data.local.TokenManager
import com.wisecloud.app.data.model.response.DailyActivity
import com.wisecloud.app.data.model.response.DeviceOverviewResponse
import com.wisecloud.app.data.model.response.DeviceSummary
import com.wisecloud.app.data.repository.DeviceRepository
import com.wisecloud.app.data.repository.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val deviceRepository: DeviceRepository,
    private val tokenManager: TokenManager
) : ViewModel() {

    val username: String get() = tokenManager.getUsername() ?: "User"

    private val _overview = MutableLiveData<DeviceOverviewResponse>()
    val overview: LiveData<DeviceOverviewResponse> = _overview

    private val _searchResults = MutableLiveData<List<DeviceSummary>>()
    val searchResults: LiveData<List<DeviceSummary>> = _searchResults

    private val _weeklyActivity = MutableLiveData<List<DailyActivity>>()
    val weeklyActivity: LiveData<List<DailyActivity>> = _weeklyActivity

    private val searchQuery = MutableStateFlow("")

    init {
        viewModelScope.launch {
            @OptIn(kotlinx.coroutines.FlowPreview::class)
            searchQuery
                .debounce(300)
                .filter { it.isNotBlank() }
                .collectLatest { query ->
                    when (val result = deviceRepository.searchDevices(query)) {
                        is Result.Success -> _searchResults.value = result.data
                        else -> _searchResults.value = emptyList()
                    }
                }
        }
    }

    fun onSearchQueryChanged(query: String) {
        searchQuery.value = query
        if (query.isBlank()) {
            _searchResults.value = emptyList()
        }
    }

    fun loadOverview() {
        viewModelScope.launch {
            when (val result = deviceRepository.getOverview()) {
                is Result.Success -> _overview.value = result.data
                else -> { /* error handling can be extended */ }
            }
        }
    }

    fun loadWeeklyActivity() {
        // Generate last 7 days placeholder data
        // In production this would come from an API endpoint
        val dateFormat = SimpleDateFormat("MM/dd", Locale.getDefault())
        val calendar = Calendar.getInstance()
        val activities = mutableListOf<DailyActivity>()

        for (i in 6 downTo 0) {
            val cal = Calendar.getInstance()
            cal.add(Calendar.DAY_OF_YEAR, -i)
            activities.add(
                DailyActivity(
                    date = dateFormat.format(cal.time),
                    activeCount = (10..100).random()
                )
            )
        }
        _weeklyActivity.value = activities
    }
}
