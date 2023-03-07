package com.rs.data.model.responses

import com.google.gson.annotations.SerializedName
import com.rs.data.model.entity.OrderProductEntity

data class GetOrderProductsResponse(
    @SerializedName("results")
    val result: List<OrderProductEntity>? = emptyList()
)
