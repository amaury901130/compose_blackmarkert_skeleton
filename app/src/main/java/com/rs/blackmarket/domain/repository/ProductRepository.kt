package com.rs.blackmarket.domain.repository

import com.rs.blackmarket.domain.model.Category
import com.rs.blackmarket.domain.model.Product
import com.rs.blackmarket.domain.model.ProductStatus
import com.rs.blackmarket.domain.model.Resource
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getCategories(page: Int = 1): Flow<Resource<List<Category>>>

    fun getCategoryById(categoryId: Int): Flow<Resource<Category>>

    fun getProductById(): Flow<Resource<Product>>

    fun getProductsByCategory(categoryName: String, page: Int = 1): Flow<Resource<List<Product>>>

    fun findProduct(
        page: Int = 1,
        categories: List<String>? = null,
        status: ProductStatus = ProductStatus.NEW,
        query: String? = null,
        minPrice: Double? = null,
        maxPrice: Double? = null
    ): Flow<Resource<List<Product>>>
}
