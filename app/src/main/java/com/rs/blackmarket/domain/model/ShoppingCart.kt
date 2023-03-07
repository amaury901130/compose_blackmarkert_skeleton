package com.rs.blackmarket.domain.model

data class ShoppingCart(
    val total: String,
    val products: List<OrderProduct>,
) {
    companion object
}

data class OrderProduct(
    val product: Product,
    val quantity: Int,
    val totalPrice: String,
    val unitPrice: String
) {
    companion object
}
