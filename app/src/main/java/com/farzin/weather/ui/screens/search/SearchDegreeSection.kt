package com.farzin.weather.ui.screens.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.farzin.weather.R
import com.farzin.weather.ui.theme.darkText
import com.farzin.weather.ui.theme.yellow
import com.farzin.weather.util.IconHelper

@Composable
fun SearchDegreeSection(
    temp:Int,
    desc:String,
    icon:String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.5f)
                .padding(start = 24.dp),
        ) {

            Text(
                text = "$temp${stringResource(R.string.degree_symbol)}",
                style = TextStyle(
                    fontSize = 70.sp,
                    color = MaterialTheme.colorScheme.darkText,
                    fontWeight = FontWeight.Bold,
                    )
            )

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = desc,
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                        color = MaterialTheme.colorScheme.yellow,
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = Modifier
                        .padding(top = 16.dp)
                )
            }


        }


        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.5f),
            contentAlignment = Alignment.Center
        ){
            Image(
                painter = rememberAsyncImagePainter(IconHelper.iconHelper(icon)),
                contentDescription = "",
                modifier = Modifier
                    .size(100.dp)
            )
        }



    }

}