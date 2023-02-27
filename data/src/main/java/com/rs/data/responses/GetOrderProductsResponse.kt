package com.rs.data.responses

import com.google.gson.annotations.SerializedName
import com.rs.data.entity.OrderProductEntity

data class GetOrderProductsResponse(
    @SerializedName("results")
    val result: List<OrderProductEntity>? = emptyList()
)
