package com.tab.news.di.intent.home

import com.tab.news.intent.GraphDestinations
import com.tab.news.intent.Navigator
import com.tab.news.presentation.home.HomeNavigation
import javax.inject.Inject

class HomeNavigationImpl @Inject constructor(
    private val navigator: Navigator
): HomeNavigation {

    override fun navigateToNextPage() {
        navigator.navigate(route = GraphDestinations.HomeRoutes.Random.route) {}
    }

}