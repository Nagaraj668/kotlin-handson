package com.workouts.kotlinhandson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.workouts.kotlinhandson.databinding.ActivityNewsBinding
import com.workouts.kotlinhandson.newsapi.NewsListAdapter
import com.workouts.kotlinhandson.newsapi.NewsListViewModel
import com.workouts.kotlinhandson.newsapi.State

class NewsActivity : AppCompatActivity() {

    private val viewModel: NewsListViewModel by viewModels()
    private lateinit var newsListAdapter: NewsListAdapter

    private lateinit var binding:ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
        initState()
    }

    private fun initAdapter() {
        newsListAdapter = NewsListAdapter { viewModel.retry() }
        binding.recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.recyclerView.adapter = newsListAdapter
        viewModel.newsList.observe(this, {
            newsListAdapter.submitList(it)
        })
    }

    private fun initState() {
        binding.txtError.setOnClickListener { viewModel.retry() }
        viewModel.getState().observe(this, Observer { state ->
            binding.progressBar.visibility = if (viewModel.listIsEmpty() && state == State.LOADING) View.VISIBLE else View.GONE
            binding.txtError.visibility = if (viewModel.listIsEmpty() && state == State.ERROR) View.VISIBLE else View.GONE
            if (!viewModel.listIsEmpty()) {
                newsListAdapter.setState(state ?: State.DONE)
            }
        })
    }
}