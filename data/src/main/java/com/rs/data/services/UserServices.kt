package com.rs.data.services

import com.rs.data.entity.UserEntity
import com.rs.data.responses.DefaultListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserServices {
    @GET("api/users/?page={page}&page_size={page_size}")
    fun getUsers(
        @Path("page") page: Int,
        @Path("page_size") pageSize: Int
    ): Call<DefaultListResponse<UserEntity>>

    @GET("api/users/{id}/")
    fun getUserById(
        @Path("id") userId: Int,
    ): Call<UserEntity>

    @GET("api/users/me/")
    fun getMyUser(): Call<UserEntity>
}
