package com.farzin.weather.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.farzin.weather.R
import com.farzin.weather.data.model.home.ForeCastList
import com.farzin.weather.ui.theme.darkText
import com.farzin.weather.ui.theme.semidarkText
import com.farzin.weather.util.DateHelper
import com.farzin.weather.util.DigitHelper
import com.farzin.weather.viewmodel.HomeViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeTodayForecastSection(homeViewModel: HomeViewModel = hiltViewModel()) {




    var foreCastList by remember {
        mutableStateOf<List<ForeCastList>>(emptyList())
    }


    LaunchedEffect(true){
        homeViewModel.filteredForecastForToday.collectLatest {filteredForecastForToday->
            foreCastList = filteredForecastForToday.data ?: emptyList()
        }
    }



    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp
            ),
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {

            Column(
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = stringResource(R.string.today),
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.darkText,
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                        fontWeight = FontWeight.SemiBold
                    )
                )

                Text(
                    text = DateHelper.getCurrentDate(),
                    style = TextStyle(
                        color = MaterialTheme.colorScheme.semidarkText,
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    )
                )


            }

        }


        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        ){

            items(foreCastList){item->
                ForeCastCard(item = item)
            }

        }


    }

}