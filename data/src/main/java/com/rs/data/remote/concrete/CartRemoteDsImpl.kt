package com.rs.data.remote.concrete

import com.rs.data.api.ApiConnection
import com.rs.data.model.Data
import com.rs.data.model.entity.OrderEntity
import com.rs.data.model.entity.OrderProductEntity
import com.rs.data.model.entity.ShoppingCartEntity
import com.rs.data.model.requests.AddShoppingCartRequest
import com.rs.data.model.requests.PurchaseInfoRequest
import com.rs.data.model.requests.RemoveItemRequest
import com.rs.data.remote.CartRemoteDs
import com.rs.data.services.CartService

internal class CartRemoteDsImpl(
    private val cartService: CartService,
    private val api: ApiConnection
) : CartRemoteDs {
    override suspend fun addProduct(productId: Int, quantity: Int): Data<Boolean> {
        val response = api.call(
            cartService.addToShoppingCart(
                body = AddShoppingCartRequest(
                    product = productId,
                    quantity = quantity,
                )
            )
        )
        return Data.Success(response is Data.Success)
    }

    override suspend fun removeProduct(productId: Int): Data<Boolean> {
        return when (
            val response = api.call(cartService.removeProduct(RemoveItemRequest(productId)))
        ) {
            is Data.Success -> Data.Success(true)
            is Data.Error -> Data.Error(errorMessages = response.errorMessages)
        }
    }

    override suspend fun completePurchase(
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
    ): Data<Boolean> {
        val response = api.call(
            cartService.completePurchase(
                body = PurchaseInfoRequest(
                    addressCity = city,
                    addressLine1 = address1,
                    addressLine2 = address2,
                    addressCountry = country,
                    postalCode = postalCode,
                    cardNumber = cardNumber,
                    cvcCard = cvcCard,
                    expYear = expYear.toString(),
                    expMonth = expMonth.toString(),
                )
            )
        )
        return Data.Success(response is Data.Success)
    }

    override suspend fun getShoppingCart(): Data<ShoppingCartEntity> {
        return api.call(cartService.getShoppingCart())
    }

    override suspend fun getOrders(page: Int): Data<List<OrderEntity>> {
        return when (
            val response = api.call(cartService.getOrders(page = page, pageSize = PAGE_SIZE))
        ) {
            is Data.Success -> Data.Success(response.data?.result ?: emptyList())
            is Data.Error -> Data.Error()
        }
    }

    override suspend fun getOrdersProducts(page: Int): Data<List<OrderProductEntity>> {
        return when (
            val response =
                api.call(cartService.getOrdersProducts(page = page, pageSize = PAGE_SIZE))
        ) {
            is Data.Success -> Data.Success(response.data?.result ?: emptyList())
            is Data.Error -> Data.Error()
        }
    }

    companion object {
        const val PAGE_SIZE = 20
    }

}
