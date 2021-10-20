package com.example.dhc.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.dhc.R

class HowToFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_how_to, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HowToFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
