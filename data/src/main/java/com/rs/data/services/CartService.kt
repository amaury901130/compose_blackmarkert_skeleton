package com.rs.data.services

import com.rs.data.entity.ProductEntity
import com.rs.data.requests.AddProductRequest
import com.rs.data.requests.PurchaseRequest
import com.rs.data.responses.AddProductResponse
import com.rs.data.responses.PurchaseResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface CartService {
    @GET("product_carts")
    fun getCart(): Call<List<ProductEntity>>

    @POST("product_carts")
    fun addProductToCart(body: AddProductRequest): Call<AddProductResponse>

    @POST("purchases")
    fun purchaseCard(body: PurchaseRequest): Call<PurchaseResponse>
}
