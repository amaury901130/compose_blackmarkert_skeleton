package com.rs.data.remote.concrete

import com.rs.data.entity.InvoiceEntity
import com.rs.data.entity.PaymentDataEntity
import com.rs.data.entity.ProductEntity
import com.rs.data.entity.ShippingDataEntity
import com.rs.data.remote.CartRemoteDs
import com.rs.data.requests.AddProductRequest
import com.rs.data.requests.ProductDetails
import com.rs.data.requests.PurchaseRequest
import com.rs.data.model.Data
import com.rs.data.services.CartService
import com.rs.data.wrapper.ApiWrapper

class CartRemoteDsImpl(private val cartService: CartService) : CartRemoteDs {
    override suspend fun getCart(): Data<List<ProductEntity>> {
        return ApiWrapper.call(
            cartService.getCart()
        )
    }

    override suspend fun addProductToCart(productId: Int, quantity: Int): Data<ProductEntity> {
        return when (
            val response = ApiWrapper.call(
                cartService.addProductToCart(
                    AddProductRequest(
                        ProductDetails(
                            productId, quantity
                        )
                    )
                )
            )
        ) {
            is Data.Success -> Data.Success(response.data?.product)
            is Data.Error -> Data.Error(response.error)
        }
    }

    override suspend fun purchaseCard(
        paymentData: PaymentDataEntity,
        shippingData: ShippingDataEntity
    ): Data<InvoiceEntity> {
        return when (
            val response = ApiWrapper.call(
                cartService.purchaseCard(
                    PurchaseRequest(
                        paymentData, shippingData
                    )
                )
            )
        ) {
            is Data.Success -> Data.Success(response.data?.invoice)
            is Data.Error -> Data.Error(response.error)
        }
    }
}
