package com.luis.smallnews.presentation.detailScreen

import androidx.lifecycle.ViewModel
import com.luis.smallnews.domain.models.ArticleModel
import com.luis.smallnews.presentation.states.ArticleState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DetailViewModel : ViewModel() {

    private val _state: MutableStateFlow<ArticleState> =
        MutableStateFlow(ArticleState.Article(null))

    val state: StateFlow<ArticleState> = _state

    fun catchArticle(articleModel: ArticleModel) {
        _state.value = ArticleState.Article(articleModel)
    }
}