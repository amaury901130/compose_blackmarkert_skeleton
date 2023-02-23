package com.rs.data.responses


import com.google.gson.annotations.SerializedName
import com.rs.data.entity.ProductEntity

data class AddProductResponse(
    @SerializedName("product")
    val product: ProductEntity
)
