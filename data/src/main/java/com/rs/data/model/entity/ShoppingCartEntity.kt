package com.rs.data.model.entity


import com.google.gson.annotations.SerializedName

data class ShoppingCartEntity(
    @SerializedName("order_products")
    val orderProducts: List<OrderResumeEntity>,
    @SerializedName("total_price")
    val totalPrice: String
)
