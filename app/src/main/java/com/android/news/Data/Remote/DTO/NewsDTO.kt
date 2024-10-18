package com.android.news.Data.Remote.DTO

import com.android.news.Domain.Model.NewsModel

data class NewsDTO(
    val result: List<Result>,
    val success: Boolean
)

fun NewsDTO.toNews(): List<NewsModel>{
    return result.map {
        NewsModel(
            description = it.description,
            image = it.image,
            key = it.image,
            name = it.name,
            source = it.source,
            url = it.url
        )
    }
}
