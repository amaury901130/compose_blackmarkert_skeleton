package com.rs.data.services

import com.rs.data.entity.CategoryEntity
import com.rs.data.entity.ProductEntity
import com.rs.data.responses.DefaultListResponse
import com.rs.data.responses.GetCategoriesResponse
import com.rs.data.responses.GetOrderProductsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ProductsService {
    @GET("api/categories/?page={page}&page_size={page_size}")
    fun getCategories(
        @Path("page") page: Int, @Path("page_size") pageSize: Int
    ): Call<GetCategoriesResponse>

    @GET("api/categories/{id}/")
    fun getCategoryById(
        @Path("id") id: Int
    ): Call<CategoryEntity>

    @GET("api/orders/?page={page}&page_size={page_size}")
    fun getOrders(
        @Path("page") page: Int, @Path("page_size") pageSize: Int
    ): Call<CategoryEntity>

    @GET("api/orders/product_list/?page={page}&page_size={page_size}")
    fun getOrdersProducts(
        @Path("page") page: Int, @Path("page_size") pageSize: Int
    ): Call<GetOrderProductsResponse>

    /**
     * Build query based on your needs
     * '&search=sample&state=A&unit_price_max=123&unit_price_min=10'
     * **/
    @GET("api/products/?page={page}&page_size={page_size}{query}")
    fun getProducts(
        @Path("page") page: Int, @Path("page_size") pageSize: Int, @Path("query") query: String
    ): Call<DefaultListResponse<ProductEntity>>

    @GET("api/products/favorites/?page={page}&page_size={page_size}{query}")
    fun getFavorites(
        @Path("page") page: Int, @Path("page_size") pageSize: Int, @Path("query") query: String
    ): Call<DefaultListResponse<ProductEntity>>

    @GET("api/products/{id}/")
    fun getProductById(
        @Path("id") id: Int
    ): Call<ProductEntity>

    @POST("api/products/{id}/favorite/")
    fun addToFav(
        @Path("id") id: Int
    ): Call<ProductEntity>

    @POST("api/products/{id}/favorite/")
    fun removeFromFav(
        @Path("id") id: Int
    ): Call<ProductEntity>
}
