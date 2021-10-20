package com.example.dhc.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import co.lujun.androidtagview.TagContainerLayout
import com.example.dhc.R
import com.example.dhc.model.PurchasedHistory
import com.example.dhc.model.RecommendItem

class PurchaseHistoryAdapter(var purchasedHistories: ArrayList<PurchasedHistory>) :
    RecyclerView.Adapter<PurchaseHistoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurchaseHistoryAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_purchased_history, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: PurchaseHistoryAdapter.ViewHolder, position: Int) {
        holder.bindItems(purchasedHistories[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return purchasedHistories.size
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        fun bindItems(item: PurchasedHistory) {
            val txtDate = itemView.findViewById(R.id.txt_date) as TextView
            val txtDescription = itemView.findViewById(R.id.txt_description) as TextView

            txtDate.text = item.date
            txtDescription.text = item.description

        }
    }
}