package com.farzin.weather.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farzin.weather.data.model.city.CityName
import com.farzin.weather.repo.CityRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CityViewModel @Inject constructor(private val repo: CityRepo) : ViewModel() {

    val allCities  = repo.allCities


    fun insertCity(cityName: CityName){
        viewModelScope.launch(Dispatchers.IO) {
            repo.insertCity(cityName)
        }
    }

    fun deleteCity(cityName: CityName){
        viewModelScope.launch(Dispatchers.IO) {
            repo.deleteCity(cityName)
        }
    }



}