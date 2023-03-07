package com.rs.data.model.entity


import com.google.gson.annotations.SerializedName

data class PaymentDataEntity(
    @SerializedName("card_number")
    val cardNumber: String,
    @SerializedName("expiration_date_month")
    val expirationDateMonth: Int,
    @SerializedName("expiration_date_year")
    val expirationDateYear: Int,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("secret_code")
    val secretCode: Int
)
