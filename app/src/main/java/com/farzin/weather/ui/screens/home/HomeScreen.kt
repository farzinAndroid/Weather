package com.farzin.weather.ui.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.farzin.weather.data.internet.NetworkResult
import com.farzin.weather.data.model.home.ForeCastList
import com.farzin.weather.ui.components.AppConfig
import com.farzin.weather.ui.components.ErrorAlertDialog
import com.farzin.weather.ui.components.ErrorSection
import com.farzin.weather.ui.components.LoadingSection
import com.farzin.weather.ui.theme.onBoarding
import com.farzin.weather.util.Constants.CITY_NAME
import com.farzin.weather.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel(), navController: NavHostController) {

    AppConfig()

    Home(homeViewModel, navController)


}

@Composable
fun Home(homeViewModel: HomeViewModel, navController: NavHostController) {

    LaunchedEffect(true) {
        homeViewModel.getCurrentWeatherByName(CITY_NAME)
    }


    LaunchedEffect(true) {
        homeViewModel.getTodayWeatherForecast(CITY_NAME)
    }


    SwipeRefreshSection(vm = homeViewModel, navController = navController)

}


@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun SwipeRefreshSection(vm: HomeViewModel, navController: NavHostController) {
    val onRefresh = rememberCoroutineScope()
    val swipeRefreshState = rememberPullRefreshState(refreshing = false, onRefresh = {
        onRefresh.launch {

            launch {
                vm.getCurrentWeatherByName(CITY_NAME)
            }


            launch {
                vm.getTodayWeatherForecast(CITY_NAME)
            }




            Log.e("TAG", "Refresh")
        }
    })


    Box(
        Modifier
            .fillMaxSize()
            .pullRefresh(swipeRefreshState),
        contentAlignment = Alignment.Center
    ) {


        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            val config = LocalConfiguration.current

            var loading by remember { mutableStateOf(false) }
            var error by remember { mutableStateOf(false) }
            var dialogOpened by remember{ mutableStateOf(false) }

            var cityName by remember { mutableStateOf("") }
            var temp by remember { mutableStateOf(0) }
            var weatherDesc by remember { mutableStateOf("") }
            var feelsLike by remember { mutableStateOf(0) }
            var icon by remember { mutableStateOf("") }
            var windSpeed by remember { mutableStateOf(0) }
            var visibility by remember { mutableStateOf(0) }
            var humidity by remember { mutableStateOf(0) }
            var lat by remember { mutableStateOf(0.0) }
            var long by remember { mutableStateOf(0.0) }
            var cloud by remember { mutableStateOf(0) }


            var foreCastListForFuture by remember {
                mutableStateOf<List<ForeCastList>>(emptyList())
            }


            LaunchedEffect(true) {
                vm.filteredForecastForFuture.collectLatest { filteredForecastForFuture ->
                    foreCastListForFuture = filteredForecastForFuture.data ?: emptyList()
                }
            }


            val result by vm.weather.collectAsState()
            when (result) {

                is NetworkResult.Success -> {
                    loading = false
                    error = false
                    cityName = result.data?.name ?: ""
                    weatherDesc = result.data?.weather?.get(0)?.description ?: ""
                    temp = (result.data?.main?.temp ?: 0).toInt()
                    feelsLike = (result.data?.main?.feels_like ?: 0).toInt()
                    icon = result.data?.weather?.get(0)?.icon ?: ""
                    windSpeed = (result.data?.wind?.speed ?: 0).toInt()
                    visibility = result.data?.visibility ?: 0
                    humidity = result.data?.main?.humidity ?: 0
                    lat = result.data?.coord?.lat ?: 0.0
                    long = result.data?.coord?.lon ?: 0.0
                    cloud = result.data?.clouds?.all ?: 0

                }

                is NetworkResult.Loading -> {
                    loading = true
                    error = false
                }

                is NetworkResult.Error -> {
                    loading = false
                    error = true
                    dialogOpened = true
                }

            }



            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.onBoarding)
                    .padding(bottom = 60.dp)
            ) {

                if (loading) {

                    item { LoadingSection(config.screenHeightDp.dp) }
                }else if (error){
                    item { ErrorSection(config.screenHeightDp.dp) }
                }
                else {

                    item { HomeCitySection(cityName) }
                    item { HomeDegreeSection(temp, feelsLike, weatherDesc, icon) }
                    item { HomeMiddleSection(windSpeed, visibility, navController, lat, long, cloud) }
                    item { HomeHumiditySection(humidity) }
                    item { HomeTodayForecastSection() }
                    items(foreCastListForFuture) { item ->
                        FutureForeCastItem(item)
                    }

                }


            }


        }


        PullRefreshIndicator(
            refreshing = false,
            state = swipeRefreshState,
            modifier = Modifier.align(Alignment.TopCenter),
        )
    }
}

