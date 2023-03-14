package com.rs.blackmarket.domain.model

data class Order(
    val id: Int,
    val orderProducts: List<ShoppingCartItem>,
    val paymentStatus: String,
    val date: String?,
    val city: String,
    val address: String
) {
    companion object
}
