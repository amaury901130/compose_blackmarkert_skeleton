package com.rs.data.entity


import com.google.gson.annotations.SerializedName

data class UserEntity(
    @SerializedName("email")
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("pk")
    val pk: Int
)


