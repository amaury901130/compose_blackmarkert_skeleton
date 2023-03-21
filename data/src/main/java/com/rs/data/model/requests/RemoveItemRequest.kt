package com.rs.data.model.requests

import com.google.gson.annotations.SerializedName

data class RemoveItemRequest(
    @SerializedName("product_id")
    val productId: Int
)
