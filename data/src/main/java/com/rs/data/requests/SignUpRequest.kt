package com.rs.data.requests

import com.google.gson.annotations.SerializedName


data class SignUpRequest(
    @SerializedName("user")
    val signUpData: SignUpData
)

data class SignUpData(
    @SerializedName("email")
    val email: String,
    @SerializedName("password1")
    val password1: String,
    @SerializedName("password2")
    val password2: String
)
