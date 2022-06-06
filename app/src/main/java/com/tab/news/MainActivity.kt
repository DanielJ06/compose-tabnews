package com.tab.news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.tab.news.intent.*
import com.tab.news.ui.theme.TabnewsTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val tabNewsViewModel: TabNewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            TabnewsTheme {
                Scaffold {
                    ObserveAndNavigate(
                        navController = navController,
                        tabNewsViewModel = tabNewsViewModel
                    )
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
                    navController.navigate(cmd.destination)
                }
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = RootDestinations.Home.route
    ) {
        addHomeNavGraph()
    }
}