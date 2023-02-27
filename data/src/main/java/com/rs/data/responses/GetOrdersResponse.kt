package com.rs.data.responses

import com.google.gson.annotations.SerializedName
import com.rs.data.entity.OrderEntity

data class GetOrdersResponse(
    @SerializedName("results")
    val result: List<OrderEntity>? = emptyList()
)
