package com.workouts.kotlinhandson.paging3

import retrofit2.Response

interface CharacterApi {
    fun getAllCharacters(pageNumber: Int): Response<PagedResponse>
}
