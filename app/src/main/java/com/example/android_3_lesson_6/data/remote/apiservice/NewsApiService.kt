package com.example.android_3_lesson_6.data.remote.apiservice

import com.example.android_3_lesson_6.models.ArticlesItemModel
import com.example.android_3_lesson_6.models.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("top-headlines")
    suspend fun fetchNews(
        @Query("page") page: String,
        @Query("q") q: Int,
        @Query("apiKey") key: String = "dc14028d8c7d443fb41619fd0b57f49d"
    ): NewsResponse<ArticlesItemModel>
}