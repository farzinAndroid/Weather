package com.farzin.weather.di

import android.content.Context
import com.farzin.weather.data.database.WeatherDao
import com.farzin.weather.data.database.WeatherDatabase
import com.farzin.weather.data.datastore.DataStoreRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WeatherDaoModule {


    @Provides
    @Singleton
    fun provideWeatherDao(
        database:WeatherDatabase
    ) : WeatherDao  = database.weatherDao()

}