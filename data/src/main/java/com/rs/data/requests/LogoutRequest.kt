package com.rs.data.requests

import com.google.gson.annotations.SerializedName

data class LogoutRequest(
    @SerializedName("refresh")
    val refresh: String
)
