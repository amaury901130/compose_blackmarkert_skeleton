package com.rs.data.api.concrete

import com.rs.data.model.Data
import retrofit2.Call


interface ApiConnection {
    suspend fun <T> call(apiCall: Call<T>): Data<T>
}
