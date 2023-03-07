package com.rs.data.remote

import com.rs.data.model.Data
import com.rs.data.model.entity.OrderEntity
import com.rs.data.model.entity.OrderProductEntity
import com.rs.data.model.entity.ShoppingCartEntity


interface CartRemoteDs {
    suspend fun addProduct(productId: Int, quantity: Int): Data<Boolean>

    suspend fun removeProduct(productId: Int): Data<Boolean>

    suspend fun completePurchase(
        city: String,
        country: String,
        address1: String,
        address2: String,
        postalCode: String,
        cardNumber: String,
        cvcCard: String,
        expMonth: Int,
        expYear: Int,
        cardName: String
    ): Data<Boolean>

    suspend fun getShoppingCart(): Data<ShoppingCartEntity>

    suspend fun getOrders(page: Int): Data<List<OrderEntity>>

    suspend fun getOrdersProducts(page: Int): Data<List<OrderProductEntity>>
}
