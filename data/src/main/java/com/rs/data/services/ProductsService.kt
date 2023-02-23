package com.rs.data.services

import com.rs.data.requests.GetProductsRequest
import com.rs.data.requests.PageRequest
import com.rs.data.requests.SearchRequest
import com.rs.data.responses.SearchResult
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ProductsService {
    @GET("products")
    fun getProducts(@Body body: PageRequest): Call<SearchResult>

    @GET("category_products")
    fun getProductsByCategory(@Body body: GetProductsRequest): Call<SearchResult>

    @POST("search_products")
    fun searchProducts(@Body body: SearchRequest): Call<SearchResult>
}
