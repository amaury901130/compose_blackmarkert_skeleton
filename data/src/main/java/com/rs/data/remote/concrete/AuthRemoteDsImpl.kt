package com.rs.data.remote.concrete

import com.rs.data.DataPreferences
import com.rs.data.entity.UserEntity
import com.rs.data.model.Data
import com.rs.data.remote.AuthRemoteDs
import com.rs.data.requests.LogoutRequest
import com.rs.data.requests.SignInData
import com.rs.data.requests.SignUpData
import com.rs.data.services.ProfileService
import com.rs.data.wrapper.ApiWrapper

class AuthRemoteDsImpl(private val authService: ProfileService, private val pref: DataPreferences) :
    AuthRemoteDs {
    override suspend fun singUp(
        email: String,
        password: String
    ): Data<String> {
        return when (
            val response = ApiWrapper.call(
                authService.signUp(
                    SignUpData(email, password, password)
                )
            )
        ) {
            is Data.Success -> {
                singIn(email, password)
                Data.Success(response.data?.detail)
            }
            is Data.Error -> Data.Error(response.error, response.errorMessages)
        }
    }

    override suspend fun singIn(email: String, password: String): Data<UserEntity> {
        return when (
            val response = ApiWrapper.call(
                authService.signIn(
                    SignInData(email, password)
                )
            )
        ) {
            is Data.Success -> {
                response.data?.run {
                    pref.accessToken = accessToken
                    pref.refreshToken = refreshToken
                    return Data.Success(user)
                }
                return Data.Error()
            }
            is Data.Error -> Data.Error(response.error, response.errorMessages)
        }
    }

    suspend fun loadToken(email: String, password: String) {
        val response = ApiWrapper.call(
            authService.getAuthToken(
                SignInData(email, password)
            )
        )
        if (response is Data.Success)
            pref.accessToken = response.data?.token ?: ""
    }

    override suspend fun logOut(): Data<Boolean> {
        val refreshToken = pref.refreshToken
        pref.clean()
        return when (val response = ApiWrapper.call(authService.signOut(
            LogoutRequest(refreshToken)
        ))) {
            is Data.Success -> Data.Success(true)
            is Data.Error -> Data.Error(response.error, response.errorMessages)
        }
    }
}
