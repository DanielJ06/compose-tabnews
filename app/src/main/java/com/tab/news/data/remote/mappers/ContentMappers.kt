package com.tab.news.data.remote.mappers

import com.tab.news.data.remote.model.ContentResponse
import com.tab.news.domain.model.Content

fun ContentResponse.toModel() = Content(
    id = id,
    ownerId = ownerId,
    slug = slug,
    title = title,
    body = body,
    createdAt = createdAt,
    updatedAt = updatedAt,
    publishedAt = publishedAt,
    username = username,
    childrenDeepCount = childrenDeepCount
)