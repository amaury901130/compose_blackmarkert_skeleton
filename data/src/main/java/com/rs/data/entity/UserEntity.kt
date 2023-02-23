package com.rs.data.entity


import com.google.gson.annotations.SerializedName

data class UserEntity(
    @SerializedName("allow_password_change")
    val allowPasswordChange: Boolean,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("name")
    val name: String,
    @SerializedName("provider")
    val provider: String,
    @SerializedName("uid")
    val uid: String,
)
