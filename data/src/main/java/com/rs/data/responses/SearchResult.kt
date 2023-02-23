package com.rs.data.responses


import com.google.gson.annotations.SerializedName
import com.rs.data.entity.ProductEntity

data class SearchResult(
    @SerializedName("items")
    val items: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("products")
    val products: List<ProductEntity>,
    @SerializedName("total")
    val total: Int
)
