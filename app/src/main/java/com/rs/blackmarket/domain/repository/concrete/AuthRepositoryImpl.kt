package com.rs.blackmarket.domain.repository.concrete

import com.rs.blackmarket.domain.repository.AuthRepository
import com.rs.data.model.Data
import com.rs.data.remote.AuthRemoteDs
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class AuthRepositoryImpl(private val authRemoteDs: AuthRemoteDs) : AuthRepository {
    override fun createAccount(email: String, name: String, password: String): Flow<Boolean> = flow {
        val response = authRemoteDs.singUp(email, name, password)
        if (response is Data.Error)
            emit(false)
        else
            emit(true)
    }
}
