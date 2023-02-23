package com.rs.data.requests


import com.google.gson.annotations.SerializedName

data class ProductDetails(
    @SerializedName("product_id")
    val productId: Int,
    @SerializedName("quantity")
    val quantity: Int
)