package com.rs.blackmarket.domain.repository

import com.rs.blackmarket.domain.model.Resource
import kotlinx.coroutines.flow.Flow


interface AuthRepository {
    fun singUp(email: String, password: String): Flow<Resource<Boolean>>
    fun signIn(email: String, password: String): Flow<Resource<Boolean>>
    fun logOut(): Flow<Resource<Boolean>>
}
