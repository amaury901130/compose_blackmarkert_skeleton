package com.rs.data.model.responses


import com.google.gson.annotations.SerializedName
import com.rs.data.model.entity.UserEntity

data class SignInResponse(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("refresh_token")
    val refreshToken: String,
    @SerializedName("user")
    val user: UserEntity
)
