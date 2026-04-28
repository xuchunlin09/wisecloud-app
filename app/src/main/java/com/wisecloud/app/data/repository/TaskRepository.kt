package com.wisecloud.app.data.repository

import com.wisecloud.app.data.api.MdmApiService
import com.wisecloud.app.data.model.request.*
import com.wisecloud.app.data.model.response.TaskCreateResponse
import com.wisecloud.app.data.model.response.TaskDetailResponse
import com.wisecloud.app.data.model.response.TaskSummary
import javax.inject.Inject
import javax.inject.Singleton

interface TaskRepository {
    suspend fun createInstallTask(request: InstallTaskRequest): Result<TaskCreateResponse>
    suspend fun createUninstallTask(request: UninstallTaskRequest): Result<TaskCreateResponse>
    suspend fun createOtaTask(request: OtaTaskRequest): Result<TaskCreateResponse>
    suspend fun createInstructionTask(request: InstructionTaskRequest): Result<TaskCreateResponse>
    suspend fun createWiseOSSettingTask(request: WiseOSSettingRequest): Result<TaskCreateResponse>
    suspend fun createFilePushTask(request: FilePushRequest): Result<TaskCreateResponse>
    suspend fun getTaskList(type: String? = null, keyword: String? = null): Result<List<TaskSummary>>
    suspend fun getTaskDetails(traceId: String, status: Int? = null, page: Int = 1): Result<TaskDetailResponse>
}

@Singleton
class TaskRepositoryImpl @Inject constructor(
    private val apiService: MdmApiService
) : BaseRepository(), TaskRepository {

    override suspend fun createInstallTask(request: InstallTaskRequest): Result<TaskCreateResponse> {
        return safeApiCall { apiService.createInstallTask(request) }
    }

    override suspend fun createUninstallTask(request: UninstallTaskRequest): Result<TaskCreateResponse> {
        return safeApiCall { apiService.createUninstallTask(request) }
    }

    override suspend fun createOtaTask(request: OtaTaskRequest): Result<TaskCreateResponse> {
        return safeApiCall { apiService.createOtaTask(request) }
    }

    override suspend fun createInstructionTask(request: InstructionTaskRequest): Result<TaskCreateResponse> {
        return safeApiCall { apiService.createInstructionTask(request) }
    }

    override suspend fun createWiseOSSettingTask(request: WiseOSSettingRequest): Result<TaskCreateResponse> {
        return safeApiCall { apiService.createWiseOSSettingTask(request) }
    }

    override suspend fun createFilePushTask(request: FilePushRequest): Result<TaskCreateResponse> {
        return safeApiCall { apiService.createFilePushTask(request) }
    }

    override suspend fun getTaskList(type: String?, keyword: String?): Result<List<TaskSummary>> {
        return safeApiCall { apiService.getTaskList(type, keyword) }
    }

    override suspend fun getTaskDetails(traceId: String, status: Int?, page: Int): Result<TaskDetailResponse> {
        return safeApiCall { apiService.getTaskDetails(traceId, status, page) }
    }
}
