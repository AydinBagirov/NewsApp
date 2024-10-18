package com.android.news.Data.Repository

import com.android.news.Data.Remote.DTO.NewsDTO
import com.android.news.Data.Remote.NewsAPI
import com.android.news.Domain.Repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api : NewsAPI
): NewsRepository {
    override suspend fun getNews(): NewsDTO {
        return api.getNews()
    }
}
