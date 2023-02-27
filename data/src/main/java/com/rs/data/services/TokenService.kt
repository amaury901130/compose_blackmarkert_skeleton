package com.rs.data.services

import com.rs.data.requests.LogoutRequest
import com.rs.data.responses.TokenRefreshResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface TokenService {
    @POST("/token/refresh")
    fun refreshToken(@Body body: LogoutRequest): Call<TokenRefreshResponse>
}
