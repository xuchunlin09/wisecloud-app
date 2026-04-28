package com.wisecloud.app.data.model.response

data class ApiResponse<T>(
    val code: Int,
    val message: String,
    val data: T?
)

data class PagedResponse<T>(
    val content: List<T>,
    val totalElements: Int,
    val totalPages: Int,
    val currentPage: Int
)

data class LoginResponse(
    val token: String,
    val expiresIn: Long,
    val username: String
)

data class DeviceOverviewResponse(
    val totalCount: Int,
    val onlineCount: Int,
    val onlineRate: String
)

data class DeviceSummary(
    val sn: String,
    val deviceName: String,
    val deviceType: String,
    val onlineStatus: Int,
    val lastOnlineTime: String
)

data class DeviceDetailResponse(
    val sn: String,
    val deviceName: String,
    val deviceType: String,
    val status: Int,
    val onlineStatus: Int,
    val activationTime: String,
    val lastOnlineTime: String,
    val otaVersionName: String,
    val otaVersion: String,
    val electricRate: String,
    val wifiStatus: Int,
    val gprsStatus: Int,
    val wifiSignalStrength: Int,
    val longitude: String,
    val latitude: String,
    val merchantName: String,
    val storeName: String,
    val installApps: List<InstalledApp>
)

data class InstalledApp(
    val appPackage: String,
    val appName: String,
    val versionName: String,
    val lastUpdateTime: String
)

data class ApplicationInfo(
    val appName: String,
    val appPackage: String,
    val appAlias: String,
    val appDescription: String?,
    val versions: List<AppVersion>
)

data class AppVersion(
    val versionMD5: String,
    val versionNumber: String,
    val versionName: String,
    val fileSize: Long,
    val uploadedAt: String
)

data class AppUploadResponse(
    val versionMD5: String,
    val versionNumber: String
)

data class TaskCreateResponse(
    val traceId: String,
    val taskName: String
)

data class TaskSummary(
    val traceId: String,
    val taskName: String,
    val taskType: String,
    val targetApp: String?,
    val deviceCount: Int,
    val completedCount: Int,
    val failedCount: Int,
    val progress: String,
    val createdAt: String,
    val createdBy: String?
)

data class TaskDetailResponse(
    val traceId: String,
    val taskName: String,
    val taskType: String,
    val statuses: List<TaskDeviceStatus>,
    val totalCount: Int,
    val currentPage: Int,
    val totalPages: Int
)

data class TaskDeviceStatus(
    val sn: String,
    val instructionStatus: Int,
    val executeCode: String?,
    val executeMessage: String?,
    val updatedAt: String?
)
