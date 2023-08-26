package com.farzin.weather.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.farzin.weather.R
import com.farzin.weather.data.model.home.ForeCastList
import com.farzin.weather.ui.theme.semidarkText
import com.farzin.weather.ui.theme.yellow
import com.farzin.weather.util.DateHelper
import com.farzin.weather.util.DigitHelper
import com.farzin.weather.util.IconHelper

@Composable
fun FutureForeCastItem(
    item:ForeCastList,
    isInSearchScreen:Boolean = false
) {


    Column {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(horizontal = 16.dp)
                .padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            if (isInSearchScreen){

                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Text(
                        text = DateHelper.extractDate(item.dt_txt),
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.semidarkText,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = MaterialTheme.typography.titleMedium.fontSize
                        )
                    )

                    Text(
                        text = DateHelper.extractTime(item.dt_txt),
                        style = TextStyle(
                            color = MaterialTheme.colorScheme.yellow,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = MaterialTheme.typography.titleSmall.fontSize
                        )
                    )

                }

            }else{
                Text(
                    text = DateHelper.extractDate(item.dt_txt),
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.semidarkText,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = MaterialTheme.typography.titleMedium.fontSize
                    )
                )
            }



            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = rememberAsyncImagePainter(IconHelper.iconHelper(item.weather[0].icon)),
                    contentDescription = "",
                    modifier = Modifier
                        .size(60.dp)
                )

                Text(
                    text = item.weather[0].description,
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.semidarkText,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    ),
                    maxLines = 2,
                    modifier = Modifier
                        .width(100.dp)
                )
            }



            Text(
                text = "${item.main.temp.toInt()}${stringResource(R.string.degree_symbol)}",
                style = TextStyle(
                    color = MaterialTheme.colorScheme.semidarkText,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize
                )
            )

        }

        Divider(
            thickness = 1.dp,
            color = Color.Gray,
            modifier = Modifier
                .padding(horizontal = 16.dp)

        )

    }


}