package com.example.android_3_lesson_6.data.repository.pagingsources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.android_3_lesson_6.data.remote.apiservice.NewsApiService
import com.example.android_3_lesson_6.models.ArticlesItemModel

private const val NEWS_STARTING_PAGE_INDEX = 1

class NewsPagingSource(
    private val service: NewsApiService
) : PagingSource<Int, ArticlesItemModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticlesItemModel> {

        return try {
            val nextPage = params.key ?: NEWS_STARTING_PAGE_INDEX
            val response = service.fetchNews(q = nextPage, page = "us")
            val nextPages = nextPage + 1

            LoadResult.Page(
                data = response.articles,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = nextPages
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ArticlesItemModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}