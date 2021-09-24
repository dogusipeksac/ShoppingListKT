package com.example.shoplistkt.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoplistkt.Dao.CategoryDao
import com.example.shoplistkt.Entity.Category
import com.example.shoplistkt.Entity.Items
import com.example.shoplistkt.Dao.ShoppingListDao




@Database(entities = [Category::class, Items::class],version = 1,exportSchema = false)
abstract class APPDatabase: RoomDatabase() {
    abstract fun shoppingListDao(): ShoppingListDao
    companion object{
       @Volatile
        private var INSTANCE: APPDatabase?=null

        fun getDatabase(context: Context): APPDatabase{
            return INSTANCE?: synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    APPDatabase::class.java,
                    "AppDB"
                ).build()
                INSTANCE=instance
                instance
            }
        }


    }

}