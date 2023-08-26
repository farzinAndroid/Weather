package com.farzin.weather.ui.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.farzin.weather.navigation.Screens
import com.farzin.weather.ui.theme.onBoarding
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ChangeStatusBarColor() {


    val systemUiController = rememberSystemUiController()


    val statusBarColor = MaterialTheme.colorScheme.onBoarding


    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor
        )
    }


}