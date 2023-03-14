package com.rs.blackmarket.domain.model


data class ShoppingCartItem(
    val product: Product,
    val quantity: Int,
    val totalPrice: String,
    val unitPrice: String
) {
    companion object
}
