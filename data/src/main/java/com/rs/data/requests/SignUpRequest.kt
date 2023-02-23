package com.rs.data.requests

import com.google.gson.annotations.SerializedName


data class SignUpRequest(
    @SerializedName("user")
    val signUpData: SignUpData
)

data class SignUpData(
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String
)
