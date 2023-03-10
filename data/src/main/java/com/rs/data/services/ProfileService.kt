package com.rs.data.services

import com.rs.data.model.entity.UserEntity
import com.rs.data.model.requests.LogoutRequest
import com.rs.data.model.requests.SignInData
import com.rs.data.model.requests.SignUpData
import com.rs.data.model.requests.UpdateUserRequest
import com.rs.data.model.responses.DefaultResponse
import com.rs.data.model.responses.SignInResponse
import com.rs.data.model.responses.TokenRefreshResponse
import com.rs.data.model.responses.TokenResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface ProfileService {
    @POST("${AUTH_BASE}/registration/")
    fun signUp(@Body body: SignUpData): Call<DefaultResponse>

    @POST("${AUTH_BASE}/login/")
    fun signIn(@Body body: SignInData): Call<SignInResponse>

    @POST("/auth-token/")
    fun getAuthToken(@Body body: SignInData): Call<TokenResponse>

    @POST("/token/refresh")
    fun refreshToken(@Body body: LogoutRequest): Call<TokenRefreshResponse>

    @POST("${AUTH_BASE}/logout/")
    fun signOut(@Body body: LogoutRequest): Call<DefaultResponse>

    @GET("${AUTH_BASE}/user/")
    fun getUser(): Call<UserEntity>

    @PUT("${AUTH_BASE}/user/")
    fun updateUser(@Body body: UpdateUserRequest): Call<UserEntity>

    companion object {
        const val AUTH_BASE = "dj-rest-auth"
    }
}
