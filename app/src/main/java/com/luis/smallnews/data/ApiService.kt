package com.luis.smallnews.data

import com.luis.smallnews.data.entities.TopHeadResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//GET https://newsapi.org/v2/top-headlines?country=us&apiKey=60f6816fc58c49269a94bb8db7a80727
interface ApiService {

    @GET(Constants.TOP_HEADLINES_SERVICE)
    suspend fun getTopHeadLines(
        @Query("country") country: String,
        @Query("pageSize") pageSize:Int = 100,
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): Response<TopHeadResponse>
}