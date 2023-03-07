package com.rs.blackmarket.domain.model

import com.rs.data.model.entity.CategoryEntity

data class Category(
    val id: Int,
    val name: String,
    val imageUrl: String? = null,
    val subCategories: List<Category> = emptyList()
) {
    companion object
}
