package com.rs.data.model.entity

import com.google.gson.annotations.SerializedName

data class OrderProductEntity(
    @SerializedName("id")
    val id: Int,
    @SerializedName("order_id")
    val orderId: Int,
    @SerializedName("product_date_bought")
    val productDateBought: String,
    @SerializedName("product_name")
    val productName: String,
    @SerializedName("product_picture")
    val productPicture: String,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("total_product_price")
    val totalProductPrice: String,
    @SerializedName("unit_price")
    val unitPrice: String
)

data class ProductEntity(
    @SerializedName("categories")
    val categories: List<CategoryEntity> = emptyList(),
    @SerializedName("description")
    val description: String = "",
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_favorite")
    val isFavorite: Boolean = false,
    @SerializedName("name")
    val name: String,
    @SerializedName("num_available_items")
    val numAvailableItems: Int = 0,
    @SerializedName("product_pictures")
    val productPictures: List<String>? = emptyList(),
    @SerializedName("product_picture")
    val productPicture: String? = null,
    @SerializedName("state")
    val state: String? = null,
    @SerializedName("unit_price")
    val unitPrice: String? = null
)
