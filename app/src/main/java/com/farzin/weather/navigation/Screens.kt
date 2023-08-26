package com.farzin.weather.navigation

sealed class Screens(val route:String){

    object OnBoarding : Screens(route = "onboarding_screen")
    object Home : Screens(route = "home_screen")
    object Search : Screens(route = "search_screen")
    object Setting : Screens(route = "setting_screen")
    object City : Screens(route = "city_screen")
    object Detail : Screens(route = "detail_screen")

}
