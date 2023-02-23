package com.rs.data.model

sealed class Data<T> {
    class Success<T>(val data: T? = null) : Data<T>()
    class Error<T : Any?>(val error: ResponseError = ResponseError.None) : Data<T>()
}

sealed class ResponseError {
    object DoNotFound : ResponseError()
    object Unauthorized : ResponseError()
    object Server : ResponseError()
    object TimeOut : ResponseError()
    object Unknown : ResponseError()
    object None : ResponseError()
}
