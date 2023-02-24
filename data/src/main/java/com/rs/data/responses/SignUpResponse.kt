package com.rs.data.responses

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("detail")
    val detail: String
)