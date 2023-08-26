package com.farzin.weather.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.farzin.weather.data.model.city.CityName
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCity(cityName: CityName)

    @Query("select * from city_table ")
    fun getAllCities() : Flow<List<CityName>>

    @Delete
    suspend fun deleteCity(cityName: CityName)


}