package com.rs.data.services

import com.rs.data.model.entity.CategoryEntity
import com.rs.data.model.entity.ProductEntity
import com.rs.data.model.responses.DefaultListResponse
import com.rs.data.model.responses.GetCategoriesResponse
import com.rs.data.model.responses.GetOrderProductsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ProductsService {
    @GET("api/categories/")
    fun getCategories(
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int
    ): Call<GetCategoriesResponse>

    @GET("api/categories/{id}/")
    fun getCategoryById(
        @Path("id") id: Int
    ): Call<CategoryEntity>

    /**
     * Build query based on your needs
     * '&search=sample&state=A&unit_price_max=123&unit_price_min=10'
     * **/
    @GET("api/products/")
    fun getProducts(@QueryMap query: Map<String, String>): Call<DefaultListResponse<ProductEntity>>

    @GET("api/products/")
    fun getProductsByCategory(
        @Query("categories") category: String,
        @Query("page") page: Int,
        @Query("page_size") pageSize: Int
    ): Call<DefaultListResponse<ProductEntity>>

    @GET("api/products/favorites/?page={page}&page_size={page_size}{query}")
    fun getFavorites(
        @Query("page") page: Int, @Query("page_size") pageSize: Int, @Query("query") query: String
    ): Call<DefaultListResponse<ProductEntity>>

    @GET("api/products/{id}/")
    fun getProductById(
        @Query("id") id: Int
    ): Call<ProductEntity>

    @POST("api/products/{id}/favorite/")
    fun addToFav(
        @Query("id") id: Int
    ): Call<ProductEntity>

    @POST("api/products/{id}/favorite/")
    fun removeFromFav(
        @Query("id") id: Int
    ): Call<ProductEntity>
}
