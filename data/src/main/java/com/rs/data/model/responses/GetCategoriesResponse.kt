package com.rs.data.model.responses

import com.google.gson.annotations.SerializedName
import com.rs.data.model.entity.CategoryEntity

data class GetCategoriesResponse(
    @SerializedName("results")
    val result: List<CategoryEntity>? = emptyList()
)
