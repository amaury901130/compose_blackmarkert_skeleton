package com.rs.data.model.requests


import com.google.gson.annotations.SerializedName

data class SignInData(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)
