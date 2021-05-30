package com.workouts.kotlinhandson.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.workouts.kotlinhandson.paging.Product

@Dao
interface ProductDao {
    @Query("SELECT * FROM product")
    fun getAll(): List<Product>

    @Query("SELECT * FROM Product WHERE pid IN (:productIds)")
    fun loadAllByIds(productIds: IntArray): List<Product>

    @Query("SELECT * FROM Product WHERE name LIKE :name")
    fun findByName(name: String): Product

    @Insert
    fun insertAllProducts(vararg products: Product)

    @Insert
    fun insertProduct(product: Product)

    @Delete
    fun delete(product: Product)
}