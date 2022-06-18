package com.tab.news.data.repository

import com.tab.news.data.local.TabNewsDatabase
import com.tab.news.data.local.mappers.toEntity
import com.tab.news.data.local.mappers.toModel
import com.tab.news.data.remote.mappers.toModel
import com.tab.news.data.remote.service.ContentsService
import com.tab.news.domain.model.Content
import com.tab.news.domain.repository.ContentsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ContentsRepositoryImpl @Inject constructor(
    private val api: ContentsService,
    db: TabNewsDatabase
) : ContentsRepository {

    private val contentsDao = db.contentDao

    override suspend fun verifyIfIsBookmarked(postContentId: String): Boolean {
        val contentsById = contentsDao.getPostContentById(postContentId)
        val filteredContents = contentsById.filter { it.id == postContentId }
        return filteredContents.isNotEmpty()
    }

    override suspend fun getAllBookmarkContent(): Flow<List<Content>> {
        return flow {
            val contents = contentsDao.getAllPostsContent()
            val mappedContents = contents.map { it.toModel() }
            emit(mappedContents)
        }
    }

    override suspend fun getAllContents(): Flow<List<Content>> {
        return flow {
            val contents = api.getContents()
            val mappedContents = contents.map { it.toModel() }
            emit(mappedContents)
        }
    }

    override suspend fun bookmarkContent(content: Content) {
        contentsDao.insertNewPostContent(content.toEntity())
    }

}