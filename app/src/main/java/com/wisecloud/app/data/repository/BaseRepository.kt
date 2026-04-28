package com.wisecloud.app.data.repository

import com.wisecloud.app.data.model.response.ApiResponse
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class BaseRepository {

    protected suspend fun <T> safeApiCall(
        apiCall: suspend () -> ApiResponse<T>
    ): Result<T> = try {
        val response = apiCall()
        if (response.code == 200 && response.data != null) {
            Result.Success(response.data)
        } else {
            Result.Error(response.code, response.message)
        }
    } catch (e: UnknownHostException) {
        android.util.Log.e("API", "DNS resolution failed: ${e.message}")
        Result.NetworkError
    } catch (e: SocketTimeoutException) {
        android.util.Log.e("API", "Connection timed out: ${e.message}")
        Result.NetworkError
    } catch (e: IOException) {
        android.util.Log.e("API", "IO error: ${e.message}")
        Result.NetworkError
    } catch (e: HttpException) {
        Result.Error(e.code(), e.message())
    } catch (e: Exception) {
        android.util.Log.e("API", "Unknown error: ${e.message}")
        Result.Error(-1, e.message ?: "未知错误")
    }

    @Suppress("UNCHECKED_CAST")
    protected suspend fun safeApiCallUnit(
        apiCall: suspend () -> ApiResponse<Unit>
    ): Result<Unit> = try {
        val response = apiCall()
        if (response.code == 200) {
            Result.Success(Unit)
        } else {
            Result.Error(response.code, response.message)
        }
    } catch (e: UnknownHostException) {
        Result.NetworkError
    } catch (e: SocketTimeoutException) {
        Result.NetworkError
    } catch (e: IOException) {
        Result.NetworkError
    } catch (e: HttpException) {
        Result.Error(e.code(), e.message())
    } catch (e: Exception) {
        Result.Error(-1, e.message ?: "未知错误")
    }
}
