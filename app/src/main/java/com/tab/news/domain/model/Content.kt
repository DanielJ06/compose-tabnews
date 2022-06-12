package com.tab.news.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Content(
    val id: String,
    val ownerId: String,
    val slug: String,
    val title: String,
    val body: String,
    val createdAt: String,
    val updatedAt: String,
    val publishedAt: String,
    val username: String,
    val childrenDeepCount: Int
) : Parcelable
