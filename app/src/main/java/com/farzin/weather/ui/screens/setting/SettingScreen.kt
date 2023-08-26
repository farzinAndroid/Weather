package com.farzin.weather.ui.screens.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.farzin.weather.R
import com.farzin.weather.navigation.Screens
import com.farzin.weather.ui.components.AppConfig
import com.farzin.weather.ui.theme.darkText
import com.farzin.weather.ui.theme.onBoarding
import com.farzin.weather.util.Constants.CITY_NAME
import com.farzin.weather.viewmodel.DataStoreViewModel
import kotlinx.coroutines.launch

@Composable
fun SettingScreen(navController: NavController) {

    AppConfig()

    Setting(navController = navController)


}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Setting(dataStoreViewModel: DataStoreViewModel = hiltViewModel(),navController: NavController) {


    val coroutineScope = rememberCoroutineScope()

    var selectedUnitState by remember { mutableStateOf(dataStoreViewModel.getSelectedUnitState()) }

    val modalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmValueChange = { it != ModalBottomSheetValue.HalfExpanded },
        skipHalfExpanded = false
    )

    val title = if (selectedUnitState == true){
        stringResource(R.string.celcius)
    }else{
        stringResource(R.string.farenheit)
    }




    ModalBottomSheetLayout(
        sheetContent = {
            SettingsBottomSheet{bool->
                selectedUnitState = bool
            }
        },
        sheetState = modalBottomSheetState
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.onBoarding)
                .padding(bottom = 60.dp),
            contentAlignment = Alignment.TopCenter
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.onBoarding)
                    .padding(bottom = 60.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = stringResource(R.string.setting),
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                        color = MaterialTheme.colorScheme.darkText,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 40.dp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                        .padding(horizontal = 28.dp),
                    horizontalAlignment = Alignment.Start
                ) {

                    SettingsItem(
                        title = stringResource(R.string.temp_unit),
                        subTitle = title,
                        onClick = {
                            coroutineScope.launch {
                                if (modalBottomSheetState.isVisible) {
                                    modalBottomSheetState.hide()
                                } else {
                                    modalBottomSheetState.show()
                                }
                            }
                        }
                    )


                    SettingsItem(
                        title = stringResource(R.string.city),
                        subTitle = CITY_NAME,
                        isHaveArrow = true,
                        onClick = {
                            navController.navigate(Screens.City.route)
                        }
                    )


                }

            }

        }

    }


}