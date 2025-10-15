package com.luis.smallnews.data.repository

import com.luis.smallnews.data.ApiService
import com.luis.smallnews.data.mappers.map
import com.luis.smallnews.domain.models.ArticleModel
import com.luis.smallnews.domain.repository.GetTopHeadRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetTopHeadRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : GetTopHeadRepository {

    override fun getTopHead(country: String): Flow<Result<List<ArticleModel>>> {
        return flow {
            val response = apiService.getTopHeadLines(country = country)

            if (response.isSuccessful) {
                response.body()?.let { body ->
                    val articleList = body.articles.map { article ->
                        article.map()
                    }
                    emit(Result.success(articleList))
                } ?: run {
                    emit(Result.failure(Exception("Error to try to get the News, please contact to provide service")))
                }

            } else {
                emit(Result.failure(Exception("Error to try to get the News, please try again in some minutes")))
            }
        }
    }
}