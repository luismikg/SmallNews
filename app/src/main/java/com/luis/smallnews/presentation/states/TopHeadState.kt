package com.luis.smallnews.presentation.states

import com.luis.smallnews.domain.models.ArticleModel

sealed class TopHeadState {
    data object Loading : TopHeadState()
    data class Success(val listArticles: List<ArticleModel>) : TopHeadState()
    data class Error(val error: String) : TopHeadState()
}