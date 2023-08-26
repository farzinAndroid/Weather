package com.farzin.weather.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farzin.weather.data.datastore.DataStoreRepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class DataStoreViewModel @Inject constructor(private val repo: DataStoreRepoImpl) : ViewModel() {


    companion object {
        const val CITY_KEY = "CITY_KEY"
        const val ON_BOARDING_KEY = "ON_BOARDING_KEY"
        const val UNITS_KEY = "UNITS_KEY"
        const val UNITS_STATE_KEY = "UNITS_STATE_KEY"
    }


    fun saveCityName(value: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.putString(CITY_KEY, value)
        }
    }

    fun saveOnBoardingState(value: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.putBoolean(ON_BOARDING_KEY, value)
        }
    }


    fun saveUnit(value: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.putString(UNITS_KEY, value)
        }
    }


    fun saveSelectedUnitState(value: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.putBoolean(UNITS_STATE_KEY, value)
        }
    }


    fun getCityName(): String? = runBlocking {
        repo.getString(CITY_KEY)
    }


    fun getOnBoardingState(): Boolean? = runBlocking {
        repo.getBoolean(ON_BOARDING_KEY)
    }


    fun getUnit(): String? = runBlocking {
        repo.getString(UNITS_KEY)
    }

    fun getSelectedUnitState(): Boolean? = runBlocking {
        repo.getBoolean(UNITS_STATE_KEY)
    }


}