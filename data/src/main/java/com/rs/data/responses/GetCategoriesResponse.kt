package com.rs.data.responses

import com.google.gson.annotations.SerializedName
import com.rs.data.entity.CategoryEntity

data class GetCategoriesResponse(
    @SerializedName("results")
    val result: List<CategoryEntity>? = emptyList()
)
