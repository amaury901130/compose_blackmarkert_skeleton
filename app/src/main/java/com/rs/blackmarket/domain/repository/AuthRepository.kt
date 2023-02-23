package com.rs.blackmarket.domain.repository

import kotlinx.coroutines.flow.Flow


interface AuthRepository {
    fun createAccount(email: String, name: String, password: String): Flow<Boolean>
}
