package com.rs.data.interceptors

import com.rs.data.DataPreferences
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class RequestInterceptor(private val pref: DataPreferences) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        return chain.proceed(addDefaultHeaders(request))
    }

    private fun addDefaultHeaders(request: Request): Request {
        return request.newBuilder().run {
            header("Accept", "application/json")
            header("access-token", pref.accessToken)
            header("token-type", pref.typeToken)
            header("client", pref.refreshToken)
            header("expiry", pref.expireToken)
            header("uid", pref.uidToken)
        }.build()
    }
}

class ResponseInterceptor(private val pref: DataPreferences) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response: Response
        try {
            response = chain.proceed(request)
            if (response.isSuccessful) {
                response.header("access-token")?.let { pref.accessToken = it }
                response.header("token-type")?.let { pref.refreshToken = it }
                response.header("client")?.let { pref.refreshToken = it }
                response.header("expiry")?.let { pref.expireToken = it }
                response.header("uid")?.let { pref.uidToken = it }
            }
        } catch (exception: Exception) {
            throw exception
        }
        return response
    }


}

class NetworkErrorInterceptorStrategy : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = tryCall(chain)

    private fun tryCall(chain: Interceptor.Chain, errorCount: Int = 0): Response {
        val request = chain.request()
        val response: Response
        try {
            response = chain.proceed(request)
        } catch (exception: Exception) {
            return if (errorCount < MAX_TIMEOUT_ERROR)
                tryCall(chain, errorCount + 1)
            else
                throw exception
        }

        return response
    }

    companion object {
        private const val MAX_TIMEOUT_ERROR = 3
    }
}
