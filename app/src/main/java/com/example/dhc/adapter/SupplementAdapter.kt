package com.example.dhc.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.lujun.androidtagview.TagContainerLayout
import com.example.dhc.R
import com.example.dhc.model.RecommendItem
import com.example.dhc.model.SupplementsItem

class SupplementAdapter(var supplementItems: ArrayList<SupplementsItem>) :
    RecyclerView.Adapter<SupplementAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SupplementAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_recommend_second, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: SupplementAdapter.ViewHolder, position: Int) {
        holder.bindItems(supplementItems[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return supplementItems.size
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        fun bindItems(item: SupplementsItem) {
            val txtSupplmentTitle = itemView.findViewById(R.id.txt_supplement_title) as TextView
            val txtSupplmentName = itemView.findViewById(R.id.txt_supplement_name) as TextView
            val txtSupplmentType = itemView.findViewById(R.id.txt_supplement_type) as TextView
            val txtSupplmentDate = itemView.findViewById(R.id.txt_supplement_date) as TextView
            val txtSupplmentPrice = itemView.findViewById(R.id.txt_supplement_price) as TextView

            txtSupplmentTitle.setText(item.supplementTitle)
            txtSupplmentName.setText(item.supplementName)
            txtSupplmentType.setText(item.supplementType)
            txtSupplmentDate.setText(item.supplementDate.toString())
            txtSupplmentPrice.setText(item.supplementPrice.toString())
        }
    }
}