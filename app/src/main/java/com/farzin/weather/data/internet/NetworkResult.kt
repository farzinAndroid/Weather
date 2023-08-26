package com.farzin.weather.data.internet

sealed class NetworkResult<T>(
    val message: String? = null,
    val data: T? = null,
) {
    class Success<T>(message: String, data: T) : NetworkResult<T>(message, data)
    class Error<T>(message: String, data: T? = null) : NetworkResult<T>(message, data)
    class Loading<T> : NetworkResult<T>()
}