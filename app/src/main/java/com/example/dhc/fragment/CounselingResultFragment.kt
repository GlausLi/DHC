package com.example.dhc.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.lujun.androidtagview.TagContainerLayout

import com.example.dhc.R
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [CounselingResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CounselingResultFragment : Fragment() {

    lateinit var mTagContainer: TagContainerLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var resultView = inflater.inflate(R.layout.fragment_counseling_result, container, false)
        mTagContainer = resultView.findViewById(R.id.taglayout_counseling_result)
        var counselingArray: Array<String> = getResources().getStringArray(R.array.counseling_result_array)
        mTagContainer.setTags(counselingArray.toList())
        return resultView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment CounselingResultFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            CounselingResultFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
