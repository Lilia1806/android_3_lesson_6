package com.example.android_3_lesson_6.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.android_3_lesson_6.data.remote.apiservice.NewsApiService
import com.example.android_3_lesson_6.data.repository.pagingsources.NewsPagingSource
import com.example.android_3_lesson_6.models.ArticlesItemModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val newsApiService: NewsApiService
) {

    fun fetchNews(): Flow<PagingData<ArticlesItemModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                NewsPagingSource(newsApiService)
            }).flow
    }
}