package com.tab.news.intent.navigation.home

import com.tab.news.domain.model.Content
import com.tab.news.intent.GraphDestinations
import com.tab.news.intent.Navigator
import com.tab.news.presentation.home.HomeNavigation
import javax.inject.Inject

class HomeNavigationImpl @Inject constructor(
    private val navigator: Navigator
) : HomeNavigation {

    override fun navigateToNextPage(postContent: Content) {
        navigator.navigate(
            route = GraphDestinations.HomeRoutes.ContentDetails.createRoute(
                postContent
            )
        ) {}
    }

}