package com.rs.data.requests


import com.google.gson.annotations.SerializedName

data class SearchRequest(
    @SerializedName("text")
    val text: String
)