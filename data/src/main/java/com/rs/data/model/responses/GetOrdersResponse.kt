package com.rs.data.model.responses

import com.google.gson.annotations.SerializedName
import com.rs.data.model.entity.OrderEntity

data class GetOrdersResponse(
    @SerializedName("results")
    val result: List<OrderEntity>? = emptyList()
)
