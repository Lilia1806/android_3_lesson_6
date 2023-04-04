package com.example.android_3_lesson_6.di

import com.example.android_3_lesson_6.data.remote.RetrofitClient
import com.example.android_3_lesson_6.data.remote.apiservice.NewsApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Singleton
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideNewsApiService(): NewsApiService {
        return retrofitClient.provideNewsApiService()
    }
}