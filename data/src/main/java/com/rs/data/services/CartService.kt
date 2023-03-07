package com.rs.data.services

import com.rs.data.model.requests.AddShoppingCartRequest
import com.rs.data.model.requests.PurchaseInfoRequest
import com.rs.data.model.entity.ShoppingCartEntity
import com.rs.data.model.responses.GetOrderProductsResponse
import com.rs.data.model.responses.GetOrdersResponse
import com.rs.data.model.entity.PurchaseEntity
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface CartService {
    /**
     * Shopping cart
     */
    @POST("{$SHOPPING_CART_PREFIX}/add_product_to_cart/")
    fun addToShoppingCart(@Body body: AddShoppingCartRequest): Call<ShoppingCartEntity>

    @PUT("{$SHOPPING_CART_PREFIX}/complete_purchase/")
    fun completePurchase(@Body body: PurchaseInfoRequest): Call<PurchaseEntity>

    @GET("{$SHOPPING_CART_PREFIX}/get_detail/")
    fun getShoppingCart(): Call<ShoppingCartEntity>

    /**
     * Orders
     */
    @GET("${ORDERS_PREFIX}/?page={page}&page_size={page_size}")
    fun getOrders(
        @Query("page") page: Int, @Path("page_size") pageSize: Int
    ): Call<GetOrdersResponse>

    @GET("${ORDERS_PREFIX}/product_list/?page={page}&page_size={page_size}")
    fun getOrdersProducts(
        @Query("page") page: Int, @Path("page_size") pageSize: Int
    ): Call<GetOrderProductsResponse>

    companion object {
        const val SHOPPING_CART_PREFIX = "api/shopping_cart"
        const val ORDERS_PREFIX = "api/orders"
    }
}
