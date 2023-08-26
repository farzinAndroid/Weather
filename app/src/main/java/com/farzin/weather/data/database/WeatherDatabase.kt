package com.farzin.weather.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.farzin.weather.data.model.city.CityName

@Database(entities = [CityName::class], version = 1, exportSchema = false)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao

}
