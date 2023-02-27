package com.rs.data.providers

import android.content.Context
import android.content.SharedPreferences
import com.rs.data.BuildConfig
import com.rs.data.DataPreferences
import com.rs.data.interceptors.NetworkErrorInterceptorStrategy
import com.rs.data.interceptors.RequestInterceptor
import com.rs.data.remote.AuthRemoteDs
import com.rs.data.remote.CartRemoteDs
import com.rs.data.remote.ProductsRemoteDs
import com.rs.data.remote.concrete.AuthRemoteDsImpl
import com.rs.data.remote.concrete.CartRemoteDsImpl
import com.rs.data.remote.concrete.ProductsRemoteDsImpl
import com.rs.data.services.ProfileService
import com.rs.data.services.ProductsService
import com.rs.data.services.CartService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataProviderModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(BuildConfig.PREF_KEY, Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun dataPreferences(prefs: SharedPreferences): DataPreferences = DataPreferences(prefs)

    @Provides
    @Singleton
    fun provideRequestInterceptor(prefs: DataPreferences): RequestInterceptor =
        RequestInterceptor(prefs)

    @Provides
    @Singleton
    fun provideOkHttpClient(
        requestInterceptor: RequestInterceptor
    ): OkHttpClient {
        val httpInterceptorLevel =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        return OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .addInterceptor(NetworkErrorInterceptorStrategy())
            .addInterceptor(HttpLoggingInterceptor().setLevel(httpInterceptorLevel))
            .build()
    }

    @Provides
    @Singleton
    fun provideApiRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideAuthService(retrofit: Retrofit): ProfileService {
        return retrofit.create(ProfileService::class.java)
    }

    @Provides
    fun provideProductService(retrofit: Retrofit): ProductsService {
        return retrofit.create(ProductsService::class.java)
    }

    @Singleton
    @Provides
    fun provideProfileService(retrofit: Retrofit): CartService {
        return retrofit.create(CartService::class.java)
    }

    @Singleton
    @Provides
    fun provideCartDataSource(cartService: CartService): CartRemoteDs {
        return CartRemoteDsImpl(cartService)
    }

    @Singleton
    @Provides
    fun provideAuthDataSource(authService: ProfileService, pref: DataPreferences): AuthRemoteDs {
        return AuthRemoteDsImpl(authService, pref)
    }

    @Singleton
    @Provides
    fun provideProdDataSource(productsService: ProductsService): ProductsRemoteDs {
        return ProductsRemoteDsImpl(productsService)
    }
}
