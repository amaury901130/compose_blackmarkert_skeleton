package com.rs.data.remote

import com.rs.data.entity.CategoryEntity
import com.rs.data.entity.ProductEntity
import com.rs.data.model.Data

interface ProductsRemoteDs {
    suspend fun getCategories(page: Int) : Data<List<CategoryEntity>>
    suspend fun getCategoryById(id: Int) : Data<CategoryEntity>
    suspend fun getProductsByCategory(categoryName: String, page: Int): Data<List<ProductEntity>>
    suspend fun findProducts(
        page: Int,
        categories: List<String>? = null,
        status: String? = null,
        query: String? = null,
        minPrice: Double? = null,
        maxPrice: Double? = null
    ): Data<List<ProductEntity>>
}
