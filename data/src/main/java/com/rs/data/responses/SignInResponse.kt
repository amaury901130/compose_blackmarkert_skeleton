package com.rs.data.responses


import com.google.gson.annotations.SerializedName
import com.rs.data.entity.UserEntity

data class SignInResponse(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("refresh_token")
    val refreshToken: String,
    @SerializedName("user")
    val user: UserEntity
)
