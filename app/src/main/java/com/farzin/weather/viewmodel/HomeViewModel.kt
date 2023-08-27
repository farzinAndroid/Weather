package com.farzin.weather.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farzin.weather.data.internet.NetworkResult
import com.farzin.weather.data.model.detail.AirPollution
import com.farzin.weather.data.model.home.Forecast
import com.farzin.weather.data.model.home.WeatherData
import com.farzin.weather.repo.HomeRepo
import com.farzin.weather.util.DateHelper
import com.farzin.weather.util.DateHelper.getCurrentDate2
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.abs

@HiltViewModel
class HomeViewModel @Inject constructor(private val repo: HomeRepo) : ViewModel() {

    val weather = MutableStateFlow<NetworkResult<WeatherData>>(NetworkResult.Loading())
    val foreCastToday = MutableStateFlow<NetworkResult<Forecast>>(NetworkResult.Loading())
    val foreCastFutureDays = MutableStateFlow<NetworkResult<Forecast>>(NetworkResult.Loading())
    val pollution = MutableStateFlow<NetworkResult<AirPollution>>(NetworkResult.Loading())

    val searchFutureForecast = MutableStateFlow<NetworkResult<Forecast>>(NetworkResult.Loading())


    fun getCurrentWeatherByName(q: String) {
        viewModelScope.launch {
            weather.emit(repo.getCurrentWeatherByName(q))
        }
    }


    fun getTodayWeatherForecast(q: String) {
        viewModelScope.launch {
            foreCastToday.emit(repo.getWeatherForecast(q))
            foreCastFutureDays.emit(repo.getWeatherForecast(q))
        }
    }

    fun getPollution(lat: String, lon: String) {
        viewModelScope.launch {
            pollution.emit(repo.getPollution(lat, lon))
        }
    }

    fun getFutureDaysForeCast(q:String){
        viewModelScope.launch {
            searchFutureForecast.emit(repo.getWeatherForecast(q))
        }
    }


    val filteredForecastForToday = foreCastToday.map { networkresult ->
        when (networkresult) {
            is NetworkResult.Success -> {
                val items = networkresult.data
                val filteredItems = items?.list?.filter { it.dt_txt.contains(getCurrentDate2()) }
                NetworkResult.Success("Success", filteredItems)
            }

            is NetworkResult.Error -> {
                NetworkResult.Error(message = "Error", data = null)
            }

            is NetworkResult.Loading -> {
                NetworkResult.Loading()
            }
        }
    }


    val filteredForecastForFuture = foreCastFutureDays.map { networkresult ->
        when (networkresult) {
            is NetworkResult.Success -> {
                val items = networkresult.data
                val filteredItems = items?.list?.filter { it.dt_txt.contains("12:00:00") }
                NetworkResult.Success("Success", filteredItems)
            }

            is NetworkResult.Error -> {
                NetworkResult.Error(message = "Error", data = null)
            }

            is NetworkResult.Loading -> {
                NetworkResult.Loading()
            }
        }
    }


    val filteredPollution = pollution.map { networkResult ->
        when (networkResult) {
            is NetworkResult.Success -> {
                val items = networkResult.data?.list
                if (!items.isNullOrEmpty()) {
                    val currentTime = DateHelper.getTimeAsUnix().toLong()
                    val closestItem = items.minByOrNull { abs(it.dt - currentTime) }
                    NetworkResult.Success("Success", listOfNotNull(closestItem))
                } else {
                    NetworkResult.Success("Success", emptyList())
                }
            }

            is NetworkResult.Error -> NetworkResult.Error(message = "Error", data = null)
            is NetworkResult.Loading -> NetworkResult.Loading()
        }
    }
}


