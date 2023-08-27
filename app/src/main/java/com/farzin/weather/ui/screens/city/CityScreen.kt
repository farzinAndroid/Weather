package com.farzin.weather.ui.screens.city

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.farzin.weather.ui.theme.onBoarding
import com.farzin.weather.viewmodel.CityViewModel
import com.farzin.weather.viewmodel.DataStoreViewModel

@Composable
fun CityScreen(
    cityViewModel: CityViewModel = hiltViewModel(),
    dataStoreViewModel: DataStoreViewModel = hiltViewModel(),
    navController: NavController
) {

    City(cityViewModel, dataStoreViewModel,navController)

}


@Composable
fun City(cityViewModel: CityViewModel, dataStoreViewModel: DataStoreViewModel,navController: NavController) {


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onBoarding)
            .padding(bottom = 60.dp)
    ) {

        item { CityScreenHeader() }
        item { CityScreenTextFieldSection(cityViewModel, dataStoreViewModel) }
        item { SavedCity() }
        item { SavedCitiesSection(navController=navController) }

    }


}


