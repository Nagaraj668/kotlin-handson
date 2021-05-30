package com.workouts.kotlinhandson.newsapi

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("items") val news: List<News>
)
