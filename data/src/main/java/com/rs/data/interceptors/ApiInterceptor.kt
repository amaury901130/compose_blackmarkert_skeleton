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
        val builder = request.newBuilder()
        builder.addHeader("Accept", "application/json")
        pref.accessToken.takeIf { it.isNotEmpty() }?.let {
            builder.addHeader("Authorization", "Bearer $it")
        }
        return builder.build()
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
