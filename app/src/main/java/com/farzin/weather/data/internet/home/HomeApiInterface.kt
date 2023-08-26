package com.farzin.weather.data.internet.home

import com.farzin.weather.data.model.detail.AirPollution
import com.farzin.weather.data.model.home.Forecast
import com.farzin.weather.data.model.home.WeatherData
import com.farzin.weather.util.Constants.APP_ID
import com.farzin.weather.util.Constants.UNITS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface HomeApiInterface {


    @GET("weather")
    suspend fun getCurrentWeatherByName(
        @Query("appid") appId: String = APP_ID,
        @Query("units") units: String = UNITS,
        @Query("q") q: String,
        @Query("lang") lang: String ="en",
    ) : Response<WeatherData>


    @GET("forecast")
    suspend fun getWeatherForecast(
        @Query("appid") appId: String = APP_ID,
        @Query("units") units: String = UNITS,
        @Query("q") q: String,
        @Query("lang") lang: String = "en",
    ) : Response<Forecast>

    @GET("air_pollution/forecast")
    suspend fun getPollution(
        @Query("appid") appId: String = APP_ID,
        @Query("lat") lat: String ,
        @Query("lon") lon: String
    ) : Response<AirPollution>

}