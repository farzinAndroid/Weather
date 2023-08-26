package com.farzin.weather.ui.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.farzin.weather.navigation.Screens
import com.farzin.weather.ui.components.AppConfig
import com.farzin.weather.ui.theme.onBoarding
import com.farzin.weather.viewmodel.HomeViewModel

@Composable
fun SearchScreen(homeViewModel: HomeViewModel = hiltViewModel(),navController: NavController) {

    AppConfig()

    Search(homeViewModel,navController)


}

@Composable
fun Search(homeViewModel: HomeViewModel,navController: NavController) {


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onBoarding)
            .padding(bottom = 60.dp),
    ) {

        SearchTitle()

        SearchLazyColumn(homeViewModel,navController)

    }

}