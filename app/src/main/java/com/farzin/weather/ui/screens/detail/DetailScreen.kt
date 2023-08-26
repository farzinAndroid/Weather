package com.farzin.weather.ui.screens.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.farzin.weather.util.DateHelper
import com.farzin.weather.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun DetailScreen(lat: String, long: String, cloud: Int, vm: HomeViewModel = hiltViewModel()) {


    LaunchedEffect(true) {
        vm.getPollution(lat, long)
    }

    Detail(vm,cloud)

}

@Composable
fun Detail(vm: HomeViewModel, cloud: Int) {


    var aqi by remember { mutableStateOf(0) }
    var dt by remember { mutableStateOf(0) }
    var o3 by remember { mutableStateOf(0.0) }
    var pm2_5 by remember { mutableStateOf(0.0) }
    var pm10 by remember { mutableStateOf(0.0) }
    var no2 by remember { mutableStateOf(0.0) }

    LaunchedEffect(true) {
        vm.filteredPollution.collectLatest { filteredPollution ->
            aqi = filteredPollution.data?.get(0)?.main?.aqi ?: 0
            dt = filteredPollution.data?.get(0)?.dt ?: 0
            o3 = filteredPollution.data?.get(0)?.components?.o3 ?: 0.0
            pm2_5 = filteredPollution.data?.get(0)?.components?.pm2_5 ?: 0.0
            pm10 = filteredPollution.data?.get(0)?.components?.pm10 ?: 0.0
            no2 = filteredPollution.data?.get(0)?.components?.no2 ?: 0.0
        }
    }






    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {

        item { DetailTitleSection() }
        item { DetailAQISection(aqi, DateHelper.unixToNormalTime(dt.toLong())) }
        item {
            DetailCurrentPollutantsSection(
                o3 = o3,
                pm2_5 = pm2_5,
                pm10 = pm10,
                no2 = no2,
            )
        }
        item { DetailCloudinessSection(cloud) }

    }


}