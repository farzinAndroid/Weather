package com.farzin.weather.ui.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.farzin.weather.R
import com.farzin.weather.ui.theme.semidarkText
import com.farzin.weather.ui.theme.yellow
import com.farzin.weather.util.Constants

@Composable
fun SearchWindAndVisibilitySection(
    windSpeed:Int,
    visibility:Int,
) {

    val windTitle = if (Constants.UNITS == Constants.METRIC)
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
            horizontalArrangement = Arrangement.End
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

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = "$windSpeed $windTitle",
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.semidarkText,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    ),
                    modifier = Modifier
                        .padding(end = 8.dp)
                )


            }

        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
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

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = "${stringResource(R.string.visibility)} ${(visibility / 1000)} ${stringResource(
                        R.string.km
                    )}",
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.semidarkText,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    ),
                    modifier = Modifier
                        .padding(end = 8.dp)
                )


            }
        }


    }

}