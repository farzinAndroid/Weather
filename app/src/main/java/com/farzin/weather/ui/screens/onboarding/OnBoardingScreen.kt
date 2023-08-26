package com.farzin.weather.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.farzin.weather.R
import com.farzin.weather.data.model.city.CityName
import com.farzin.weather.navigation.Screens
import com.farzin.weather.ui.theme.darkText
import com.farzin.weather.ui.theme.onBoarding
import com.farzin.weather.ui.theme.placeholdercolor
import com.farzin.weather.ui.theme.semidarkText
import com.farzin.weather.ui.theme.yellow
import com.farzin.weather.util.Constants
import com.farzin.weather.viewmodel.DataStoreViewModel
import com.farzin.weather.viewmodel.CityViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Composable
fun OnBoardingScreen(
    navController: NavController,
    dataStoreViewModel: DataStoreViewModel = hiltViewModel(),
    cityViewModel: CityViewModel = hiltViewModel(),
) {


    var textValue by remember {
        mutableStateOf("")
    }

    var isEnabled by remember {
        mutableStateOf(false)
    }

    var isRadioButtonSelected by remember { mutableStateOf(false) }

    val pages = listOf(
        PageItem(
            title = stringResource(R.string.on_boarding_title),
            subTitle = stringResource(R.string.on_boarding_subtitle),
            image = painterResource(R.drawable.sun)
        )
    )


    val options = listOf(
        stringResource(R.string.celcius),
        stringResource(R.string.farenheit)
    )


    val context = LocalContext.current
    var selectedUnitState by remember { mutableStateOf(true) }


    var selectedOption by remember { mutableStateOf<String?>(null) }








    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onBoarding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        OnBoarding(page = pages[0])


        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                value = textValue,
                onValueChange = {
                    textValue = it
                    isEnabled = textValue.isNotBlank()

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 16.dp),
                placeholder = {

                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(R.string.enter_valid_city_name),
                            style = TextStyle(
                                color = MaterialTheme.colorScheme.placeholdercolor,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = MaterialTheme.typography.bodyMedium.fontSize
                            ),
                            textAlign = TextAlign.Center
                        )
                    }

                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    cursorColor = MaterialTheme.colorScheme.yellow,
                    unfocusedBorderColor = Color.Gray,
                    focusedBorderColor = MaterialTheme.colorScheme.yellow
                )
            )


            Button(
                onClick = {
                    navController.navigate(Screens.Home.route)
                    dataStoreViewModel.saveCityName(textValue)
                    dataStoreViewModel.saveOnBoardingState(true)
                    cityViewModel.insertCity(
                        CityName(name = textValue)
                    )
                },
                modifier = Modifier
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.yellow,
                ),
                enabled = isEnabled && isRadioButtonSelected
            ) {
                Text(text = stringResource(R.string.lets_get_started))
            }


            Column {

                Text(
                    text = stringResource(R.string.temp),
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.darkText,
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                        fontWeight = FontWeight.SemiBold
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    textAlign = TextAlign.Start
                )

                options.forEachIndexed { index, option ->


                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 24.dp),
                        verticalArrangement = Arrangement.Center
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Absolute.SpaceBetween
                        ) {

                            Text(
                                text = option,
                                style = TextStyle(
                                    color = MaterialTheme.colorScheme.semidarkText,
                                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                                    fontWeight = FontWeight.SemiBold
                                ),
                            )


                            RadioButton(
                                selected = (option == selectedOption),
                                onClick = {


                                    selectedOption = option

                                    if (option == context.getString(R.string.celcius)) {
                                        selectedUnitState = true
                                        dataStoreViewModel.saveUnit(Constants.METRIC)
                                        dataStoreViewModel.saveSelectedUnitState(selectedUnitState)

                                    } else {
                                        selectedUnitState = false
                                        dataStoreViewModel.saveUnit(Constants.IMPERIAL)
                                        dataStoreViewModel.saveSelectedUnitState(selectedUnitState)

                                    }

                                    isRadioButtonSelected = true

                                },
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = MaterialTheme.colorScheme.yellow,
                                    unselectedColor = MaterialTheme.colorScheme.semidarkText,
                                    disabledUnselectedColor = MaterialTheme.colorScheme.semidarkText,
                                )
                            )


                        }


                        if (index == 0) {
                            Divider(
                                thickness = 1.dp,
                                color = Color.Gray
                            )
                        }


                    }


                }

            }

        }


    }


}


@Composable
fun OnBoarding(page: PageItem) {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {


        Image(
            painter = page.image,
            contentDescription = "",
            modifier = Modifier
                .size(150.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = page.title,
            style = TextStyle(
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = page.subTitle,
            style = TextStyle(
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )
        )


    }

}