package com.wisecloud.app.util

import com.wisecloud.app.data.local.TokenManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthInterceptor @Inject constructor(
    private val tokenManager: TokenManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()

        // Non-auth endpoints get JWT token attached automatically
        if (!originalRequest.url.encodedPath.contains("auth")) {
            tokenManager.getToken()?.let { token ->
                requestBuilder.addHeader("Authorization", "Bearer $token")
            }
        }

        val response = chain.proceed(requestBuilder.build())

        // 401: Token expired, clear and notify UI to redirect to login
        if (response.code == 401) {
            tokenManager.clearToken()
            TokenExpiredEvent.post()
        }

        return response
    }
}
