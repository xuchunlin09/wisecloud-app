package com.wisecloud.app.data.repository

import com.wisecloud.app.data.api.MdmApiService
import com.wisecloud.app.data.model.response.DeviceDetailResponse
import com.wisecloud.app.data.model.response.DeviceOverviewResponse
import com.wisecloud.app.data.model.response.DeviceSummary
import com.wisecloud.app.data.model.response.PagedResponse
import javax.inject.Inject
import javax.inject.Singleton

interface DeviceRepository {
    suspend fun getOverview(): Result<DeviceOverviewResponse>
    suspend fun searchDevices(keyword: String): Result<List<DeviceSummary>>
    suspend fun getDeviceList(page: Int, status: Int? = null): Result<PagedResponse<DeviceSummary>>
    suspend fun getDeviceDetail(sn: String): Result<DeviceDetailResponse>
}

@Singleton
class DeviceRepositoryImpl @Inject constructor(
    private val apiService: MdmApiService
) : BaseRepository(), DeviceRepository {

    override suspend fun getOverview(): Result<DeviceOverviewResponse> {
        return safeApiCall { apiService.getDeviceOverview() }
    }

    override suspend fun searchDevices(keyword: String): Result<List<DeviceSummary>> {
        return safeApiCall { apiService.searchDevices(keyword) }
    }

    override suspend fun getDeviceList(page: Int, status: Int?): Result<PagedResponse<DeviceSummary>> {
        return safeApiCall { apiService.getDeviceList(page = page, status = status) }
    }

    override suspend fun getDeviceDetail(sn: String): Result<DeviceDetailResponse> {
        return safeApiCall { apiService.getDeviceDetail(sn) }
    }
}
