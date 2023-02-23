package com.rs.data.requests


import com.google.gson.annotations.SerializedName

data class GetProductsRequest(
    @SerializedName("category_id")
    val categoryId: Int
)