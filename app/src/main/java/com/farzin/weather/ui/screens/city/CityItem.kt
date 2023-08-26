package com.farzin.weather.ui.screens.city

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.farzin.weather.R
import com.farzin.weather.data.model.city.CityName
import com.farzin.weather.ui.theme.darkText
import com.farzin.weather.ui.theme.semidarkText
import com.farzin.weather.util.Constants
import com.farzin.weather.viewmodel.CityViewModel
import com.farzin.weather.viewmodel.DataStoreViewModel


@Composable
fun CityItem(
    item: CityName,
    navController: NavController,
    dataStoreViewModel: DataStoreViewModel = hiltViewModel(),
    cityViewModel: CityViewModel = hiltViewModel(),
) {


    Column(
        modifier = Modifier
            .padding(horizontal = 24.dp)
    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(vertical = 16.dp)
                .clickable {
                    dataStoreViewModel.saveCityName(item.name)
                    navController.popBackStack()
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


            Row(verticalAlignment = Alignment.CenterVertically) {

                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "",
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            cityViewModel.deleteCity(item)
                        },
                    tint = MaterialTheme.colorScheme.darkText
                )

                Text(
                    text = item.name,
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.semidarkText,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                        fontWeight = FontWeight.SemiBold
                    ),
                    modifier = Modifier
                        .padding(start = 8.dp)
                )


            }





            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "",
                modifier = Modifier
                    .size(20.dp),
                tint = MaterialTheme.colorScheme.darkText
            )

        }


        Divider(
            thickness = 1.dp,
            color = Color.Gray
        )

    }


}