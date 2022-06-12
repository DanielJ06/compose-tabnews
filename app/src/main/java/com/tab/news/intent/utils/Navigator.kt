package com.tab.news.intent

import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.navOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class Navigator(private val applicationScope: CoroutineScope) {

    private val _commands: Channel<NavigationCommand> = Channel(Channel.BUFFERED)
    val commands = _commands.receiveAsFlow()

    private fun navigate(route: String, navOptions: NavOptions? = null) {
        applicationScope.launch {
            _commands.send(
                NavigationCommand.Navigate(
                    destination = route,
                    navOptions = navOptions
                )
            )
        }
    }

    fun navigate(route: String, builder: NavOptionsBuilder.() -> Unit) {
        navigate(route, navOptions(builder))
    }

}

sealed class NavigationCommand {
    data class Navigate(
        val destination: String,
        val navOptions: NavOptions? = null,
    ) : NavigationCommand()
}

fun String.encode(): String = URLEncoder.encode(this, StandardCharsets.UTF_8.toString())
fun String.decode(): String = URLDecoder.decode(this, StandardCharsets.UTF_8.toString())