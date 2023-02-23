package com.rs.data.requests


import com.google.gson.annotations.SerializedName

data class SignInRequest(
    @SerializedName("user")
    val signInData: SignInData
)

data class SignInData(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)