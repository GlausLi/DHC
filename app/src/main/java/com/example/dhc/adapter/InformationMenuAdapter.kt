package com.example.dhc.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.dhc.R
import com.example.dhc.model.InformationMenu
import kotlinx.android.synthetic.main.item_information_menu.view.*

class InformationMenuAdapter(val context: Context,
                      val menus: List<InformationMenu>) : BaseAdapter() {

    val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return menus.count()
    }

    override fun getItem(position: Int): InformationMenu {
        return menus[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder", "SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = layoutInflater.inflate(R.layout.item_information_menu, parent, false)

        view.icon_image.setImageResource(menus[position].iconImage)
        view.menu_text.text = menus[position].menuString

        return view
    }
}