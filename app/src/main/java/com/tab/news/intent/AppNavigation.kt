package com.tab.news.intent

sealed class RootDestinations(val route: String) {
    object Home : RootDestinations("home")
}

sealed class GraphDestinations(
    val root: RootDestinations,
    val route: String,
) {

    object HomeRoutes {

        object Main : GraphDestinations(root = RootDestinations.Home, route = "main")
        object Random : GraphDestinations(root = RootDestinations.Home, route = "random")

    }

}

