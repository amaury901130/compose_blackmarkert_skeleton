package com.rs.blackmarket.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DispatcherProviderModule {
    @Provides
    @Singleton
    fun distPatcherIORepository(): AppDispatchers.IO {
        return AppDispatchers.IO()
    }

    @Provides
    @Singleton
    fun distPatcherMainRepository(): AppDispatchers.MAIN {
        return AppDispatchers.MAIN()
    }

    @Provides
    @Singleton
    fun distPatcherDefaultRepository(): AppDispatchers.DEFAULT {
        return AppDispatchers.DEFAULT()
    }
}
