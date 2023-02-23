package com.rs.data.responses


import com.google.gson.annotations.SerializedName

data class DataResponse<T>(
    @SerializedName("data")
    val value: T,
    @SerializedName("status")
    val status: ResponseStatus = ResponseStatus.ERROR
)
