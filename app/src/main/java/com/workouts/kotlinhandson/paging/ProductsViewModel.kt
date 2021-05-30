package com.workouts.kotlinhandson.paging

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.workouts.kotlinhandson.database.OnetimeDataInsert
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.InputStream
import java.net.URL
import javax.net.ssl.HttpsURLConnection

@RequiresApi(Build.VERSION_CODES.N)
class ProductsViewModel(application: Application) : AndroidViewModel(application) {

    val products: MutableLiveData<List<Product>> by lazy {
        MutableLiveData<List<Product>>().also {
            load()
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun load() {
        viewModelScope.launch {
            val json = httpGet()
            val jsonObject = JSONObject(json)
            var products: MutableList<Product> = arrayListOf()
            val gson = Gson()
            jsonObject.keys().forEachRemaining {
                products
                    .add(gson.fromJson(jsonObject.getString(it), Product::class.java))
            }
            println(products)
            this@ProductsViewModel.products.value = products
        }
    }

    fun loadDB() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val onetimeData = OnetimeDataInsert()
                onetimeData.insertData(getApplication())
                val data = onetimeData.getData(getApplication())

                for (product in data) {
                    println(product)
                }
            }
        }
    }

    private suspend fun httpGet(): String {
        return withContext(Dispatchers.IO) {
            val myURL = "https://cool-time.firebaseio.com/products.json"
            val inputStream: InputStream?
            val url = URL(myURL)
            val connection: HttpsURLConnection = url.openConnection() as HttpsURLConnection
            connection.connect()
            inputStream = connection.inputStream
            return@withContext inputStream?.bufferedReader()!!.readText()
        }
    }

}