package com.wisecloud.app.ui.device.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wisecloud.app.data.model.response.DeviceDetailResponse
import com.wisecloud.app.data.repository.DeviceRepository
import com.wisecloud.app.data.repository.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeviceDetailViewModel @Inject constructor(
    private val deviceRepository: DeviceRepository
) : ViewModel() {

    private val _deviceDetail = MutableLiveData<DeviceDetailResponse>()
    val deviceDetail: LiveData<DeviceDetailResponse> = _deviceDetail

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    private val _lockResult = MutableLiveData<RemoteActionResult?>()
    val lockResult: LiveData<RemoteActionResult?> = _lockResult

    private val _chartPeriod = MutableLiveData(ChartPeriod.TODAY)
    val chartPeriod: LiveData<ChartPeriod> = _chartPeriod

    private var currentSn: String = ""

    fun loadDeviceDetail(sn: String) {
        currentSn = sn
        _isLoading.value = true
        viewModelScope.launch {
            when (val result = deviceRepository.getDeviceDetail(sn)) {
                is Result.Success -> {
                    _deviceDetail.value = result.data
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

    fun setChartPeriod(period: ChartPeriod) {
        _chartPeriod.value = period
    }

    fun confirmLockDevice() {
        performRemoteAction("lock")
    }

    fun confirmUnlockDevice() {
        performRemoteAction("unlock")
    }

    private fun performRemoteAction(action: String) {
        viewModelScope.launch {
            _lockResult.value = RemoteActionResult(action, isSuccess = true)
        }
    }

    fun clearActionResult() {
        _lockResult.value = null
    }
}

enum class ChartPeriod { TODAY, SEVEN_DAYS, THIRTY_DAYS }

data class RemoteActionResult(
    val action: String,
    val isSuccess: Boolean,
    val errorMessage: String? = null
)
