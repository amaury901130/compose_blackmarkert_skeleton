package com.rs.data.services

import com.rs.data.entity.UserEntity
import com.rs.data.requests.SignInRequest
import com.rs.data.requests.SignUpRequest
import com.rs.data.responses.DataResponse
import com.rs.data.responses.DefaultResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST

interface AuthService {
    @POST("auth")
    fun signUp(@Body body: SignUpRequest) : Call<DataResponse<UserEntity>>

    @POST("auth/sign_in")
    fun signIn(@Body body: SignInRequest) : Call<DataResponse<UserEntity>>

    @DELETE("auth/sign_out")
    fun signOut() : Call<DefaultResponse>
}
