package com.farzin.weather.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.farzin.weather.ui.screens.city.City
import com.farzin.weather.ui.screens.city.CityScreen
import com.farzin.weather.ui.screens.detail.DetailScreen
import com.farzin.weather.ui.screens.home.HomeScreen
import com.farzin.weather.ui.screens.onboarding.OnBoardingScreen
import com.farzin.weather.ui.screens.search.Search
import com.farzin.weather.ui.screens.search.SearchScreen
import com.farzin.weather.ui.screens.setting.SettingScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String,
) {


    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable(route = Screens.OnBoarding.route) {
            OnBoardingScreen(
                navController = navController
            )
        }


        composable(route = Screens.Home.route) {
            HomeScreen(navController = navController)
        }



        composable(route = Screens.Search.route) {
            SearchScreen(navController=navController)
        }


        composable(route = Screens.Setting.route) {
            SettingScreen(navController)
        }


        composable(route = Screens.City.route) {
            CityScreen(navController = navController)
        }

        composable(
            route = Screens.Detail.route + "/{lat}/{long}/{cloud}",
            arguments =
            listOf(
                navArgument("lat") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = ""
                },
                navArgument("long") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = ""
                },
                navArgument("cloud") {
                    type = NavType.IntType
                    nullable = false
                    defaultValue = 0
                }
            ),

            ) {

            it.arguments?.getString("lat")?.let { lat ->
                it.arguments?.getString("long")?.let { long ->
                    it.arguments?.getInt("cloud")?.let { cloud ->
                        DetailScreen(
                            lat = lat,
                            long = long,
                            cloud = cloud
                        )
                    }
                }
            }


        }


    }


}