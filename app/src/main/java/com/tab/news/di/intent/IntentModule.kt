package com.tab.news.di.intent

import com.tab.news.intent.navigation.home.HomeNavigationImpl
import com.tab.news.presentation.home.HomeNavigation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class IntentModule {

    @Binds
    abstract fun bindHomeNavigation(
        homeNavigationImpl: HomeNavigationImpl
    ): HomeNavigation

}