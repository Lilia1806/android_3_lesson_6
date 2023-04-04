package com.example.android_3_lesson_6.models

import com.google.gson.annotations.SerializedName

data class NewsResponse<T>(

    @SerializedName("totalResults")
    val totalResults: Int,

    @SerializedName("articles")
    val articles: List<T>,

    @SerializedName("status")
    val status: String
)