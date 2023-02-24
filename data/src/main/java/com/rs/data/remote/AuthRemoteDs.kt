package com.rs.data.remote

import com.rs.data.model.Data
import com.rs.data.entity.UserEntity

interface AuthRemoteDs {
    suspend fun singUp(
        email: String,
        password: String
    ): Data<String>

    suspend fun singIn(email: String, password: String): Data<UserEntity>
    suspend fun logOut(): Data<Boolean>
}
