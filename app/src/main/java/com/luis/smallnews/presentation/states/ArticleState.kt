package com.luis.smallnews.presentation.states

import com.luis.smallnews.domain.models.ArticleModel

sealed class ArticleState {
    data class Article(val data:ArticleModel?):ArticleState()
}