package com.tab.news.data.remote.service

import com.tab.news.data.remote.model.ContentResponse
import retrofit2.http.GET

interface ContentsService {

    @GET("contents")
    suspend fun getContents(): List<ContentResponse>

}