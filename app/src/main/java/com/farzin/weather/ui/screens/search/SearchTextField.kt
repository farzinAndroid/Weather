package com.farzin.weather.ui.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.farzin.weather.R
import com.farzin.weather.ui.theme.placeholdercolor
import com.farzin.weather.ui.theme.yellow
import com.farzin.weather.viewmodel.HomeViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTextField(
    homeViewModel:HomeViewModel,
    textCallBack:(String)->Unit
) {

    var textValue by rememberSaveable {
        mutableStateOf("")
    }

    val scope = rememberCoroutineScope()

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = textValue,
            onValueChange = {
                textValue = it
            },
            modifier = Modifier
                .weight(0.7f)
                .height(60.dp)
                .padding(horizontal = 8.dp),
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
                scope.launch {
                    homeViewModel.getCurrentWeatherByName(textValue)
                    homeViewModel.getFutureDaysForeCast(textValue)
                    textCallBack(textValue)
                }
            },
            modifier = Modifier
                .weight(0.3f)
                .padding(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.yellow,
            )
        ) {
            Text(
                text = stringResource(R.string.search),
                style = TextStyle(
                    fontSize = MaterialTheme.typography.labelLarge.fontSize
                )
            )
        }


    }

}