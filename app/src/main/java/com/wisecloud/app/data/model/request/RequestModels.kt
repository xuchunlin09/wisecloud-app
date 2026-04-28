package com.wisecloud.app.data.model.request

data class LoginRequest(
    val username: String,
    val password: String
)

data class RegisterRequest(
    val username: String,
    val password: String
)

data class InstallTaskRequest(
    val taskName: String,
    val versionMD5: String,
    val versionNumber: String,
    val versionName: String?,
    val appName: String?,
    val snList: List<String>,
    val wifiOnly: Boolean = false,
    val idleTimeEnabled: Boolean = false,
    val idleTimeFrom: String? = null,
    val idleTimeTo: String? = null
)

data class UninstallTaskRequest(
    val taskName: String,
    val pkgName: String,
    val snList: List<String>
)

data class OtaTaskRequest(
    val taskName: String,
    val firmwareId: String,
    val snList: List<String>,
    val wifiOnly: Boolean = false,
    val idleTimeEnabled: Boolean = false,
    val idleTimeFrom: String? = null,
    val idleTimeTo: String? = null
)

data class InstructionTaskRequest(
    val taskName: String,
    val instructionKey: String,
    val param: Map<String, Any>,
    val snList: List<String>
)

data class WiseOSSettingRequest(
    val taskName: String,
    val settings: Map<String, Any>,
    val snList: List<String>
)

data class FilePushRequest(
    val taskName: String,
    val fileId: String,
    val targetPath: String,
    val snList: List<String>
)
