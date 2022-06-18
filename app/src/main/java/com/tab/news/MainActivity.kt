package com.tab.news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.tab.news.intent.NavigationCommand
import com.tab.news.intent.RootDestinations
import com.tab.news.intent.graphs.addBookmarkNavGraph
import com.tab.news.intent.graphs.addHomeNavGraph
import com.tab.news.ui.theme.TabnewsTheme
import com.tab.news.uikit.components.bottomNavigation.TabNewsBottomNavigation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val tabNewsViewModel: TabNewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            TabnewsTheme {
                ObserveAndNavigate(
                    navController = navController,
                    tabNewsViewModel = tabNewsViewModel
                )
                Box(modifier = Modifier.fillMaxSize()) {
                    NavHost(
                        navController = navController,
                        startDestination = RootDestinations.Home.route
                    ) {
                        addHomeNavGraph()
                        addBookmarkNavGraph()
                    }
                    TabNewsBottomNavigation(onClick = { route ->
                        tabNewsViewModel.navigator.navigate(route) {
                            popUpTo(route)
                            launchSingleTop = true
                            restoreState = true
                        }
                    }, navController = navController)
                }
            }
        }
    }
}

@Composable
fun ObserveAndNavigate(
    navController: NavHostController,
    tabNewsViewModel: TabNewsViewModel
) {
    LaunchedEffect(Unit) {
        tabNewsViewModel.navigator.commands.collect { cmd ->
            when (cmd) {
                is NavigationCommand.Navigate -> {
                    navController.navigate(
                        route = cmd.destination,
                        navOptions = cmd.navOptions
                    )
                }
            }
        }
    }
}