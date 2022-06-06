package com.tab.news.data.remote.repository

import com.tab.news.data.mappers.toModel
import com.tab.news.data.remote.service.ContentsService
import com.tab.news.domain.model.Content
import com.tab.news.domain.repository.ContentsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ContentsRepositoryImpl @Inject constructor(
    private val api: ContentsService
) : ContentsRepository {

    override fun getContents(): Flow<List<Content>> {
        return flow {
            val contents = api.getContents()
            val mappedContents = contents.map {
                it.toModel()
            }
            emit(mappedContents)
        }
    }

}