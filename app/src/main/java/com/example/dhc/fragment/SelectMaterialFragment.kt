package com.example.dhc.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.dhc.R
import com.example.dhc.customviews.ChallengeItem

class SelectMaterialFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View? = inflater.inflate(R.layout.fragment_select_material, container, false)

        // Counseling item click listener
        var item: ChallengeItem = view!!.findViewById(R.id.item)
        item.setOnClickListener{

            val fragmentTransaction =
                parentFragment!!.childFragmentManager.beginTransaction()

            // 詳細画面を呼び出す
//            fragmentTransaction.replace(R.id.container, CounselingFragment.newInstance())
            fragmentTransaction.replace(R.id.container, SelectIngredientFragment.newInstance())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        // Inflate the layout for this fragment
        return view
    }

    companion object {
        fun newInstance() =
            SelectMaterialFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
