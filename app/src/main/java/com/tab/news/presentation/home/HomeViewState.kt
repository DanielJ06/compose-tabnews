package com.tab.news.presentation.home

import com.tab.news.domain.model.Content

data class HomeViewState(
    val contents: List<Content> = emptyList()
)
