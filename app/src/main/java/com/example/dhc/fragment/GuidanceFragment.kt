package com.example.dhc.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.dhc.R

class GuidanceFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_guidance, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            GuidanceFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
