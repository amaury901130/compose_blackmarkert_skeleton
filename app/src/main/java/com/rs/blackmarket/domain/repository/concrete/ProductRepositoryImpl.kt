package com.rs.blackmarket.domain.repository.concrete

import com.rs.blackmarket.domain.model.Category
import com.rs.blackmarket.domain.model.Resource
import com.rs.blackmarket.domain.repository.ProductRepository
import com.rs.data.remote.ProductsRemoteDs
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class ProductRepositoryImpl(private val productsDS: ProductsRemoteDs) : ProductRepository {
    override fun getCategories(): Flow<Resource<List<Category>>> = flow {
        emit(Resource.Loading())
        //TODO:..
    }

    override fun getCategoryById(): Flow<Resource<Category>> = flow {
        emit(Resource.Loading())
        //TODO:..
    }

}
