package com.farzin.weather.ui.screens.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.farzin.weather.R
import com.farzin.weather.ui.theme.fair
import com.farzin.weather.ui.theme.good
import com.farzin.weather.ui.theme.moderate
import com.farzin.weather.ui.theme.poor
import com.farzin.weather.ui.theme.semidarkText
import com.farzin.weather.ui.theme.verypoor


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DetailCurrentPollutantsSection(
    o3: Double,
    pm2_5: Double,
    pm10: Double,
    no2: Double,
) {

    var o3Color: Color
    var o3Text: String
    when(o3){
       in 0.0..60.0 ->{
           o3Text = stringResource(R.string.good)
           o3Color = MaterialTheme.colorScheme.good
        }
        in 20.0..80.0->{
            o3Text = stringResource(R.string.fair)
            o3Color = MaterialTheme.colorScheme.fair
        }
        in 80.0..250.0->{
            o3Text = stringResource(R.string.moderate)
            o3Color = MaterialTheme.colorScheme.moderate
        }
        in 250.0..350.0->{
            o3Text = stringResource(R.string.poor)
            o3Color = MaterialTheme.colorScheme.poor
        }
        else->{
            o3Text = stringResource(R.string.very_poor)
            o3Color = MaterialTheme.colorScheme.verypoor
        }
    }

    var pm25Color: Color
    var pm25Text: String
    when(pm2_5){
        in 0.0..10.0 ->{
            pm25Text = stringResource(R.string.good)
            pm25Color = MaterialTheme.colorScheme.good
        }
        in 10.0..25.0->{
            pm25Text = stringResource(R.string.fair)
            pm25Color = MaterialTheme.colorScheme.fair
        }
        in 25.0..50.0->{
            pm25Text = stringResource(R.string.moderate)
            pm25Color = MaterialTheme.colorScheme.moderate
        }
        in 50.0..75.0->{
            pm25Text = stringResource(R.string.poor)
            pm25Color = MaterialTheme.colorScheme.poor
        }
        else->{
            pm25Text = stringResource(R.string.very_poor)
            pm25Color = MaterialTheme.colorScheme.verypoor
        }
    }


    var pm10Color: Color
    var pm10Text: String
    when(pm10){
        in 0.0..20.0 ->{
            pm10Text = stringResource(R.string.good)
            pm10Color = MaterialTheme.colorScheme.good
        }
        in 20.0..50.0->{
            pm10Text = stringResource(R.string.fair)
            pm10Color = MaterialTheme.colorScheme.fair
        }
        in 50.0..100.0->{
            pm10Text = stringResource(R.string.moderate)
            pm10Color = MaterialTheme.colorScheme.moderate
        }
        in 100.0..200.0->{
            pm10Text = stringResource(R.string.poor)
            pm10Color = MaterialTheme.colorScheme.poor
        }
        else->{
            pm10Text = stringResource(R.string.very_poor)
            pm10Color = MaterialTheme.colorScheme.verypoor
        }
    }

    var no2Color: Color
    var no2Text: String
    when(no2){
        in 0.0..40.0 ->{
            no2Text = stringResource(R.string.good)
            no2Color = MaterialTheme.colorScheme.good
        }
        in 40.0..70.0->{
            no2Text = stringResource(R.string.fair)
            no2Color = MaterialTheme.colorScheme.fair
        }
        in 70.0..150.0->{
            no2Text = stringResource(R.string.moderate)
            no2Color = MaterialTheme.colorScheme.moderate
        }
        in 150.0..200.0->{
            no2Text = stringResource(R.string.poor)
            no2Color = MaterialTheme.colorScheme.poor
        }
        else->{
            no2Text = stringResource(R.string.very_poor)
            no2Color = MaterialTheme.colorScheme.verypoor
        }
    }




    val pollutantNameList = listOf(
        stringResource(R.string.o3),
        stringResource(R.string.pm25),
        stringResource(R.string.pm10),
        stringResource(R.string.no2),
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(top = 40.dp)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = stringResource(R.string.current_air_pollut),
            style = TextStyle(
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                color = MaterialTheme.colorScheme.semidarkText,
                fontWeight = FontWeight.SemiBold
            )
        )

        Divider(
            thickness = 1.dp,
            color = Color.LightGray,
            modifier = Modifier
                .padding(top = 8.dp)
        )


    }


    Row(
        modifier =Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        PollutantItem(
            pollutantName =pollutantNameList[0],
            quality =o3Text,
            pollutantValue =o3.toString(),
            description = stringResource(R.string.o3desc),
            color = o3Color,
            modifier = Modifier.weight(0.5f)
        )

        PollutantItem(
            pollutantName =pollutantNameList[1],
            quality =pm25Text,
            pollutantValue =pm2_5.toString(),
            description =stringResource(R.string.pm25desc),
            color = pm25Color,
            modifier = Modifier.weight(0.5f)
        )

    }


    Spacer(modifier = Modifier.height(16.dp))

    Row(
        modifier =Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        PollutantItem(
            pollutantName =pollutantNameList[2],
            quality =pm10Text,
            pollutantValue =pm10.toString(),
            description =stringResource(R.string.pm10desc),
            color = pm10Color,
            modifier = Modifier.weight(0.5f)
        )

        PollutantItem(
            pollutantName =pollutantNameList[3],
            quality =no2Text,
            pollutantValue =no2.toString(),
            description =stringResource(R.string.no2desc),
            color = no2Color,
            modifier = Modifier.weight(0.5f)
        )

    }

    Spacer(modifier = Modifier.height(8.dp))


}