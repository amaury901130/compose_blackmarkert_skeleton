package com.rs.data.remote

import com.rs.data.model.Data
import com.rs.data.responses.SearchResult

interface ProductsRemoteDs {
    suspend fun getProducts(page: Int): Data<SearchResult>

    suspend fun getProductsByCategory(categoryId: Int): Data<SearchResult>

    suspend fun searchProducts(text: String): Data<SearchResult>
}
