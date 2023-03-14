package com.rs.blackmarket.domain.model

data class OrderItem(
    val productId: Int,
    val orderId: Int,
    val dateBought: String,
    val productName: String,
    val productPicture: String,
    val quantity: Int,
    val orderPrice: String,
    val price: String
) {
    companion object
}

