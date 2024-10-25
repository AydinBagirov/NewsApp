package com.android.news.Domain.Usecase

import android.net.http.HttpException
import com.android.news.Data.Remote.DTO.toNews
import com.android.news.Domain.Model.NewsModel
import com.android.news.Domain.Repository.NewsRepository
import com.android.news.Util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class NewsUseCase @Inject constructor(private val newsRepository: NewsRepository) {
    fun getNews(): Flow<Resource<List<NewsModel>>> = flow {
        try {
            emit(Resource.Loading())
            val news = newsRepository.getNews()
            if (news.success)
                emit(Resource.Success(news.toNews()))
            else
                emit(Resource.Error("NO DATA"))
        } catch (e: HttpException) {
            emit(Resource.Error("${e.localizedMessage}"))
        } catch (e: IOException) {
            emit(Resource.Error("${e.localizedMessage}"))
        }
    }
}