package com.rs.data.responses


import com.google.gson.annotations.SerializedName

    data class DefaultListResponse<T>(
    @SerializedName("results")
    val result: List<T>? = emptyList()
)
