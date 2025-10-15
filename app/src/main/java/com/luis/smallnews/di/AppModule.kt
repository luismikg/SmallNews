package com.luis.smallnews.di

import com.luis.smallnews.data.ApiService
import com.luis.smallnews.data.Constants
import com.luis.smallnews.data.repository.GetTopHeadRepositoryImpl
import com.luis.smallnews.domain.repository.GetTopHeadRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(Constants.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun providesGetTopRepository(apiService: ApiService): GetTopHeadRepository {
        return GetTopHeadRepositoryImpl(apiService)
    }
}