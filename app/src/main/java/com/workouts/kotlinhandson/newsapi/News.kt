package com.workouts.kotlinhandson.newsapi

import com.google.gson.annotations.SerializedName

data class News(
    val login: String,
    @SerializedName("avatar_url") val image: String
)