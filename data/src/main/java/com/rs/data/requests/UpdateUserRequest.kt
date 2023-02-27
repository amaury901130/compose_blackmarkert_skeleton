package com.rs.data.requests

import com.google.gson.annotations.SerializedName

data class UpdateUserRequest(
    @SerializedName("username")
    val username: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("last_name")
    val lastName: String
)
