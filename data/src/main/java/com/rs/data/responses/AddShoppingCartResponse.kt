package com.rs.data.responses


import com.google.gson.annotations.SerializedName
import com.rs.data.entity.ProductEntity

data class AddShoppingCartResponse(
    @SerializedName("is_shopping_cart")
    val isShoppingCart: Boolean,
    @SerializedName("total_price")
    val totalPrice: String,
    @SerializedName("order_products")
    val products: List<ShoppingCartEntity> = emptyList()
)

data class ShoppingCartEntity(
    @SerializedName("product")
    val product: ProductEntity,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("total_product_price")
    val totalProductPrice: String,
    @SerializedName("unit_price")
    val unitPrice: String
)
