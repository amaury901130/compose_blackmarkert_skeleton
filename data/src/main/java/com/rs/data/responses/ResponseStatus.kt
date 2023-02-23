package com.rs.data.responses

import com.google.gson.annotations.SerializedName

enum class ResponseStatus {
    @SerializedName("success")
    SUCCESS,
    @SerializedName("error")
    ERROR
}
