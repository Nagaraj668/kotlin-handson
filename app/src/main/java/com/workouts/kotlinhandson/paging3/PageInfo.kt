package com.workouts.kotlinhandson.paging3
data class PageInfo(
    val count: Int,
    val pages: Int,
    val next: String,
    val prev: String?
)