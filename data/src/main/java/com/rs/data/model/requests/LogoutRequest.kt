package com.rs.data.model.requests

import com.google.gson.annotations.SerializedName

data class LogoutRequest(
    @SerializedName("refresh")
    val refresh: String
)
