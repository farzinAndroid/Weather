package com.farzin.weather.ui.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.farzin.weather.data.internet.NetworkResult
import com.farzin.weather.data.model.home.ForeCastList
import com.farzin.weather.ui.components.AppConfig
import com.farzin.weather.ui.components.LoadingSection
import com.farzin.weather.ui.screens.home.FutureForeCastItem
import com.farzin.weather.ui.theme.onBoarding
import com.farzin.weather.viewmodel.HomeViewModel

@Composable
fun SearchScreen(homeViewModel: HomeViewModel = hiltViewModel()) {

    AppConfig()

    Search(homeViewModel)


}

@Composable
fun Search(homeViewModel: HomeViewModel) {

    var textValue by rememberSaveable {
        mutableStateOf("")
    }


    var loading by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf(false) }
    var name by remember { mutableStateOf("") }
    var desc by remember { mutableStateOf("") }
    var icon by remember { mutableStateOf("") }
    var temp by remember { mutableStateOf(0.0) }
    var wind by remember { mutableStateOf(0.0) }
    var visibilty by remember { mutableStateOf(0) }
    var humidity by remember { mutableStateOf(0) }

    val result by homeViewModel.weather.collectAsState()
    when (result) {

        is NetworkResult.Success -> {
            loading = false
            error = false
            name = result.data?.name ?: ""
            desc = result.data?.weather?.get(0)?.description ?: ""
            icon = result.data?.weather?.get(0)?.icon ?: ""
            temp = result.data?.main?.temp ?: 0.0
            wind = result.data?.wind?.speed ?: 0.0
            wind = result.data?.wind?.speed ?: 0.0
            visibilty = result.data?.visibility ?: 0
            humidity = result.data?.main?.humidity ?: 0

        }

        is NetworkResult.Loading -> {
            loading = true
            error = false
        }

        is NetworkResult.Error -> {
            loading = false
            error = true
        }

    }
//////////////////////////////////////////////////////////////////////////////////////////////

    val config = LocalConfiguration.current


    var futureDaysLoading by remember { mutableStateOf(false) }

    var futureForcastList by remember { mutableStateOf<List<ForeCastList>>(emptyList()) }

    val futureDaysResult by homeViewModel.searchFutureForecast.collectAsState()
    when (futureDaysResult) {

        is NetworkResult.Success -> {
            futureDaysLoading = false
            futureForcastList = futureDaysResult.data?.list ?: emptyList()

        }

        is NetworkResult.Loading -> {
            futureDaysLoading = true
        }

        is NetworkResult.Error -> {
            futureDaysLoading = false
        }

    }


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onBoarding)
            .padding(bottom = 60.dp),
    ) {

        item { SearchTitle() }


        item {
            SearchTextField(
                homeViewModel = homeViewModel,
                textCallBack = {
                    textValue = it
                }
            )
        }

        if (name.isNullOrBlank()) {
            item { }
        } else if (loading) {
            item {

                LoadingSection(config.screenHeightDp.dp)
            }
        } else {

            item { SearchTitleSection(name = name) }
            item { SearchDegreeSection(temp = temp.toInt(), desc = desc, icon = icon) }
            item {
                SearchWindAndVisibilitySection(
                    visibility = visibilty,
                    windSpeed = wind.toInt(),
                )
            }
            item { SearchHumiditySection(humidity = humidity) }

            items(futureForcastList) { item ->
                FutureForeCastItem(
                    item,
                    true
                )
            }

        }

    }

}