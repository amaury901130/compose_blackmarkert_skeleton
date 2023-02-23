package com.rs.data.entity


import com.google.gson.annotations.SerializedName

data class ShippingDataEntity(
    @SerializedName("address")
    val address: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("zip_code")
    val zipCode: String
)
