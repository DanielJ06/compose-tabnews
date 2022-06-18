package com.tab.news.presentation.contentDetails

import com.tab.news.domain.model.Content

data class ContentDetailsViewState(
    val contentDetail: Content? = null,
    val isBookmarked: Boolean = false
)