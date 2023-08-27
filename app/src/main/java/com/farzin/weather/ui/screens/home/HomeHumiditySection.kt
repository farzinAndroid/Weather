package com.farzin.weather.ui.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.farzin.weather.R
import com.farzin.weather.ui.theme.darkText
import com.farzin.weather.ui.theme.semidarkText
import com.farzin.weather.ui.theme.yellow


@Composable
fun HomeHumiditySection(
    humidity:Int
) {


    Row(
        modifier = Modifier
            .padding(start = 100.dp)
            .fillMaxWidth()
            .height(150.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        
        Text(
            text = stringResource(R.string.humidity),
            style = TextStyle(
                color = MaterialTheme.colorScheme.semidarkText,
                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            )
        )

        Box(
            modifier = Modifier
                .size(120.dp)
                .padding(start = 8.dp),
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
                progress = humidity.toFloat() / (100).toFloat(),
                modifier = Modifier
                    .size(100.dp),
                color = MaterialTheme.colorScheme.yellow,
                strokeWidth = 3.dp
            )


            Text(
                text =  "$humidity %",
                style = TextStyle(
                    color = MaterialTheme.colorScheme.darkText,
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold
                )
            )

        }

        
    }

}