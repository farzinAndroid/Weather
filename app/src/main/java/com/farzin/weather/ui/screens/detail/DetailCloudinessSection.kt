package com.farzin.weather.ui.screens.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.farzin.weather.R
import com.farzin.weather.ui.theme.darkText
import com.farzin.weather.ui.theme.semidarkText
import com.farzin.weather.ui.theme.yellow
import com.farzin.weather.util.IconHelper

@Composable
fun DetailCloudinessSection(cloud: Int) {

    //03n

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(top = 40.dp)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = stringResource(R.string.current_clouds),
                style = TextStyle(
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    color = MaterialTheme.colorScheme.semidarkText,
                    fontWeight = FontWeight.SemiBold
                )
            )

            Image(
                painter = rememberAsyncImagePainter(IconHelper.iconHelper("03n")),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(36.dp)
            )
        }

        Divider(
            thickness = 1.dp,
            color = Color.LightGray,
            modifier = Modifier
                .padding(top = 8.dp)
        )


    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {



        Box(
            modifier = Modifier
                .size(120.dp)
                .padding(end = 8.dp),
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
                progress = cloud.toFloat() / (100).toFloat(),
                modifier = Modifier
                    .size(100.dp),
                color = MaterialTheme.colorScheme.yellow,
                strokeWidth = 3.dp
            )


            Text(
                text =  "$cloud %",
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