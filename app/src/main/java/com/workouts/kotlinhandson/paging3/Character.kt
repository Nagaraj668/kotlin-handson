package com.workouts.kotlinhandson.paging3

data class Character(
    val id: Int,
    val name: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val url: String,
    val episode: List<String>
)