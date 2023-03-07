package com.rs.data.model.entity


import com.google.gson.annotations.SerializedName

data class InvoiceEntity(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("payment_datum_id")
    val paymentDatumId: Int,
    @SerializedName("payment_id")
    val paymentId: String,
    @SerializedName("payment_status")
    val paymentStatus: String,
    @SerializedName("shipping_address_id")
    val shippingAddressId: Int,
    @SerializedName("total_amount")
    val totalAmount: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("user_id")
    val userId: Int
)