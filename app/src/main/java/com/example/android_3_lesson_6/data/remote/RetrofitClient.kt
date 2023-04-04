package com.example.android_3_lesson_6.data.remote

import com.example.android_3_lesson_6.data.remote.apiservice.NewsApiService
import com.example.android_3_lesson_6.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS).build()

    val retrofitClient = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun provideNewsApiService(): NewsApiService {
        return retrofitClient.create(NewsApiService::class.java)
    }
}