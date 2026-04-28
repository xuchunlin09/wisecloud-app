package com.wisecloud.app.data.repository

import com.wisecloud.app.data.api.MdmApiService
import com.wisecloud.app.data.model.response.ApplicationInfo
import com.wisecloud.app.data.model.response.AppUploadResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject
import javax.inject.Singleton

interface ApplicationRepository {
    suspend fun getApplicationList(): Result<List<ApplicationInfo>>
    suspend fun uploadApk(
        file: MultipartBody.Part,
        appAlias: RequestBody,
        appDescription: RequestBody?
    ): Result<AppUploadResponse>
}

@Singleton
class ApplicationRepositoryImpl @Inject constructor(
    private val apiService: MdmApiService
) : BaseRepository(), ApplicationRepository {

    override suspend fun getApplicationList(): Result<List<ApplicationInfo>> {
        return safeApiCall { apiService.getApplicationList() }
    }

    override suspend fun uploadApk(
        file: MultipartBody.Part,
        appAlias: RequestBody,
        appDescription: RequestBody?
    ): Result<AppUploadResponse> {
        return safeApiCall { apiService.uploadApk(file, appAlias, appDescription) }
    }
}
