package com.luis.smallnews.data.entities

import com.google.gson.annotations.SerializedName

data class TopHeadResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)