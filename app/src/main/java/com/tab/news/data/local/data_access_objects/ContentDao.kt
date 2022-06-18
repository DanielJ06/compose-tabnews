package com.tab.news.data.local.data_access_objects

import androidx.room.*
import com.tab.news.data.local.entities.ContentEntity

@Dao
interface ContentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewPostContent(
        postContent: ContentEntity
    )

    @Query("SELECT * FROM contententity WHERE id=:id")
    suspend fun getPostContentById(id: String): List<ContentEntity>


    @Query("SELECT * FROM contententity")
    suspend fun getAllPostsContent(): List<ContentEntity>

}