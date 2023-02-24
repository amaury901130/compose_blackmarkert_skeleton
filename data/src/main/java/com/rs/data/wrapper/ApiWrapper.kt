package com.rs.data.wrapper

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.rs.data.model.Data
import com.rs.data.model.ResponseError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import java.lang.reflect.Type


object ApiWrapper {
    suspend fun <T> call(apiCall: Call<T>): Data<T> = withContext(Dispatchers.IO) {
        try {
            val response = apiCall.execute()
            if (response.isSuccessful)
                return@withContext Data.Success(response.body())
            val type: Type = object : TypeToken<HashMap<String, Any>>() {}.type
            val errorMessage: HashMap<String, Any> =
                Gson().fromJson(response.errorBody()?.string(), type)
            return@withContext Data.Error(parseError(response.code()), errorMessage)
        } catch (exception: Exception) {
            return@withContext Data.Error(parseError(exception))
        }
    }

    private fun parseError(errorCode: Int): ResponseError {
        //TODO:...
        return ResponseError.Unknown
    }

    private fun parseError(exception: Exception): ResponseError {
        //TODO:...
        return ResponseError.Unknown
    }
}
