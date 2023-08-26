package com.farzin.weather.ui.screens.setting

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceBetween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.farzin.weather.R
import com.farzin.weather.ui.theme.darkText
import com.farzin.weather.ui.theme.onBoarding
import com.farzin.weather.ui.theme.semidarkText
import com.farzin.weather.ui.theme.yellow
import com.farzin.weather.util.Constants.IMPERIAL
import com.farzin.weather.util.Constants.METRIC
import com.farzin.weather.viewmodel.DataStoreViewModel

@SuppressLint("UnrememberedMutableState")
@Composable
fun SettingsBottomSheet(
    dataStoreViewModel: DataStoreViewModel = hiltViewModel(),
    onCallBack:(Boolean)->Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(MaterialTheme.colorScheme.onBoarding)
    ) {

        val options = listOf(
            stringResource(R.string.celcius),
            stringResource(R.string.farenheit)
        )



        val context = LocalContext.current
        var selectedUnitState by remember { mutableStateOf(true) }


        var selectedOption by if (dataStoreViewModel.getSelectedUnitState() == true)
            remember { mutableStateOf(options[0]) }
        else
            remember { mutableStateOf(options[1]) }






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
                        verticalAlignment = CenterVertically,
                        horizontalArrangement = SpaceBetween
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
                                    dataStoreViewModel.saveUnit(METRIC)
                                    dataStoreViewModel.saveSelectedUnitState(selectedUnitState)
                                    onCallBack(selectedUnitState)
                                } else {
                                    selectedUnitState = false
                                    dataStoreViewModel.saveUnit(IMPERIAL)
                                    dataStoreViewModel.saveSelectedUnitState(selectedUnitState)
                                    onCallBack(selectedUnitState)
                                }

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