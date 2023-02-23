package com.rs.blackmarket.domain.repository.concrete

import com.rs.blackmarket.domain.repository.AuthRepository
import com.rs.data.remote.AuthRemoteDs
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class AuthRepositoryImpl(val authRemoteDs: AuthRemoteDs) : AuthRepository {
    override fun loginUser(email: String, password: String): Flow<Boolean> = flow {
        emit(true)
    }
}
