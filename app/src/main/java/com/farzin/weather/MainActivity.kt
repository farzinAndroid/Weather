package com.farzin.weather

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.farzin.weather.navigation.BottomNavBar
import com.farzin.weather.navigation.Screens
import com.farzin.weather.navigation.SetupNavGraph
import com.farzin.weather.ui.components.AppConfig
import com.farzin.weather.ui.components.ChangeStatusBarColor
import com.farzin.weather.ui.theme.WeatherTheme
import com.farzin.weather.viewmodel.DataStoreViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme {

                val navController = rememberNavController()
                val dataStoreViewModel: DataStoreViewModel = viewModel()

                AppConfig()
                ChangeStatusBarColor()




                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                ) {

                    Scaffold(
                        content = {
                            SetupNavGraph(
                                navController = navController,
                                startDestination = getStartingDestination(dataStoreViewModel)
                            )
                        },
                        bottomBar = {
                            BottomNavBar(
                                navHostController = navController,
                                onClick = {
                                    navController.navigate(it.route)
                                }
                            )

                        }

                    )


                }


            }
        }
    }

    private fun getStartingDestination(dataStoreViewModel: DataStoreViewModel): String =
        if (dataStoreViewModel.getOnBoardingState() == true) {
            Screens.Home.route
        } else {
            Screens.OnBoarding.route
        }

}