package com.tab.news.intent

import androidx.navigation.NamedNavArgument
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.tab.news.domain.model.Content
import com.tab.news.intent.utils.TabNewsNavType

sealed class RootDestinations(val route: String) {
    object Home : RootDestinations("main")
}

sealed class GraphDestinations(
    val root: RootDestinations,
    val route: String,
) {
    private val gson = Gson()
    fun Any?.toGson(): String = gson.toJson(this).encode()

    open val arguments: List<NamedNavArgument> = emptyList()
    fun createRoute() = "${root.route}/$route"

    object HomeRoutes {

        object Main : GraphDestinations(root = RootDestinations.Home, route = "home")

        object ContentDetails : GraphDestinations(
            root = RootDestinations.Home,
            route = "content/{postContent}"
        ) {
            fun createRoute(content: Content): String {
                return "${root.route}/content/${content.toGson()}"
            }

            override val arguments = listOf(
                navArgument(name = "postContent") {
                    type = TabNewsNavType(Content::class.java)
                }
            )
        }

    }

}