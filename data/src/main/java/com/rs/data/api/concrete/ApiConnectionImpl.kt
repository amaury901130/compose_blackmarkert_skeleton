package com.rs.data.api.concrete

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rs.data.DataPreferences
import com.rs.data.api.ApiConnection
import com.rs.data.model.Data
import com.rs.data.model.ResponseError
import com.rs.data.model.requests.LogoutRequest
import com.rs.data.services.TokenService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import java.lang.reflect.Type


internal class ApiConnectionImpl(
    private val tokenService: TokenService,
    private val pref: DataPreferences,
    private val ioDispatcher: CoroutineDispatcher,
) : ApiConnection {
    override suspend fun <T> call(apiCall: Call<T>): Data<T> = withContext(ioDispatcher) {
        try {
            val response = apiCall.execute()
            when {
                response.isSuccessful -> return@withContext Data.Success(response.body())
                response.code() == FORBIDDEN_ERROR || response.code() == UNAUTHORIZED_ERROR -> return@withContext reloadToken(
                    apiCall.clone()
                )
                else -> {
                    val type: Type = object : TypeToken<HashMap<String, Any>>() {}.type
                    val errorMessage: HashMap<String, Any> =
                        Gson().fromJson(response.errorBody()?.string(), type)
                    return@withContext Data.Error(parseError(response.code()), errorMessage)
                }
            }
        } catch (exception: Exception) {
            return@withContext Data.Error(parseError(exception))
        }
    }

    private suspend fun <T> reloadToken(apiCall: Call<T>): Data<T> {
        pref.accessToken = ""
        val tokenRefreshed = tokenService.refreshToken(
            LogoutRequest(
                refresh = pref.refreshToken
            )
        ).execute()
        if (tokenRefreshed.isSuccessful) {
            tokenRefreshed.body()?.token?.let {
                pref.accessToken = it
                return call(apiCall)
            }
        }

        return Data.Error(ResponseError.Unauthorized)
    }

    private fun parseError(errorCode: Int): ResponseError {
        //TODO:...
        return ResponseError.Unknown
    }

    private fun parseError(exception: Exception): ResponseError {
        //TODO:...
        return ResponseError.Unknown
    }

    companion object {
        const val FORBIDDEN_ERROR = 403
        const val UNAUTHORIZED_ERROR = 401
    }
}
