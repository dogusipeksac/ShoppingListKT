package com.example.shoplistkt.Adapter

import android.content.Context
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoplistkt.Entity.Items
import android.widget.TextView
import com.example.shoplistkt.R


class ItemListAdapter(context: Context,handleItemClick: HandleItemClick)
    : RecyclerView.Adapter<ItemListAdapter.ViewHolder>() {

    private val context: Context = context
    private lateinit var itemsList: List<Items>
    fun getItemsList():List<Items>{
        return itemsList
    }
    fun setItemList(value:List<Items>){
        itemsList=value
    }
    private val clickListener: HandleItemClick = handleItemClick
    fun getClickListener():HandleItemClick{
        return clickListener
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textviewItemName: TextView = itemView.findViewById(R.id.textviewCategoryName)
        var removeCategory: ImageView = itemView.findViewById(R.id.removeCategory)
        var editCategory: ImageView = itemView.findViewById(R.id.editCategory)
    }



    interface HandleItemClick {
        fun itemClick(items: Items?)
        fun removeItemClick(items: Items?)
        fun editItemClick(items: Items?)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view:View=LayoutInflater.from(context).inflate(R.layout.recycler_row,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textviewItemName.text = itemsList.get(position).itemName
        holder.itemView.setOnClickListener {
            clickListener.itemClick(itemsList[position])
        }
        holder.removeCategory.setOnClickListener {
            clickListener.removeItemClick(itemsList[position])
        }

        holder.editCategory.setOnClickListener {
            clickListener.editItemClick(itemsList[position])
        }
        if (itemsList[position].completed) {
            holder.textviewItemName.paintFlags =
                holder.textviewItemName.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            holder.textviewItemName.paintFlags = 0
        }
    }

    override fun getItemCount(): Int {
        if(itemsList.isEmpty())
            return 0
        else
            return itemsList.size
    }

}