package com.rs.data.remote.concrete

import com.rs.data.remote.ProductsRemoteDs
import com.rs.data.requests.GetProductsRequest
import com.rs.data.requests.PageRequest
import com.rs.data.requests.SearchRequest
import com.rs.data.model.Data
import com.rs.data.responses.SearchResult
import com.rs.data.services.ProductsService
import com.rs.data.wrapper.ApiWrapper

class ProductsRemoteDsImpl(private val prodService: ProductsService) : ProductsRemoteDs {
    override suspend fun getProducts(page: Int): Data<SearchResult> {
        return ApiWrapper.call(
            prodService.getProducts(
                PageRequest(page)
            )
        )
    }

    override suspend fun getProductsByCategory(categoryId: Int): Data<SearchResult> {
        return ApiWrapper.call(
            prodService.getProductsByCategory(
                GetProductsRequest(categoryId)
            )
        )
    }

    override suspend fun searchProducts(text: String): Data<SearchResult> {
        return ApiWrapper.call(
            prodService.searchProducts(
                SearchRequest(text)
            )
        )
    }
}
