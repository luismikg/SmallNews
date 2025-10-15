package com.luis.smallnews.presentation.mainScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luis.smallnews.domain.repository.GetTopHeadRepository
import com.luis.smallnews.presentation.states.TopHeadState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getTopHeadRepository: GetTopHeadRepository
) : ViewModel() {

    private val _state: MutableStateFlow<TopHeadState> = MutableStateFlow(TopHeadState.Loading)
    val state: StateFlow<TopHeadState> = _state

    init {
        getTopHead()
    }

    private fun getTopHead(country: String = "us") {

        viewModelScope.launch {
            getTopHeadRepository
                .getTopHead(country = country).collect { result ->

                    result.onSuccess { listArticle ->
                        _state.value = TopHeadState.Success(listArticles = listArticle)
                    }.onFailure { failure ->
                        _state.value = TopHeadState.Error(failure.message ?: "Some error occurred!")
                    }
                }
        }
    }
}