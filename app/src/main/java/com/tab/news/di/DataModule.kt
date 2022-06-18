package com.tab.news.di

import com.tab.news.data.repository.ContentsRepositoryImpl
import com.tab.news.domain.repository.ContentsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindContentsRepository(
        contentsRepositoryImpl: ContentsRepositoryImpl
    ): ContentsRepository

}