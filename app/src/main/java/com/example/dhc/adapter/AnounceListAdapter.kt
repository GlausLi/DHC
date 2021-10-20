package com.example.dhc.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.dhc.R
import com.example.dhc.model.Announce
import com.example.dhc.model.InformationMenu
import kotlinx.android.synthetic.main.item_announce_list.view.*
import kotlinx.android.synthetic.main.item_information_menu.view.*

class AnnounceListAdapter(val context: Context,
                             val announce: List<Announce>) : BaseAdapter() {

    val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return announce.count()
    }

    override fun getItem(position: Int): Announce {
        return announce[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder", "SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = layoutInflater.inflate(R.layout.item_announce_list, parent, false)

        view.date_time.text = announce[position].Datetime
        view.title.text = announce[position].title

        return view
    }
}