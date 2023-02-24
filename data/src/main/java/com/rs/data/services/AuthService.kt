package com.rs.data.services

import com.rs.data.entity.UserEntity
import com.rs.data.requests.SignInData
import com.rs.data.requests.SignInRequest
import com.rs.data.requests.SignUpData
import com.rs.data.requests.SignUpRequest
import com.rs.data.responses.DataResponse
import com.rs.data.responses.DefaultResponse
import com.rs.data.responses.SignInResponse
import com.rs.data.responses.SignUpResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST

interface AuthService {
    @POST("${AUTH_BASE}/registration/")
    fun signUp(@Body body: SignUpData): Call<SignUpResponse>

    @POST("${AUTH_BASE}/login/")
    fun signIn(@Body body: SignInData): Call<SignInResponse>

    @POST("${AUTH_BASE}/login/")
    fun confirmToken(@Body body: SignInData): Call<SignInResponse>

    @DELETE("auth/sign_out/")
    fun signOut(): Call<DefaultResponse>


    companion object {
        const val AUTH_BASE = "dj-rest-auth"
    }
}
