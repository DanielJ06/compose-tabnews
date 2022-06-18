package com.tab.news.data.local.mappers

import com.tab.news.data.local.entities.ContentEntity
import com.tab.news.domain.model.Content

fun Content.toEntity(): ContentEntity {
    return ContentEntity(
        id,
        ownerId,
        slug,
        title,
        body,
        createdAt,
        updatedAt,
        publishedAt,
        username,
        childrenDeepCount
    )
}

fun ContentEntity.toModel(): Content {
    return Content(
        id,
        ownerId,
        slug,
        title,
        body,
        createdAt,
        updatedAt,
        publishedAt,
        username,
        childrenDeepCount
    )
}