package com.farzin.weather.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)




val ColorScheme.selectedBottomBar: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFFCFD4DA) else Color(0xFF43474C)


val ColorScheme.unselectedBottomBar: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFFCECECE) else Color(0xFFFFFFFF)



val ColorScheme.bottomBarColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF2B2B2B) else Color(0xFFB6B6B6)

val ColorScheme.darkText: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFFDFDEDE) else Color(0xFF383838)


val ColorScheme.semidarkText: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFFCACACA) else Color(0xFF4E4E4E)


val ColorScheme.yellow: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFFFFC600) else Color(0xFFBD9200)


val ColorScheme.onBoarding: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF292929) else Color(0xFFFFFFFF)


val ColorScheme.foreCastCard: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xC67C7C7C) else Color(0xFFD5D5D5)


val ColorScheme.onBoardingButton: Color
    @Composable
    get() = if (isSystemInDarkTheme())  Color(0xFF00B2CC) else Color(0xFF001C53)


val ColorScheme.placeholdercolor: Color
    @Composable
    get() = if (isSystemInDarkTheme())  Color(0xD5939494) else Color(0x8B1A1A1A)


val ColorScheme.fair: Color
    @Composable
    get() = Color(0xD500A503)


val ColorScheme.good: Color
    @Composable
    get() = Color(0xD500E704)

val ColorScheme.moderate: Color
    @Composable
    get() = Color(0xFFFFC600)


val ColorScheme.poor: Color
    @Composable
    get() = Color(0xFFD65600)


val ColorScheme.verypoor: Color
    @Composable
    get() = Color(0xFFD80000)

