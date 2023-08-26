package com.farzin.weather.di

import com.farzin.weather.util.Constants.BASE_URL
import com.farzin.weather.util.Constants.TIME_OUT
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InternetModule {



    @Provides
    @Singleton
    fun interceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()

        return logging.setLevel(HttpLoggingInterceptor.Level.BODY)
    }


    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient =
        OkHttpClient.Builder()
            .readTimeout(TIME_OUT,TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT,TimeUnit.SECONDS)
            .connectTimeout(TIME_OUT,TimeUnit.SECONDS)
            .addInterceptor(interceptor())
            .build()


    @Provides
    @Singleton
    fun provideInternetModule(client:OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()


}