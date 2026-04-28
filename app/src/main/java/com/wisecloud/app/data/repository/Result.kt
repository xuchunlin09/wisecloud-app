package com.wisecloud.app.data.repository

sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val code: Int, val message: String) : Result<Nothing>()
    object NetworkError : Result<Nothing>()
    object Loading : Result<Nothing>()
}
