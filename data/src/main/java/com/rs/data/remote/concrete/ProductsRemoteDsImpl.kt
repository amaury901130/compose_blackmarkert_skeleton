package com.rs.data.remote.concrete

import com.rs.data.api.ApiConnection
import com.rs.data.model.entity.CategoryEntity
import com.rs.data.model.entity.ProductEntity
import com.rs.data.model.Data
import com.rs.data.remote.ProductsRemoteDs
import com.rs.data.services.ProductsService

internal class ProductsRemoteDsImpl(
    private val prodService: ProductsService,
    private val api: ApiConnection
) : ProductsRemoteDs {
    override suspend fun getProduct(productId: Int): Data<ProductEntity> {
        return api.call(prodService.getProductById(productId))
    }

    override suspend fun addToFavorite(productId: Int): Data<Boolean> {
        val response = api.call(
            prodService.addToFav(productId)
        )

        return Data.Success(response is Data.Success)
    }

    override suspend fun removeFromFavorite(productId: Int): Data<Boolean> {
        val response = api.call(
            prodService.removeFromFav(productId)
        )

        return Data.Success(response is Data.Success)
    }

    override suspend fun getFavorites(page: Int): Data<List<ProductEntity>> {
        return when (
            val response = api.call(prodService.getFavorites(page, PAGE_SIZE))
        ) {
            is Data.Success -> Data.Success(response.data?.result ?: emptyList())
            is Data.Error -> Data.Error()
        }
    }

    override suspend fun getCategories(page: Int): Data<List<CategoryEntity>> {
        return when (val response = api.call(
            prodService.getCategories(page, pageSize = PAGE_SIZE)
        )) {
            is Data.Success -> Data.Success(response.data?.result ?: emptyList())
            is Data.Error -> Data.Error(response.error, response.errorMessages)
        }
    }

    override suspend fun getCategoryById(id: Int): Data<CategoryEntity> {
        return api.call(
            prodService.getCategoryById(id)
        )
    }

    override suspend fun getProductsByCategory(
        categoryName: String,
        page: Int
    ): Data<List<ProductEntity>> = findProducts(page, listOf(categoryName))

    override suspend fun getProducts(page: Int): Data<List<ProductEntity>> = findProducts(page)

    override suspend fun findProducts(
        page: Int,
        categories: List<String>?,
        status: String?,
        query: String?,
        minPrice: Double?,
        maxPrice: Double?
    ): Data<List<ProductEntity>> {
        val queryMap = mutableMapOf<String, String>()
        queryMap["page"] = page.toString()
        queryMap["page_size"] = PAGE_SIZE.toString()
        categories?.forEach { queryMap["categories"] = it }
        status?.let { queryMap["state"] = it }
        query?.let { queryMap["search"] = it }
        maxPrice?.let { queryMap["unit_price_max"] = it.toString() }
        minPrice?.let { queryMap["unit_price_min"] = it.toString() }

        return when (val response = api.call(
            prodService.getProducts(queryMap.toMap())
        )) {
            is Data.Success -> Data.Success(response.data?.result ?: emptyList())
            is Data.Error -> Data.Error(response.error, response.errorMessages)
        }
    }

    companion object {
        const val PAGE_SIZE = 20
    }

}
