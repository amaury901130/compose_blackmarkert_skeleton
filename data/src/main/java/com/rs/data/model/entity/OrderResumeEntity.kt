package com.rs.data.model.entity


import com.google.gson.annotations.SerializedName

data class OrderResumeEntity(
    @SerializedName("product")
    val product: ProductEntity,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("total_product_price")
    val totalProductPrice: String,
    @SerializedName("unit_price")
    val unitPrice: String
)
