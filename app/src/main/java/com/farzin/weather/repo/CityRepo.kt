package com.farzin.weather.repo

import com.farzin.weather.data.database.WeatherDao
import com.farzin.weather.data.model.city.CityName
import javax.inject.Inject

class CityRepo @Inject constructor(
    private val dao:WeatherDao
) {

    val allCities = dao.getAllCities()

    suspend fun insertCity(cityName: CityName){
        dao.insertCity(cityName)
    }

    suspend fun deleteCity(cityName: CityName){
        dao.deleteCity(cityName)
    }



}