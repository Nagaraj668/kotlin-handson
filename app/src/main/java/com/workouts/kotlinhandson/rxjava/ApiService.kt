package com.workouts.kotlinhandson.rxjava

import com.workouts.kotlinhandson.newsapi.News
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("users/{userId}")
    fun getNews(@Path("userId") userId: String): Observable<News>
}