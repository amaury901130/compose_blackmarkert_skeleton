package com.rs.data.model

sealed class Data<T> {
    class Success<T>(val data: T? = null) : Data<T>()
    class Error<T>(
        val error: ResponseError = ResponseError.None,
        val errorMessages: HashMap<String, Any>? = null,
    ) : Data<T>()
}

sealed class ResponseError {
    object DoNotFound : ResponseError()
    object Unauthorized : ResponseError()
    object Server : ResponseError()
    object TimeOut : ResponseError()
    object Unknown : ResponseError()
    object None : ResponseError()
}
