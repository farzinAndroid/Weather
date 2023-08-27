package com.farzin.weather.ui.screens.city

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.farzin.weather.viewmodel.CityViewModel

@Composable
fun SavedCitiesSection(vm:CityViewModel = hiltViewModel(),navController: NavController) {





    val result by vm.allCities.collectAsState(initial = emptyList())

    val cityList = result



    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
    ){

        items(cityList){item->
            CityItem(
               item =  item,
                navController = navController
            )
        }

    }



}