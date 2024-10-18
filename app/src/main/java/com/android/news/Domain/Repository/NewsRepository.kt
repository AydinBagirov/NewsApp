package com.android.news.Domain.Repository

import com.android.news.Data.Remote.DTO.NewsDTO

interface NewsRepository {
    suspend fun getNews(): NewsDTO
}