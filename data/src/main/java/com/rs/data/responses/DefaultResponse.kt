package com.rs.data.responses


import com.google.gson.annotations.SerializedName

data class DefaultResponse(
    @SerializedName("success")
    val success: Boolean = false
)