package com.tab.news.intent

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tab.news.presentation.home.HomeScreen
import com.tab.news.presentation.home.RandomScreen

fun NavGraphBuilder.addHomeNavGraph() {
    navigation(
        route = RootDestinations.Home.route,
        startDestination = GraphDestinations.HomeRoutes.Main.route
    ) {
        addHomeScreen()
        addRandomScreen()
    }
}

fun NavGraphBuilder.addRandomScreen() {
    composable(
        route = GraphDestinations.HomeRoutes.Random.route
    ) {
        RandomScreen()
    }
}

fun NavGraphBuilder.addHomeScreen() {
    composable(
        route = GraphDestinations.HomeRoutes.Main.route
    ) {
        HomeScreen()
    }
}