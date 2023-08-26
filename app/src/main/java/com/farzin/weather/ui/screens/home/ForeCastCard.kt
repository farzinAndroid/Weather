package com.farzin.weather.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.farzin.weather.R
import com.farzin.weather.data.model.home.ForeCastList
import com.farzin.weather.ui.theme.foreCastCard
import com.farzin.weather.ui.theme.onBoarding
import com.farzin.weather.ui.theme.semidarkText
import com.farzin.weather.util.DateHelper
import com.farzin.weather.util.DigitHelper
import com.farzin.weather.util.IconHelper

@Composable
fun ForeCastCard(
    item:ForeCastList
) {


    Card(
        modifier = Modifier
            .wrapContentHeight()
            .wrapContentWidth()
            .padding(horizontal = 8.dp),
        shape = Shapes().extraLarge,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.foreCastCard)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = rememberAsyncImagePainter(IconHelper.iconHelper(item.weather[0].icon)),
                contentDescription = "",
                modifier = Modifier
                    .size(60.dp)
            )


            Text(
                text = "${(item.main.temp).toInt()}${stringResource(R.string.degree_symbol)}",
                style = TextStyle(
                    color = MaterialTheme.colorScheme.semidarkText,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.SemiBold
                )
            )

            Text(
                text = DateHelper.extractTime(item.dt_txt),
                style = TextStyle(
                    color = MaterialTheme.colorScheme.semidarkText,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier
                    .padding(
                        top = 8.dp,
                        bottom = 8.dp
                    )
            )


        }

    }


}