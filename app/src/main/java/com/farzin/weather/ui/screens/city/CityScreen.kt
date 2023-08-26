package com.farzin.weather.ui.screens.city

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.farzin.weather.R
import com.farzin.weather.ui.theme.darkText
import com.farzin.weather.ui.theme.onBoarding
import com.farzin.weather.ui.theme.placeholdercolor
import com.farzin.weather.ui.theme.semidarkText
import com.farzin.weather.ui.theme.yellow
import com.farzin.weather.viewmodel.CityViewModel
import com.farzin.weather.viewmodel.DataStoreViewModel

@Composable
fun CityScreen(
    cityViewModel: CityViewModel = hiltViewModel(),
    dataStoreViewModel: DataStoreViewModel = hiltViewModel(),
    navController: NavController
) {

    City(cityViewModel, dataStoreViewModel,navController)

}


@Composable
fun City(cityViewModel: CityViewModel, dataStoreViewModel: DataStoreViewModel,navController: NavController) {


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onBoarding)
            .padding(bottom = 60.dp)
    ) {

        item { CityScreenHeader() }
        item { CityScreenTextFieldSection(cityViewModel, dataStoreViewModel) }
        item { SavedCity() }
        item { SavedCitiesSection(navController=navController) }

    }


}


