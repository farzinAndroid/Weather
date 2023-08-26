package com.farzin.weather.ui.screens.city

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
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
import com.farzin.weather.R
import com.farzin.weather.ui.theme.semidarkText


@Composable
fun SavedCity() {

    Column(
        modifier = Modifier
            .padding(horizontal = 24.dp)
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            Icon(
                painter = painterResource(R.drawable.suggest),
                contentDescription = "",
                modifier = Modifier
                    .size(24.dp),
                tint = MaterialTheme.colorScheme.semidarkText
            )


            Text(
                text = stringResource(R.string.save_city),
                style = TextStyle(
                    color = MaterialTheme.colorScheme.semidarkText,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier
                    .padding(start = 8.dp)
            )

        }


        Divider(
            thickness = 1.dp,
            color = Color.Gray
        )

    }



}