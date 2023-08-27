package com.farzin.weather.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.farzin.weather.R
import com.farzin.weather.ui.theme.darkText
import com.farzin.weather.ui.theme.semidarkText
import com.farzin.weather.ui.theme.yellow
import com.farzin.weather.util.Constants.METRIC
import com.farzin.weather.util.Constants.UNITS
import com.farzin.weather.util.IconHelper.iconHelper

@Composable
fun HomeDegreeSection(
    temp: Int,
    feelsLike: Int,
    weatherDescription: String,
    icon: String,

    ) {

    val tempTitle =
        if (UNITS == METRIC)
            stringResource(R.string.celcius_symbol)
        else
            stringResource(R.string.farenheit_symbol)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = "$temp$tempTitle",
            style = TextStyle(
                color = MaterialTheme.colorScheme.darkText,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.displayLarge.fontSize
            )
        )


        Text(
            text ="${stringResource(R.string.feels_like)} $feelsLike $tempTitle",
            style = TextStyle(
                color = MaterialTheme.colorScheme.semidarkText,
                fontWeight = FontWeight.SemiBold,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize
            ),
            modifier = Modifier
                .padding(vertical = 10.dp)
        )


        Text(
            text = weatherDescription,
            style = TextStyle(
                color = MaterialTheme.colorScheme.yellow,
                fontWeight = FontWeight.SemiBold,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize
            )
        )

        Image(
            painter = rememberAsyncImagePainter(iconHelper(icon)),
            contentDescription = "",
            modifier = Modifier
                .size(60.dp)
                .padding(top = 10.dp)
        )

    }


}