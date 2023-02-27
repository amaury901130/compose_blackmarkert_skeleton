package com.rs.data.services

import com.rs.data.requests.AddShoppingCartRequest
import com.rs.data.requests.PurchaseInfoRequest
import com.rs.data.responses.ShoppingCartResponse
import com.rs.data.responses.PurchaseResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface CartService {
    @POST("{$SHOPPING_CART_PREFIX}/add_product_to_cart/")
    fun addToShoppingCart(@Body body: AddShoppingCartRequest): Call<ShoppingCartResponse>

    @PUT("{$SHOPPING_CART_PREFIX}/complete_purchase/")
    fun completePurchase(@Body body: PurchaseInfoRequest): Call<PurchaseResponse>

    @GET("{$SHOPPING_CART_PREFIX}/get_detail/")
    fun getShoppingCart(@Body body: PurchaseInfoRequest): Call<ShoppingCartResponse>

    companion object {
        const val SHOPPING_CART_PREFIX = "api/shopping_cart"
    }
}
