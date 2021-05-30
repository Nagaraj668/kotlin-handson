package com.workouts.kotlinhandson.database

import android.content.Context
import androidx.room.Room
import com.workouts.kotlinhandson.paging.Product

class OnetimeDataInsert {

    fun insertData(context: Context) {
        val db = Room.databaseBuilder(
            context,
            HansonDatabase::class.java, "hands-on-database"
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()

        val dao = db.productDao()

        for (i in 1..100) {
            dao.insertProduct(Product(0, "Banana", "Healthy", 5))
        }
    }

    fun getData(context: Context): List<Product> {
        val db = Room.databaseBuilder(
            context,
            HansonDatabase::class.java, "hands-on-database"
        ).build()

        val dao = db.productDao()
        return dao.getAll()
    }
}