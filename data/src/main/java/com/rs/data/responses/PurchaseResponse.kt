package com.rs.data.responses


import com.google.gson.annotations.SerializedName
import com.rs.data.entity.InvoiceEntity

data class PurchaseResponse(
    @SerializedName("invoice")
    val invoice: InvoiceEntity
)
