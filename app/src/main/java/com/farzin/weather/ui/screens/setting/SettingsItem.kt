package com.farzin.weather.ui.screens.setting

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.farzin.weather.ui.theme.darkText
import com.farzin.weather.ui.theme.yellow
import com.farzin.weather.util.Constants

@Composable
fun SettingsItem(
    title: String,
    subTitle: String,
    isHaveArrow: Boolean = false,
    onClick: () -> Unit,
) {

    val horizontalArrangment = if (isHaveArrow){
        Arrangement.SpaceBetween
    }else{
        Arrangement.Start
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = horizontalArrangment
    ) {


        Column(
            modifier = Modifier
                .padding(vertical = 16.dp)
        ) {

            Text(
                text = title,
                style = TextStyle(
                    color = MaterialTheme.colorScheme.darkText,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = MaterialTheme.typography.titleMedium.fontSize
                )
            )

            Text(
                text = subTitle,
                style = TextStyle(
                    color = MaterialTheme.colorScheme.yellow,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                )
            )

        }


        if (isHaveArrow) {

            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "",
                modifier = Modifier
                    .size(20.dp),
                tint = MaterialTheme.colorScheme.darkText
            )

        }

    }


    Divider(
        thickness = 1.dp,
        color = Color.Gray
    )


}