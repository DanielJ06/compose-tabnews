package com.tab.news.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tab.news.data.local.data_access_objects.ContentDao
import com.tab.news.data.local.entities.ContentEntity

@Database(
    entities = [ContentEntity::class],
    version = 1
)
abstract class TabNewsDatabase : RoomDatabase() {
    abstract val contentDao: ContentDao
}