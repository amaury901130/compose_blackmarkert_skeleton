package com.rs.data.responses

import com.google.gson.annotations.SerializedName


data class TokenResponse(
    @SerializedName("token")
    val token: String
)