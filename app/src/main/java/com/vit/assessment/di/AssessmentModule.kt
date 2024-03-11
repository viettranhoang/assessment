package com.vit.assessment.di

import com.vit.assessment.core.coroutine.CoroutineDispatchers
import com.vit.assessment.data.SportRepositoryImpl
import com.vit.assessment.data.remote.SportRemote
import com.vit.assessment.data.remote.SportRemoteImpl
import com.vit.assessment.data.remote.api.SportApiService
import com.vit.assessment.domain.SportRepository
import com.vit.assessment.domain.exception.SportExceptionHandler
import com.vit.assessment.domain.exception.SportExceptionHandlerImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @author vietth
 * @since 09/03/2024
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class AssessmentModule {


    @Binds
    @Singleton
    internal abstract fun bindSportRemote(remote: SportRemoteImpl): SportRemote

    @Binds
    @Singleton
    internal abstract fun bindSportRepository(repository: SportRepositoryImpl): SportRepository

    @Binds
    @Singleton
    internal abstract fun bindSportExceptionHandler(handler: SportExceptionHandlerImpl): SportExceptionHandler


    companion object {

        @Provides
        @Singleton
        fun provideSportApiService(
            client: OkHttpClient,
        ) = Retrofit.Builder()
            .baseUrl(SportApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(SportApiService::class.java)

        @Provides
        @Singleton
        fun provideOkhttp() = OkHttpClient.Builder()
            .callTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
            .addInterceptor { chain ->
                val request = chain.request()
                    .newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .build()
                chain.proceed(request)
            }
            .retryOnConnectionFailure(true)
            .build()

        @Provides
        @Singleton
        fun provideCoroutineDispatchers() = CoroutineDispatchers(
            Dispatchers.Main,
            Dispatchers.Main.immediate,
            Dispatchers.IO,
            Dispatchers.Default
        )
    }
}