package com.rs.blackmarket.domain.repository

import kotlinx.coroutines.flow.Flow


interface AuthRepository {
    fun loginUser(email: String, password: String): Flow<Boolean>
}
