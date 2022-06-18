package com.tab.news.domain.repository

import com.tab.news.domain.model.Content
import kotlinx.coroutines.flow.Flow

interface ContentsRepository {
    suspend fun getAllContents(): Flow<List<Content>>
    suspend fun getAllBookmarkContent(): Flow<List<Content>>
    suspend fun bookmarkContent(content: Content)
    suspend fun verifyIfIsBookmarked(postContentId: String): Boolean
}