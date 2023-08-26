package com.farzin.weather.ui.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.farzin.weather.ui.theme.semidarkText

@Composable
fun SearchTitleSection(name:String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
            .padding(bottom = 16.dp)
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.Start
    ) {

        Text(
            text = name,
            style = TextStyle(
                fontSize = MaterialTheme.typography.displaySmall.fontSize,
                color = MaterialTheme.colorScheme.semidarkText,
                fontWeight = FontWeight.Normal,

            )
        )


    }

}