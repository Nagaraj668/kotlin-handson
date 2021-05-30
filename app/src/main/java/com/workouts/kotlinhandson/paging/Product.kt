package com.workouts.kotlinhandson.paging

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true)
    var pid: Int,
    var name: String,
    var description: String,
    var price: Int
)
