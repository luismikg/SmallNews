package com.luis.smallnews.domain.models

data class ArticleModel(
    val author: String,
    val content: String,
    val description: String,
    val title: String,
    val urlToImage: String,
    val urlNews: String,
)