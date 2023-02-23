package com.rs.data.remote.concrete

import com.rs.data.entity.UserEntity
import com.rs.data.model.Data
import com.rs.data.remote.AuthRemoteDs
import com.rs.data.requests.SignInData
import com.rs.data.requests.SignInRequest
import com.rs.data.requests.SignUpData
import com.rs.data.requests.SignUpRequest
import com.rs.data.services.AuthService
import com.rs.data.wrapper.ApiWrapper

class AuthRemoteDsImpl(private val authService: AuthService) : AuthRemoteDs {
    override suspend fun singUp(
        email: String,
        name: String,
        password: String
    ): Data<UserEntity> {
        return when (
            val response = ApiWrapper.call(
                authService.signUp(
                    SignUpRequest(
                        SignUpData(email, name, password)
                    )
                )
            )
        ) {
            is Data.Success -> Data.Success(response.data?.value)
            is Data.Error -> Data.Error(response.error)
        }
    }

    override suspend fun singIn(email: String, password: String): Data<UserEntity> {
        return when (
            val response = ApiWrapper.call(
                authService.signIn(
                    SignInRequest(
                        SignInData(email, password)
                    )
                )
            )
        ) {
            is Data.Success -> Data.Success(response.data?.value)
            is Data.Error -> Data.Error(response.error)
        }
    }

    override suspend fun logOut(): Data<Boolean> {
        return when (val response = ApiWrapper.call(authService.signOut())) {
            is Data.Success -> Data.Success(true)
            is Data.Error -> Data.Error(response.error)
        }
    }
}
