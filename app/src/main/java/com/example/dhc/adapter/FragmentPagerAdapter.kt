package com.example.dhc.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

//class FragmentPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager)  {
class FragmentPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager,
    FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragmentList: ArrayList<Fragment> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    fun addFragemnt(fragment: Fragment) {
        fragmentList.add(fragment)
    }
}