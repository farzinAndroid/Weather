package com.farzin.weather.ui.screens.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.stringSetPreferencesKey
import com.farzin.weather.R
import com.farzin.weather.ui.theme.darkText
import com.farzin.weather.ui.theme.fair
import com.farzin.weather.ui.theme.good
import com.farzin.weather.ui.theme.moderate
import com.farzin.weather.ui.theme.poor
import com.farzin.weather.ui.theme.semidarkText
import com.farzin.weather.ui.theme.verypoor
import com.farzin.weather.ui.theme.yellow
import com.farzin.weather.util.DigitHelper


@Composable
fun DetailAQISection(aqi:Int,currentTime:String) {


    val progressValue = mapValueToFloat(aqi,1,5,0.0f,1.0f)

    var aqiColor = Color.Transparent
    var aqiText = ""

    when(aqi){
         1->{
             aqiText = stringResource(R.string.good)
             aqiColor = MaterialTheme.colorScheme.good
         }
         2->{
             aqiText = stringResource(R.string.fair)
             aqiColor = MaterialTheme.colorScheme.fair
         }
         3->{
             aqiText = stringResource(R.string.moderate)
             aqiColor = MaterialTheme.colorScheme.moderate
         }
         4->{
             aqiText = stringResource(R.string.poor)
             aqiColor = MaterialTheme.colorScheme.poor
         }
         5->{
             aqiText = stringResource(R.string.very_poor)
             aqiColor = MaterialTheme.colorScheme.verypoor
         }
        else -> {}
    }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 8.dp)
            .padding(horizontal = 16.dp),
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = stringResource(R.string.today),
                style = TextStyle(
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    color = MaterialTheme.colorScheme.darkText,
                    fontWeight = FontWeight.SemiBold
                )
            )

            Text(
                text = currentTime,
                style = TextStyle(
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    color = MaterialTheme.colorScheme.semidarkText,
                    fontWeight = FontWeight.Normal
                )
            )

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .size(120.dp),
                contentAlignment = Alignment.Center,
            ){


                Card(
                    shape = CircleShape,
                    border = BorderStroke(3.dp, Color.LightGray.copy(0.1f)),
                    modifier = Modifier
                        .size(100.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent)
                ) {}

                CircularProgressIndicator(
                    progress = progressValue,
                    modifier = Modifier
                        .size(100.dp),
                    color = aqiColor,
                    strokeWidth = 3.dp
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = aqi.toString(),
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.darkText,
                            fontSize = MaterialTheme.typography.titleLarge.fontSize,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.SemiBold
                        )
                    )

                    Text(
                        text = stringResource(R.string.aqi),
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.semidarkText.copy(0.4f),
                            fontSize = MaterialTheme.typography.titleSmall.fontSize,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.SemiBold
                        )
                    )

                }

            }

            Text(
                text = aqiText,
                style = TextStyle(
                    color = MaterialTheme.colorScheme.darkText,
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold
                )
            )




        }

        Text(
            text = stringResource(R.string.aqi_desc),
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                color = MaterialTheme.colorScheme.semidarkText,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .padding(horizontal = 24.dp)
        )


    }


}



private fun mapValueToFloat(value: Int, inputMin: Int, inputMax: Int, outputMin: Float, outputMax: Float): Float {
    val inputRange = inputMax - inputMin
    val outputRange = outputMax - outputMin

    val normalizedValue = (value - inputMin).toFloat() / inputRange
    val mappedValue = outputMin + normalizedValue * outputRange

    return mappedValue
}