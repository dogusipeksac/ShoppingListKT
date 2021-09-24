package com.example.shoplistkt.Dao

import androidx.room.*

import com.example.shoplistkt.Entity.Category
import com.example.shoplistkt.Entity.Items


@Dao
interface ShoppingListDao {

    @Query("Select * from Category")
    fun getAllCategoryList(): List<Category>

    @Insert
    fun insertCategory(vararg categories: Category)

    @Update
    fun updateCategory(category: Category)

    @Delete
    fun deleteCategory(category: Category)

    @Query("Select * from Items where categoryId=:catId")
    fun getAllItemList(catId: Int): List<Items>

    @Insert
    fun insertItems(items: Items)

    @Update
    fun updateItems(items: Items)

    @Delete
    fun deleteItems(items: Items)
}