package com.luis.smallnews.domain.repository

import com.luis.smallnews.domain.models.ArticleModel
import kotlinx.coroutines.flow.Flow

interface GetTopHeadRepository {

    fun getTopHead(country: String): Flow<Result<List<ArticleModel>>>
}