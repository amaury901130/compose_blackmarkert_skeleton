package com.rs.blackmarket.domain.repository.concrete

import com.rs.blackmarket.domain.extensions.parse
import com.rs.blackmarket.domain.model.Category
import com.rs.blackmarket.domain.model.Product
import com.rs.blackmarket.domain.model.ProductStatus
import com.rs.blackmarket.domain.model.Resource
import com.rs.blackmarket.domain.repository.ProductRepository
import com.rs.data.model.Data
import com.rs.data.remote.ProductsRemoteDs
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class ProductRepositoryImpl(private val productsDS: ProductsRemoteDs) : ProductRepository {
    override fun getCategories(page: Int): Flow<Resource<List<Category>>> = flow {
        emit(Resource.Loading())
        val result = when (val categories = productsDS.getCategories(page)) {
            is Data.Success -> Resource.Success(
                categories.data?.map { Category.parse(it) }
            )
            is Data.Error -> Resource.Error(categories.errorMessages?.values?.first()?.toString())
        }
        emit(result)
    }

    override fun addToFav(prodId: Int): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading())
        when (val result = productsDS.addToFavorite(prodId)) {
            is Data.Success -> emit(Resource.Success(true))
            is Data.Error -> emit(Resource.Error(result.errorMessages?.values?.first()?.toString()))
        }
    }

    override fun removeFromFav(prodId: Int): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading())
        when (val result = productsDS.removeFromFavorite(prodId)) {
            is Data.Success -> emit(Resource.Success(true))
            is Data.Error -> emit(Resource.Error(result.errorMessages?.values?.first()?.toString()))
        }
    }

    override fun getFav(prodId: Int, page: Int): Flow<Resource<List<Product>>> = flow {
        emit(Resource.Loading())
        val result = when (val favorites = productsDS.getFavorites(page)) {
            is Data.Success -> Resource.Success(
                favorites.data?.map { Product.parse(it) }
            )
            is Data.Error -> Resource.Error(favorites.errorMessages?.values?.first()?.toString())
        }

        emit(result)
    }

    override fun getCategoryById(categoryId: Int): Flow<Resource<Category>> = flow {
        emit(Resource.Loading())
        val result = when (val categories = productsDS.getCategoryById(categoryId)) {
            is Data.Success -> Resource.Success(
                categories.data?.let { Category.parse(it) }
            )
            is Data.Error -> Resource.Error(categories.errorMessages?.values?.first()?.toString())
        }
        emit(result)
    }

    override fun getProductById(): Flow<Resource<Product>> = flow {
        emit(Resource.Loading())
    }

    override fun getProductsByCategory(
        categoryName: String,
        page: Int
    ): Flow<Resource<List<Product>>> = flow {
        emit(Resource.Loading())
        val response = when (
            val products = productsDS.getProductsByCategory(categoryName, page)
        ) {
            is Data.Success -> Resource.Success(products.data?.map { Product.parse(it) })
            is Data.Error -> Resource.Error(products.errorMessages?.values?.toString())
        }

        emit(response)
    }

    override fun findProduct(
        page: Int,
        categories: List<String>?,
        status: ProductStatus,
        query: String?,
        minPrice: Double?,
        maxPrice: Double?
    ): Flow<Resource<List<Product>>> = flow {
        emit(Resource.Loading())
        val response = when (
            val products = productsDS.getProductsByCategory("", 1)
        ) {
            is Data.Success -> Resource.Success(products.data?.map { Product.parse(it) })
            is Data.Error -> Resource.Error(products.errorMessages?.values?.first() as String)
        }

        emit(response)
    }

}
