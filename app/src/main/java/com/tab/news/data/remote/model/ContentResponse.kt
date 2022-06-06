package com.tab.news.data.remote.model

import com.google.gson.annotations.SerializedName

data class ContentResponse(
    @SerializedName("id")
    val id: String,

    @SerializedName("owner_id")
    val ownerId: String,

    @SerializedName("slug")
    val slug: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("body")
    val body: String,

    @SerializedName("created_at")
    val createdAt: String,

    @SerializedName("updated_at")
    val updatedAt: String,

    @SerializedName("published_at")
    val publishedAt: String,

    @SerializedName("username")
    val username: String,
)
