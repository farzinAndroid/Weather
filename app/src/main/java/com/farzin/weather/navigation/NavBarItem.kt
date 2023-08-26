package com.farzin.weather.navigation

import androidx.compose.ui.graphics.painter.Painter

data class NavBarItem(
    val title:String,
    val route:String,
    val deselectedIcon:Painter,
    val selectedIcon:Painter,
)
