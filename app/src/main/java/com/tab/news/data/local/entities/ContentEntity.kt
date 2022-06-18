package com.tab.news.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tab.news.domain.model.Content

@Entity
data class ContentEntity(
    @PrimaryKey val id: String,
    val ownerId: String,
    val slug: String,
    val title: String,
    val body: String,
    val createdAt: String,
    val updatedAt: String,
    val publishedAt: String,
    val username: String,
    val childrenDeepCount: Int
)