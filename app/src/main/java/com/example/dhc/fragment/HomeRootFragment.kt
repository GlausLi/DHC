package com.example.dhc.fragment

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.dhc.R

class HomeRootFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_root, container, false)

        val fragmentTransaction = childFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container, HomeFragment.newInstance())
        fragmentTransaction.commit()

        view.isFocusableInTouchMode = true
        view.setOnKeyListener(View.OnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_UP) {
                if (childFragmentManager.backStackEntryCount > 0) {
                    childFragmentManager.popBackStack()
                    return@OnKeyListener true
                }
            }
            false
        })

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeRootFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
