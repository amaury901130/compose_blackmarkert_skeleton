package com.rs.data.requests


import com.google.gson.annotations.SerializedName

data class PageRequest(
    @SerializedName("page")
    val page: Int
)
