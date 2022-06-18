package com.tab.news.intent.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tab.news.intent.GraphDestinations
import com.tab.news.intent.RootDestinations
import com.tab.news.presentation.bookmark.BookmarkScreen

fun NavGraphBuilder.addBookmarkNavGraph() {
    navigation(
        route = RootDestinations.Bookmarks.route,
        startDestination = GraphDestinations.BookmarkRoutes.Bookmarked.createRoute()
    ) {
        addBookmarkScreen()
    }
}
