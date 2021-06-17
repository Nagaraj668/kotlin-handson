package com.workouts.kotlinhandson.paging3

import com.google.gson.annotations.SerializedName

data class PagedResponse(
    @SerializedName("info") val pageInfo: PageInfo,
    val results: List<Character> = listOf()
)