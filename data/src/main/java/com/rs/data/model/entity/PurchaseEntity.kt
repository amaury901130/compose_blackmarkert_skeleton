package com.rs.data.model.entity


import com.google.gson.annotations.SerializedName

data class PurchaseEntity(
    @SerializedName("address_city")
    val addressCity: String,
    @SerializedName("address_country")
    val addressCountry: String,
    @SerializedName("address_line1")
    val addressLine1: String,
    @SerializedName("address_line2")
    val addressLine2: String,
    @SerializedName("card_brand")
    val cardBrand: String,
    @SerializedName("card_last4")
    val cardLast4: String,
    @SerializedName("date_bought")
    val dateBought: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_shopping_cart")
    val isShoppingCart: Boolean,
    @SerializedName("order_products")
    val orderProducts: List<OrderResumeEntity>,
    @SerializedName("payment_status")
    val paymentStatus: String,
    @SerializedName("postal_code")
    val postalCode: String,
    @SerializedName("total_price")
    val totalPrice: String
)
