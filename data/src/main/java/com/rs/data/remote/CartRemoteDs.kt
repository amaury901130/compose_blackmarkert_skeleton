package com.rs.data.remote

import com.rs.data.entity.InvoiceEntity
import com.rs.data.entity.PaymentDataEntity
import com.rs.data.entity.ProductEntity
import com.rs.data.entity.ShippingDataEntity
import com.rs.data.model.Data

interface CartRemoteDs {

    suspend fun getCart(): Data<List<ProductEntity>>

    suspend fun addProductToCart(productId: Int, quantity: Int): Data<ProductEntity>

    suspend fun purchaseCard(
        paymentData: PaymentDataEntity,
        shippingData: ShippingDataEntity
    ): Data<InvoiceEntity>
}
