package com.luis.smallnews.data.entities

import com.google.gson.annotations.SerializedName

data class Article(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    @SerializedName("url")
    val urlNews: String,
    val urlToImage: String
)