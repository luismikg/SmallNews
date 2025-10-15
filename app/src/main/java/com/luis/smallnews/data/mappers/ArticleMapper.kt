package com.luis.smallnews.data.mappers

import com.luis.smallnews.data.entities.Article
import com.luis.smallnews.domain.models.ArticleModel

fun Article.map() : ArticleModel {
    return ArticleModel(
        author = this.author ?: "No author!",
        content = this.content ?: "No available",
        description = this.description ?: "No available",
        title = this.title,
        urlToImage = this.urlToImage ?: "",
        urlNews = this.urlNews
    )
}