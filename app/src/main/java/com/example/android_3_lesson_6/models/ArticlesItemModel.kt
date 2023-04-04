package com.example.android_3_lesson_6.models

import com.example.android_3_lesson_6.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class ArticlesItemModel(
    @SerializedName("publishedAt")
    val publishedAt: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("urlToImage")
    val urlToImage: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("source")
    val source: SourceModel,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    override val url: String,
    @SerializedName("content")
    val content: String,
) : IBaseDiffModel
