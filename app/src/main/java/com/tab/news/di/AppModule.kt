package com.tab.news.di

import android.app.Application
import androidx.room.Room
import com.tab.news.data.local.TabNewsDatabase
import com.tab.news.intent.Navigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesNavigator(): Navigator {
        return Navigator(CoroutineScope(SupervisorJob() + Dispatchers.Main))
    }

    @Provides
    @Singleton
    fun provideTabNewsDatabase(app: Application): TabNewsDatabase {
        return Room.databaseBuilder(
            app,
            TabNewsDatabase::class.java,
            "tabnewsdb.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.tabnews.com.br/api/v1/")
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

}