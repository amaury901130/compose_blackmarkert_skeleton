package com.rs.blackmarket.domain.repository

import com.rs.blackmarket.domain.repository.concrete.AuthRepositoryImpl
import com.rs.blackmarket.domain.repository.concrete.ProductRepositoryImpl
import com.rs.data.remote.AuthRemoteDs
import com.rs.data.remote.ProductsRemoteDs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryProviderModule {

    @Provides
    @Singleton
    fun provideAuthRepository(authRemoteDs: AuthRemoteDs): AuthRepository {
        return AuthRepositoryImpl(authRemoteDs);
    }

    @Provides
    @Singleton
    fun provideProductRepository(prodRemoteDs: ProductsRemoteDs): ProductRepository {
        return ProductRepositoryImpl(prodRemoteDs);
    }
}
