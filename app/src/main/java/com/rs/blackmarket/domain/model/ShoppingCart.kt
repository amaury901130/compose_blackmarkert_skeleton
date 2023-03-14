package com.rs.blackmarket.domain.model

data class ShoppingCart(
    val total: String = "0",
    val products: List<ShoppingCartItem> = emptyList(),
) {
    companion object
}
