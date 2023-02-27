package com.rs.data.requests


import com.google.gson.annotations.SerializedName

data class AddShoppingCartRequest(
    @SerializedName("product")
    val product: Int,
    @SerializedName("quantity")
    val quantity: Int
)