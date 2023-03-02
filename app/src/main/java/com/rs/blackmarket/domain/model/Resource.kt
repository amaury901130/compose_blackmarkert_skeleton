package com.rs.blackmarket.domain.model

sealed class Resource<T> {
    data class Success<T>(val data: T? = null) : Resource<T>()
    class Loading<T> : Resource<T>()
    class Idle<T> : Resource<T>()
    data class Error<T>(val message: String? = null) : Resource<T>()
}
