package com.android.news.Data.Remote

import com.android.news.Data.Remote.DTO.NewsDTO
import com.android.news.Util.Constants.API_KEY
import com.android.news.Util.Constants.CONTENT_TYPE
import retrofit2.http.GET
import retrofit2.http.Header

interface NewsAPI {
    @GET("/news/getNews?country=tr&tag=general")
    suspend fun getNews(
        @Header("content-type") type: String = CONTENT_TYPE,
        @Header("authorization") auth: String = API_KEY
    ): NewsDTO
}