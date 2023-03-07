package com.rs.data.model.entity


import com.google.gson.annotations.SerializedName

data class CategoryEntity(
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("parent")
    val parent: CategoryEntity? = null,
    @SerializedName("picture")
    val picture: String? = "",
    @SerializedName("sub_categories")
    val subCategories: List<CategoryEntity>? = emptyList()
)
