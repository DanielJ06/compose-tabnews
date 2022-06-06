package com.tab.news.domain.repository

import com.tab.news.domain.model.Content
import kotlinx.coroutines.flow.Flow

interface ContentsRepository {
    fun getContents(): Flow<List<Content>>
}