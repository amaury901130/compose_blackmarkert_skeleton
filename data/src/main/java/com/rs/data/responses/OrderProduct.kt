package com.rs.data.responses


import com.google.gson.annotations.SerializedName
import com.rs.data.entity.ProductEntity

data class OrderProduct(
    @SerializedName("product")
    val product: ProductEntity,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("total_product_price")
    val totalProductPrice: String,
    @SerializedName("unit_price")
    val unitPrice: String
)
