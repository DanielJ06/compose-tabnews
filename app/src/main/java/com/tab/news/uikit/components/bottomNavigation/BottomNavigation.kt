package com.tab.news.uikit.components.bottomNavigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun TabNewsBottomNavigation(
    onClick: (String) -> Unit,
    navController: NavController
) {

    val screens = listOf(
        BottomBarScreens.Home,
        BottomBarScreens.Bookmark
    )

    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        screens.forEach { screen ->
            val isSelected = currentRoute == screen.route

            BottomNavigationItem(
                icon = { Icon(imageVector = screen.icon, contentDescription = null) },
                selected = isSelected,
                onClick = {
                    if (isSelected.not()) onClick(screen.route)
                }
            )
        }
    }

}