package com.tab.news.intent.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tab.news.intent.GraphDestinations
import com.tab.news.intent.RootDestinations
import com.tab.news.presentation.bookmark.BookmarkScreen
import com.tab.news.presentation.contentDetails.ContentDetailsScreen
import com.tab.news.presentation.home.HomeScreen

fun NavGraphBuilder.addHomeNavGraph() {
    navigation(
        route = RootDestinations.Home.route,
        startDestination = GraphDestinations.HomeRoutes.Main.createRoute()
    ) {
        addHomeScreen()
        addContentDetailsScreen()
    }
}

fun NavGraphBuilder.addContentDetailsScreen() {
    composable(
        route = GraphDestinations.HomeRoutes.ContentDetails.createRoute(),
        arguments = GraphDestinations.HomeRoutes.ContentDetails.arguments
    ) {
        ContentDetailsScreen()
    }
}

fun NavGraphBuilder.addHomeScreen() {
    composable(
        route = GraphDestinations.HomeRoutes.Main.createRoute()
    ) {
        HomeScreen()
    }
}

fun NavGraphBuilder.addBookmarkScreen() {
    composable(
        route = GraphDestinations.BookmarkRoutes.Bookmarked.createRoute()
    ) {
        BookmarkScreen()
    }
}
