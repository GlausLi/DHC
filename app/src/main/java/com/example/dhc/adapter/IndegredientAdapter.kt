package com.example.dhc.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.lujun.androidtagview.TagContainerLayout
import com.example.dhc.R
import com.example.dhc.model.RecommendItem

class IndegredientAdapter(var recommendItems: ArrayList<RecommendItem>) :
    RecyclerView.Adapter<IndegredientAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndegredientAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_recommend, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: IndegredientAdapter.ViewHolder, position: Int) {
        holder.bindItems(recommendItems[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return recommendItems.size
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        fun bindItems(item: RecommendItem) {
            val txtIngredientType = itemView.findViewById(R.id.txt_ingredient_type) as TextView
            val tagIngredientList  = itemView.findViewById(R.id.taglayout_ingredient_list) as TagContainerLayout
            txtIngredientType.text = item.ingredientType
            tagIngredientList.setTags(item.ingredeintList)
        }
    }
}