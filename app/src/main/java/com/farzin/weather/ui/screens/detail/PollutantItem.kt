package com.farzin.weather.ui.screens.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.farzin.weather.R
import com.farzin.weather.ui.theme.darkText
import com.farzin.weather.ui.theme.semidarkText


@Composable
fun PollutantItem(
    pollutantName: String,
    quality: String,
    pollutantValue: String,
    description: String,
    color: Color,
    modifier: Modifier
) {



    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 8.dp)
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center

    ) {

        Text(
            text = pollutantName,
            style = TextStyle(
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                color = MaterialTheme.colorScheme.semidarkText,
                fontWeight = FontWeight.Light
            )
        )

        Divider(
            modifier = Modifier
                .width(50.dp)
                .padding(vertical = 8.dp),
            thickness = 2.dp,
            color = color
        )

        Text(
            text = quality,
            style = TextStyle(
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                color = MaterialTheme.colorScheme.darkText,
                fontWeight = FontWeight.SemiBold
            )
        )

        Text(
            text = "$pollutantValue ${stringResource(R.string.microgram)}",
            style = TextStyle(
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                color = MaterialTheme.colorScheme.darkText,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .padding(vertical = 16.dp)
        )


        Text(
            text = description,
            style = TextStyle(
                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                color = MaterialTheme.colorScheme.semidarkText,
                fontWeight = FontWeight.Bold,
                lineHeight = 18.sp
            ),
            maxLines = 6,
            overflow = TextOverflow.Ellipsis
        )


    }


}