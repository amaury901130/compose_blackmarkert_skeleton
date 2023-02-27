package com.rs.blackmarket.domain.repository.concrete

import com.rs.blackmarket.domain.model.Resource
import com.rs.blackmarket.domain.repository.AuthRepository
import com.rs.data.model.Data
import com.rs.data.remote.AuthRemoteDs
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class AuthRepositoryImpl(private val authRemoteDs: AuthRemoteDs) : AuthRepository {
    override fun singUp(email: String, password: String): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading())
        val response = authRemoteDs.singUp(email, password)
        if (response is Data.Error)
            (response.errorMessages?.values?.first() as? List<*>)?.takeIf { it.isNotEmpty() }
                ?.first()?.takeIf { it is String }?.let {
                    it as String
                    emit(Resource.Error(message = it))
                } ?: emit(Resource.Error())
        else
            emit(Resource.Success(true))
    }

    override fun signIn(email: String, password: String): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading())
        val response = authRemoteDs.singIn(email, password)
        if (response is Data.Error)
            (response.errorMessages?.values?.first() as? List<*>)?.takeIf { it.isNotEmpty() }
                ?.first()?.takeIf { it is String }?.let {
                    it as String
                    emit(Resource.Error(message = it))
                } ?: emit(Resource.Error())
        else
            emit(Resource.Success(true))
    }

    override fun logOut(): Flow<Resource<Boolean>> = flow {
        emit(Resource.Loading())
        authRemoteDs.logOut()
        emit(Resource.Success(true))
    }
}
