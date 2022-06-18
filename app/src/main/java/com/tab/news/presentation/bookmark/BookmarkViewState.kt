package com.tab.news.presentation.bookmark

import com.tab.news.domain.model.Content

data class BookmarkViewState(
    val bookmarkedPosts: List<Content> = emptyList()
)
