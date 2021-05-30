package com.workouts.kotlinhandson

import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.workouts.kotlinhandson.database.OnetimeDataInsert
import com.workouts.kotlinhandson.databinding.ActivityPagingBinding
import com.workouts.kotlinhandson.paging.Product
import com.workouts.kotlinhandson.paging.ProductsAdapter
import com.workouts.kotlinhandson.paging.ProductsViewModel

class PagingActivity : AppCompatActivity() {

    private lateinit var adapter: ProductsAdapter

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityPagingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var productsRecyclerView: RecyclerView = binding.recyclerview

        val model: ProductsViewModel by viewModels()
        model.products.observe(this, {
            adapter = ProductsAdapter(it)
            productsRecyclerView.layoutManager = LinearLayoutManager(this)
            productsRecyclerView.adapter = adapter
        })

    }
}