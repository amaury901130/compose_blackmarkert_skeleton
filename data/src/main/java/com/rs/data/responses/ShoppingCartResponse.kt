package com.rs.data.responses


import com.google.gson.annotations.SerializedName

data class ShoppingCartResponse(
    @SerializedName("is_shopping_cart")
    val isShoppingCart: Boolean,
    @SerializedName("order_products")
    val orderProducts: List<OrderProduct>,
    @SerializedName("total_price")
    val totalPrice: String
)
