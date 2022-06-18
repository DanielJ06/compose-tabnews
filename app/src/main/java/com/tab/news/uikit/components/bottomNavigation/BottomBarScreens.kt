package com.tab.news.uikit.components.bottomNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.tab.news.intent.GraphDestinations
import com.tab.news.intent.RootDestinations

sealed class BottomBarScreens(
    val route: String,
    val icon: ImageVector
) {

    object Home : BottomBarScreens(
        route = GraphDestinations.HomeRoutes.Main.createRoute(),
        icon = Icons.Default.Home
    )

    object Bookmark : BottomBarScreens(
        route = GraphDestinations.BookmarkRoutes.Bookmarked.createRoute(),
        icon = Icons.Default.Favorite
    )

}