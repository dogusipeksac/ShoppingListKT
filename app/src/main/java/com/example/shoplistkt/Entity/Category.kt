package com.example.shoplistkt.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Category")
class Category {

    @PrimaryKey(autoGenerate = true) var id: Int? = null

    @ColumnInfo(name = "categoryName")
    var categoryName: String?=null
}



