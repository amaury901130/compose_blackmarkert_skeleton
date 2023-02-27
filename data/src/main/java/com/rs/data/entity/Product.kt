package com.rs.data.entity


import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("categories")
    val categories: List<Category>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("is_favorite")
    val isFavorite: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("product_picture")
    val productPicture: String
)