package com.workouts.kotlinhandson.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.workouts.kotlinhandson.paging.Product

@Database(entities = [Product::class], version = 1)
abstract class HansonDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}