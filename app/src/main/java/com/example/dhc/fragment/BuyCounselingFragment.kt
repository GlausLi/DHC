package com.example.dhc.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.dhc.R
import com.example.dhc.customviews.ChallengeItem

class BuyCounselingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view: View? = inflater.inflate(R.layout.fragment_buy_counseling, container, false)

        // Counseling item click listener
        var counselingItem: ChallengeItem = view!!.findViewById(R.id.counselingItem)
        counselingItem.setOnClickListener{

            val fragmentTransaction =
                parentFragment!!.childFragmentManager.beginTransaction()

            // 詳細画面を呼び出す
//            fragmentTransaction.replace(R.id.container, CounselingFragment.newInstance())
            fragmentTransaction.replace(R.id.container, CounselingResult2Fragment.newInstance())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        // Inflate the layout for this fragment
        return view
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            BuyCounselingFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
