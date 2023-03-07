package com.rs.data.model.responses

import com.google.gson.annotations.SerializedName

enum class ResponseStatus {
    @SerializedName("success")
    SUCCESS,
    @SerializedName("error")
    ERROR
}
