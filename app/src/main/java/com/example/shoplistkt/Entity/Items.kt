package com.example.shoplistkt.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "Items")
class Items (
    @PrimaryKey(autoGenerate = true) var uid: Int,
    @ColumnInfo(name = "itemName") var  itemName:String,
    @ColumnInfo(name = "categoryId") var  categoryId:String,
    @ColumnInfo(name = "completed") var completed:Boolean)