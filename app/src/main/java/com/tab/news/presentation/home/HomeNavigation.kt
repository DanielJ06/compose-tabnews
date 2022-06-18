package com.tab.news.presentation.home

import com.tab.news.domain.model.Content

interface HomeNavigation {
    fun navigateToNextPage(postContent: Content)
    fun navigateToBookmarked()
}