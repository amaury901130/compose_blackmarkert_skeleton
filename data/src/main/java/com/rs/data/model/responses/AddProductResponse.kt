package com.rs.data.model.responses


import com.google.gson.annotations.SerializedName
import com.rs.data.model.entity.ProductEntity

data class AddProductResponse(
    @SerializedName("product")
    val product: ProductEntity
)
