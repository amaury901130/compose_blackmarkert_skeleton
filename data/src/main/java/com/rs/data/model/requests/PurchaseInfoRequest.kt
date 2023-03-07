package com.rs.data.model.requests


import com.google.gson.annotations.SerializedName

data class PurchaseInfoRequest(
    @SerializedName("address_city")
    val addressCity: String,
    @SerializedName("address_country")
    val addressCountry: String,
    @SerializedName("address_line1")
    val addressLine1: String,
    @SerializedName("address_line2")
    val addressLine2: String,
    @SerializedName("card_number")
    val cardNumber: String,
    @SerializedName("cvc_card")
    val cvcCard: String,
    @SerializedName("exp_month")
    val expMonth: String,
    @SerializedName("exp_year")
    val expYear: String,
    @SerializedName("postal_code")
    val postalCode: String
)