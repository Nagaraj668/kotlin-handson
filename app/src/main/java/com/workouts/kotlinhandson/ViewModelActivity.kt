package com.workouts.kotlinhandson

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.workouts.kotlinhandson.databinding.ActivityViewModelBinding

class ViewModelActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewModelBinding
    private val model: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewModelBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        model.user.observe(this, {
            binding.user = it
        })
    }

    fun update(view: View) {
        model.refresh()
    }
}