package com.farzin.weather.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.farzin.weather.R
import com.farzin.weather.ui.theme.yellow

@Composable
fun ErrorSection(height: Dp) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(height),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

       Text(
           text = stringResource(R.string.error_msg),
           style = TextStyle(
               fontSize = MaterialTheme.typography.bodyMedium.fontSize,
               fontWeight = FontWeight.Bold,
               color = MaterialTheme.colorScheme.yellow,
               textAlign = TextAlign.Center
           ),
           modifier = Modifier
               .fillMaxWidth()
               .padding(horizontal = 16.dp)
       )

    }

}