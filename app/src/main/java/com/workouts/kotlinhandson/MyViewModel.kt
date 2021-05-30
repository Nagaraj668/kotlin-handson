package com.workouts.kotlinhandson

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.workouts.kotlinhandson.pojo.User
import kotlinx.coroutines.*
import org.json.JSONObject
import java.io.InputStream
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MyViewModel : ViewModel() {
    val user: MutableLiveData<User> by lazy {
        MutableLiveData<User>().also {
            loadUser()
        }
    }

    private fun loadUser() {
        viewModelScope.launch {
            val json = JSONObject(httpGet())
            user.value = User(json.getString("name"))
        }
    }

    private suspend fun httpGet(): String {
        return withContext(Dispatchers.IO) {
            val myURL = "https://cool-time.firebaseio.com/user.json"
            val inputStream: InputStream?
            val url = URL(myURL)
            val connection: HttpsURLConnection = url.openConnection() as HttpsURLConnection
            connection.connect()
            inputStream = connection.inputStream
            return@withContext inputStream?.bufferedReader()!!.readText()
        }
    }

    fun refresh() {
        loadUser()
    }
}