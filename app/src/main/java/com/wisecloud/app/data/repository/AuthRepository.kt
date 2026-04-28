package com.wisecloud.app.data.repository

import com.wisecloud.app.data.api.MdmApiService
import com.wisecloud.app.data.local.TokenManager
import com.wisecloud.app.data.model.request.LoginRequest
import com.wisecloud.app.data.model.request.RegisterRequest
import com.wisecloud.app.data.model.response.LoginResponse
import javax.inject.Inject
import javax.inject.Singleton

interface AuthRepository {
    suspend fun login(username: String, password: String): Result<LoginResponse>
    suspend fun register(username: String, password: String): Result<Unit>
    fun logout()
}

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val apiService: MdmApiService,
    private val tokenManager: TokenManager
) : BaseRepository(), AuthRepository {

    override suspend fun login(username: String, password: String): Result<LoginResponse> {
        val result = safeApiCall {
            apiService.login(LoginRequest(username, password))
        }
        if (result is Result.Success) {
            tokenManager.saveToken(result.data.token)
        }
        return result
    }

    override suspend fun register(username: String, password: String): Result<Unit> {
        return safeApiCallUnit {
            apiService.register(RegisterRequest(username, password))
        }
    }

    override fun logout() {
        tokenManager.clearToken()
    }
}
