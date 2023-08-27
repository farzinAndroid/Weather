package com.farzin.weather.di

import android.content.Context
import androidx.room.Room
import com.farzin.weather.data.database.WeatherDatabase
import com.farzin.weather.util.Constants.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    )  =
        Room.databaseBuilder(
            context,
            WeatherDatabase::class.java,
            DB_NAME
        ).build()

}