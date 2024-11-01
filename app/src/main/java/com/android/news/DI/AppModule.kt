package com.android.news.DI

import com.android.news.Data.Remote.NewsAPI
import com.android.news.Data.Repository.NewsRepositoryImpl
import com.android.news.Domain.Repository.NewsRepository
import com.android.news.Util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): NewsAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(newsAPI: NewsAPI): NewsRepository{
        return NewsRepositoryImpl(newsAPI)
    }
}