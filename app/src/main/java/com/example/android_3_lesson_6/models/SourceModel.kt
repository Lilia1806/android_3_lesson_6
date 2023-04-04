package com.example.android_3_lesson_6.models

import com.google.gson.annotations.SerializedName

data class SourceModel(

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String
)