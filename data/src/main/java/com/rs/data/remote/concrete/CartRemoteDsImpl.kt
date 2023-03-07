package com.rs.data.remote.concrete

import com.rs.data.api.ApiConnection
import com.rs.data.model.Data
import com.rs.data.model.entity.ShoppingCartEntity
import com.rs.data.remote.CartRemoteDs
import com.rs.data.services.CartService

internal class CartRemoteDsImpl(
    private val cartService: CartService,
    private val api: ApiConnection
) : CartRemoteDs {
    override suspend fun addProduct(productId: Int, quantity: Int): Data<Boolean> {
        return Data.Success(true)
    }

    override suspend fun removeProduct(productId: Int): Data<Boolean> {
        return Data.Success(true)
    }

    override suspend fun completePurchase(
        city: String,
        country: String,
        address1: String,
        address2: String,
        postalCode: String?,
        cardNumber: String,
        cvcCard: String,
        expMonth: Int,
        expYear: Int,
        cardName: String
    ): Data<Boolean> {
        return Data.Success(true)
    }

    override suspend fun getShoppingCart(): Data<ShoppingCartEntity> {
        return api.call(cartService.getShoppingCart())
    }

}
