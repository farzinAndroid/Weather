package com.farzin.weather.repo

import com.farzin.weather.data.internet.BaseApiResponse
import com.farzin.weather.data.internet.NetworkResult
import com.farzin.weather.data.internet.home.HomeApiInterface
import com.farzin.weather.data.model.detail.AirPollution
import com.farzin.weather.data.model.home.Forecast
import com.farzin.weather.data.model.home.WeatherData
import javax.inject.Inject

class HomeRepo @Inject constructor(private val api: HomeApiInterface) : BaseApiResponse() {


    suspend fun getCurrentWeatherByName(q: String): NetworkResult<WeatherData> =
        safeApiCall {
            api.getCurrentWeatherByName(q = q)
        }


 suspend fun getWeatherForecast(q: String): NetworkResult<Forecast> =
        safeApiCall {
            api.getWeatherForecast(q = q)
        }


 suspend fun getPollution(lat: String,lon:String): NetworkResult<AirPollution> =
        safeApiCall {
            api.getPollution(lat = lat,lon = lon)
        }


}