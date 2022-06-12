package com.tab.news.data.remote.di

import com.tab.news.data.remote.service.ContentsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun provideContentsService(retrofit: Retrofit): ContentsService {
        return retrofit.create(ContentsService::class.java)
    }

}