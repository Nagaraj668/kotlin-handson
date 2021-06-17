package com.workouts.kotlinhandson

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.workouts.kotlinhandson.databinding.ActivityRxJavaBinding
import com.workouts.kotlinhandson.newsapi.News
import com.workouts.kotlinhandson.rxjava.ApiService
import com.workouts.kotlinhandson.rxjava.HttpClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

class RxJavaActivity : AppCompatActivity() {

    private val apiService = HttpClient.getApiService()

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRxJavaBinding.inflate(layoutInflater)
        setContentView(binding.root)


        apiService.getNews("mojombo")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                println(it.toString())
                binding.textView5.text = it.login
            }, { t ->
                println(t.toString())
            })
    }

}