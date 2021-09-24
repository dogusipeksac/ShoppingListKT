package com.example.shoplistkt.ViewHolder

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.shoplistkt.Database.APPDatabase
import com.example.shoplistkt.Entity.Category


class MainActivityViewModel(application: Application?) : AndroidViewModel(application!!) {
    private lateinit var  listOfCategory: MutableLiveData<List<Category>>
    private var  appDatabase: APPDatabase
            = APPDatabase.getDatabase(getApplication<Application>().applicationContext)
    val categoryListObserver: MutableLiveData<List<Category>>
        get() = listOfCategory
    private val allCategoryList: Unit
        get() {
            val categoryList: List<Category> = appDatabase.shoppingListDao().
            getAllCategoryList()
            if (categoryList.size > 0) {
                listOfCategory.postValue(categoryList)
            } else {
                listOfCategory.postValue(null)
            }
        }

    fun insertCategory(catName: String) {
        val category = Category()
        category.categoryName = catName
        appDatabase.shoppingListDao().insertCategory(category)
        allCategoryList
    }

    fun updateCategory(category: Category?) {
        if (category != null) {
            appDatabase.shoppingListDao().updateCategory(category)
        }
        allCategoryList
    }

    fun deleteCategory(category: Category?) {
        if (category != null) {
            appDatabase.shoppingListDao().deleteCategory(category)
        }
        allCategoryList
    }

}