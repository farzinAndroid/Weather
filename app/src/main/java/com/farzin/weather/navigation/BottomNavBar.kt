package com.farzin.weather.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.farzin.weather.R
import com.farzin.weather.ui.theme.bottomBarColor
import com.farzin.weather.ui.theme.selectedBottomBar
import com.farzin.weather.ui.theme.unselectedBottomBar

@Composable
fun BottomNavBar(
    navHostController: NavHostController,
    onClick: (NavBarItem) -> Unit,
) {


    val navBarList = listOf(

        NavBarItem(
            title = stringResource(R.string.home),
            deselectedIcon = painterResource(R.drawable.home_outline),
            selectedIcon = painterResource(R.drawable.home_fill),
            route = Screens.Home.route
        ),

        NavBarItem(
            title = stringResource(R.string.search),
            deselectedIcon = painterResource(R.drawable.search_outline),
            selectedIcon = painterResource(R.drawable.search_fill),
            route = Screens.Search.route
        ),

        NavBarItem(
            title = stringResource(R.string.setting),
            deselectedIcon = painterResource(R.drawable.setting_outline),
            selectedIcon = painterResource(R.drawable.setting_fill),
            route = Screens.Setting.route
        ),

        )


    val backstack = navHostController.currentBackStackEntryAsState()
    val showBottomBar = backstack.value?.destination?.route in navBarList.map { it.route }


    if (showBottomBar) {


        BottomAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            containerColor = MaterialTheme.colorScheme.bottomBarColor
        ) {

            navBarList.forEachIndexed { index, navBarItem ->

                val selected = navBarItem.route == backstack.value?.destination?.route

                NavigationBarItem(
                    selected = selected,
                    onClick = {
                        onClick(navBarItem)
                    },
                    icon = {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = CenterHorizontally
                        ) {


                            Icon(
                                painter = if (selected) navBarItem.selectedIcon else navBarItem.deselectedIcon,
                                contentDescription = "",
                                modifier = Modifier
                                    .size(26.dp),
                                tint = if (selected) MaterialTheme.colorScheme.selectedBottomBar else MaterialTheme.colorScheme.unselectedBottomBar
                            )

                            Text(
                                text = navBarItem.title,
                                style = TextStyle(
                                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                                    fontWeight = FontWeight.SemiBold,
                                    color =if (selected) MaterialTheme.colorScheme.selectedBottomBar else MaterialTheme.colorScheme.unselectedBottomBar
                                )
                            )

                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = MaterialTheme.colorScheme.bottomBarColor,
                        selectedIconColor = Color.Transparent,
                        selectedTextColor = Color.Transparent,
                        unselectedIconColor = Color.Transparent,
                        unselectedTextColor = Color.Transparent
                    )
                )

            }


        }


    }


}


fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }
    ) {
        onClick()
    }
}
