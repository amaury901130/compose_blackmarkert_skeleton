package com.rs.blackmarket.domain.repository

import com.rs.blackmarket.domain.model.Category
import com.rs.blackmarket.domain.model.Resource
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    fun getCategories(): Flow<Resource<List<Category>>>

    fun getCategoryById(): Flow<Resource<Category>>
}
