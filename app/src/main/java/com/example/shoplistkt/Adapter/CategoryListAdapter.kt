package com.example.shoplistkt.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoplistkt.Entity.Category
import com.example.shoplistkt.R


class CategoryListAdapter(context: Context,handleCategoryClick: HandleCategoryClick) :
    RecyclerView.Adapter<CategoryListAdapter.ViewHolder>() {

    private var context: Context = context
    private lateinit var categoryList: List<Category>
    fun getCategoryList():List<Category>{
        return  categoryList
    }
    fun setCategoryList(value:List<Category>){
        categoryList=value
        notifyDataSetChanged();
    }

    private val clickListener: HandleCategoryClick = handleCategoryClick
    fun getClickListener():HandleCategoryClick{
        return clickListener
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textviewCategoryName: TextView =itemView.findViewById(R.id.textviewCategoryName)
        var removeCategory: ImageView = itemView.findViewById(R.id.removeCategory)
        var editCategory: ImageView = itemView.findViewById(R.id.editCategory)

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryListAdapter.ViewHolder {
        var view:View=LayoutInflater.from(context).inflate(
            R.layout.recycler_row,
            parent,
            false
        )
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: CategoryListAdapter.ViewHolder, position: Int) {
        holder.textviewCategoryName.text=categoryList[position].categoryName
        holder.itemView.setOnClickListener {
            clickListener.itemClick(categoryList[position])
        }
        holder.removeCategory.setOnClickListener {
            clickListener.removeItemClick(categoryList[position])
        }

        holder.editCategory.setOnClickListener {
            clickListener.editItemClick(categoryList[position])
        }


    }

    override fun getItemCount(): Int {
        if(categoryList.isEmpty())
            return 0
        else
            return categoryList.size
    }


    interface HandleCategoryClick {
        fun itemClick(category: Category?)
        fun removeItemClick(category: Category?)
        fun editItemClick(category: Category?)
    }
}