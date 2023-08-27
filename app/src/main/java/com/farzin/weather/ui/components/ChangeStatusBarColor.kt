package com.farzin.weather.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
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