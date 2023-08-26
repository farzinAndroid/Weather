package com.farzin.weather.ui.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.farzin.weather.R
import com.farzin.weather.data.internet.NetworkResult
import com.farzin.weather.data.model.home.ForeCastList
import com.farzin.weather.data.model.home.Forecast
import com.farzin.weather.ui.components.ErrorAlertDialog
import com.farzin.weather.ui.components.ErrorSection
import com.farzin.weather.ui.components.LoadingSection
import com.farzin.weather.ui.screens.home.FutureForeCastItem
import com.farzin.weather.ui.theme.placeholdercolor
import com.farzin.weather.ui.theme.yellow
import com.farzin.weather.viewmodel.HomeViewModel
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchLazyColumn(homeViewModel: HomeViewModel, navController: NavController) {

    var textValue by rememberSaveable {
        mutableStateOf("")
    }

    val scope = rememberCoroutineScope()

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = textValue,
            onValueChange = {
                textValue = it
            },
            modifier = Modifier
                .weight(0.7f)
                .height(60.dp)
                .padding(horizontal = 8.dp),
            placeholder = {

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(R.string.enter_valid_city_name),
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.placeholdercolor,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = MaterialTheme.typography.bodyMedium.fontSize
                        ),
                        textAlign = TextAlign.Center
                    )
                }

            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                cursorColor = MaterialTheme.colorScheme.yellow,
                unfocusedBorderColor = Color.Gray,
                focusedBorderColor = MaterialTheme.colorScheme.yellow
            )
        )

        Button(
            onClick = {
                scope.launch {
                    homeViewModel.getCurrentWeatherByName(textValue)
                    homeViewModel.getFutureDaysForeCast(textValue)
                }
            },
            modifier = Modifier
                .weight(0.3f)
                .padding(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.yellow,
            )
        ) {
            Text(
                text = stringResource(R.string.search),
                style = TextStyle(
                    fontSize = MaterialTheme.typography.labelLarge.fontSize
                )
            )
        }


    }

//////////////////////////////////////////////////////////////////////////////////////////////


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
            .fillMaxWidth()
            .height(900.dp)
    ) {

        if (name.isNullOrBlank()) {
            item { }
        } else if (loading) {
            item {

                LoadingSection(config.screenHeightDp.dp)
            }
        }
        else {

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