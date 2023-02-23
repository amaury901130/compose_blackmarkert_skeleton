package com.rs.data.entity

import com.google.gson.annotations.SerializedName


data class ProductEntity(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("quantity")
    val quantity: Int = 0
)
