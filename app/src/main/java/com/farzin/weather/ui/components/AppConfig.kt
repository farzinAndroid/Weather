package com.farzin.weather.ui.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.farzin.weather.util.Constants.CITY_NAME
import com.farzin.weather.util.Constants.UNITS
import com.farzin.weather.viewmodel.DataStoreViewModel


@Composable
fun AppConfig(
    dataStoreViewModel: DataStoreViewModel = hiltViewModel(),
) {

    getDataStoreVariables(dataStoreViewModel)

}

private fun getDataStoreVariables(dataStoreViewModel: DataStoreViewModel){

    CITY_NAME = dataStoreViewModel.getCityName().toString()
    UNITS = dataStoreViewModel.getUnit().toString()

}