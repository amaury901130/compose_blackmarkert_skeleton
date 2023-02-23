package com.rs.data.requests


import com.google.gson.annotations.SerializedName

data class AddProductRequest(
    @SerializedName("product_details")
    val productDetails: ProductDetails
)