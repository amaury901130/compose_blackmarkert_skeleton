package com.rs.blackmarket.domain.repository

import com.rs.blackmarket.domain.model.OrderProduct
import com.rs.blackmarket.domain.model.Product
import com.rs.blackmarket.domain.model.Resource
import com.rs.blackmarket.domain.model.ShoppingCart
import kotlinx.coroutines.flow.Flow


interface OrderRepository {
    suspend fun addProduct(productId: Int, quantity: Int): Flow<Resource<Boolean>>

    suspend fun removeProduct(productId: Int): Flow<Resource<Boolean>>

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
    ): Flow<Resource<Boolean>>

    suspend fun getShoppingCart(): Flow<Resource<ShoppingCart>>

    suspend fun getOrders(page: Int): Flow<Resource<List<Any>>>

    suspend fun getOrdersProducts(page: Int): Flow<Resource<List<Product>>>
}
