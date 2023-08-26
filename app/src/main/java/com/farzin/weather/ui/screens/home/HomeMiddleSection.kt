package com.farzin.weather.ui.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.farzin.weather.R
import com.farzin.weather.navigation.Screens
import com.farzin.weather.ui.theme.semidarkText
import com.farzin.weather.ui.theme.yellow
import com.farzin.weather.util.Constants.METRIC
import com.farzin.weather.util.Constants.UNITS

@Composable
fun HomeMiddleSection(
    windSpeed:Int,
    visibility:Int,
    navController: NavController,
    lat:Double,
    long:Double,
    cloud:Int
) {


    val windTitle = if (UNITS == METRIC)
        stringResource(R.string.ms)
    else
        stringResource(R.string.mh)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(R.drawable.wind),
                    contentDescription = "",
                    modifier = Modifier
                        .size(24.dp),
                    tint = MaterialTheme.colorScheme.yellow
                )


                Text(
                    text = "$windSpeed $windTitle",
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.semidarkText,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    ),
                    modifier = Modifier
                        .padding(start = 8.dp)
                )


            }


            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable {
                        navController.navigate(Screens.Detail.route + "/$lat/$long/$cloud")
                    }
            ){
                Text(
                    text = stringResource(R.string.more),
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.semidarkText,
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        textDecoration = TextDecoration.Underline
                    )
                )

                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "",
                    modifier = Modifier
                        .size(16.dp)
                        .padding(start = 4.dp)
                )

            }

        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(R.drawable.visibility),
                    contentDescription = "",
                    modifier = Modifier
                        .size(24.dp),
                    tint = MaterialTheme.colorScheme.yellow
                )


                Text(
                    text = "${stringResource(R.string.visibility)} ${(visibility / 1000)} ${stringResource(
                        R.string.km
                    )}",
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.semidarkText,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    ),
                    modifier = Modifier
                        .padding(start = 8.dp)
                )


            }
        }


    }


}