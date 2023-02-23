package com.rs.data.requests


import com.google.gson.annotations.SerializedName
import com.rs.data.entity.PaymentDataEntity
import com.rs.data.entity.ShippingDataEntity

data class PurchaseRequest(
    @SerializedName("payment_datum")
    val paymentDatum: PaymentDataEntity,
    @SerializedName("shipping_address")
    val shippingAddress: ShippingDataEntity
)