package com.workouts.kotlinhandson.rxjava

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object HttpClient {

    private const val API_BASE_URL = "https://api.github.com/"

    fun getApiService(): ApiService {
        return apiService
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService = retrofit.create(ApiService::class.java)
}