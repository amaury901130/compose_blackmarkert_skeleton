package com.rs.data.entity


import com.google.gson.annotations.SerializedName

data class OrderProduct(
    @SerializedName("product")
    val product: Product,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("total_product_price")
    val totalProductPrice: String,
    @SerializedName("unit_price")
    val unitPrice: String
)