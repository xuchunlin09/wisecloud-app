package com.wisecloud.app.data.api

import com.wisecloud.app.data.model.request.*
import com.wisecloud.app.data.model.response.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

interface MdmApiService {

    // ===== 认证 =====
    @POST("api/auth/login")
    suspend fun login(@Body request: LoginRequest): ApiResponse<LoginResponse>

    @POST("api/auth/register")
    suspend fun register(@Body request: RegisterRequest): ApiResponse<Unit>

    // ===== 设备 =====
    @GET("api/devices/overview")
    suspend fun getDeviceOverview(): ApiResponse<DeviceOverviewResponse>

    @GET("api/devices/search")
    suspend fun searchDevices(@Query("keyword") keyword: String): ApiResponse<List<DeviceSummary>>

    @GET("api/devices")
    suspend fun getDeviceList(
        @Query("page") page: Int,
        @Query("size") size: Int = 20,
        @Query("status") status: Int? = null
    ): ApiResponse<PagedResponse<DeviceSummary>>

    @GET("api/devices/{sn}/detail")
    suspend fun getDeviceDetail(@Path("sn") sn: String): ApiResponse<DeviceDetailResponse>

    // ===== 应用 =====
    @GET("api/applications")
    suspend fun getApplicationList(): ApiResponse<List<ApplicationInfo>>

    @Multipart
    @POST("api/applications/upload")
    suspend fun uploadApk(
        @Part file: MultipartBody.Part,
        @Part("appAlias") appAlias: RequestBody,
        @Part("appDescription") appDescription: RequestBody?
    ): ApiResponse<AppUploadResponse>

    // ===== 任务 =====
    @POST("api/tasks/install")
    suspend fun createInstallTask(@Body request: InstallTaskRequest): ApiResponse<TaskCreateResponse>

    @POST("api/tasks/uninstall")
    suspend fun createUninstallTask(@Body request: UninstallTaskRequest): ApiResponse<TaskCreateResponse>

    @POST("api/tasks/ota")
    suspend fun createOtaTask(@Body request: OtaTaskRequest): ApiResponse<TaskCreateResponse>

    @POST("api/tasks/instruction")
    suspend fun createInstructionTask(@Body request: InstructionTaskRequest): ApiResponse<TaskCreateResponse>

    @POST("api/tasks/wiseos-setting")
    suspend fun createWiseOSSettingTask(@Body request: WiseOSSettingRequest): ApiResponse<TaskCreateResponse>

    @POST("api/tasks/file-push")
    suspend fun createFilePushTask(@Body request: FilePushRequest): ApiResponse<TaskCreateResponse>

    @GET("api/tasks")
    suspend fun getTaskList(
        @Query("type") type: String? = null,
        @Query("keyword") keyword: String? = null
    ): ApiResponse<List<TaskSummary>>

    @GET("api/tasks/{traceId}/details")
    suspend fun getTaskDetails(
        @Path("traceId") traceId: String,
        @Query("status") status: Int? = null,
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 20
    ): ApiResponse<TaskDetailResponse>
}
