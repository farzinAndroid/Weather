package com.farzin.weather.ui.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import com.farzin.weather.ui.theme.semidarkText


@Composable
fun DetailTitleSection() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(vertical = 20.dp)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = stringResource(R.string.current_air_quality),
            style = TextStyle(
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
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

}