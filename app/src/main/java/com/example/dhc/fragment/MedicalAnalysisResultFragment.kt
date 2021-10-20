package com.example.dhc.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.lujun.androidtagview.TagContainerLayout

import com.example.dhc.R
import kotlinx.android.synthetic.main.fragment_medical_analysis_result.*
import kotlinx.android.synthetic.main.fragment_medical_analysis_result.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [MedicalAnalysisResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MedicalAnalysisResultFragment : Fragment() {

    lateinit var mCounselingTagContainer: TagContainerLayout
    lateinit var mHealthTagContainer: TagContainerLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var resultView = inflater.inflate(R.layout.fragment_medical_analysis_result, container, false)

        mCounselingTagContainer = resultView.findViewById(R.id.taglayout_counseling_result)
        var counselingArray: Array<String> = getResources().getStringArray(R.array.counseling_result_array)
        mCounselingTagContainer.setTags(counselingArray.toList())

        mHealthTagContainer = resultView.findViewById(R.id.taglayout_counseling_result)
        mHealthTagContainer.setTags(counselingArray.toList())

        resultView.btn_recommend_ingredients.setOnClickListener{
            val fragmentTransaction = parentFragment!!.childFragmentManager.beginTransaction()

            fragmentTransaction.replace(R.id.container, RecommendIngredientFragment.newInstance())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        resultView.btn_create_counseling_results.setOnClickListener{
            val fragmentTransaction = parentFragment!!.childFragmentManager.beginTransaction()

            fragmentTransaction.replace(R.id.container, RecommendIngredientFragment.newInstance())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        return resultView
    }

    companion object {
        private const val MEDICAL_ANALYSIS_COUNSELLING = 0
        private const val MEDICAL_ANALYSIS_HELATH = 0

        private var MEDICAL_ANALYSIS_TYPE: Int = MEDICAL_ANALYSIS_COUNSELLING;

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment Medical Analysis Result.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            MedicalAnalysisResultFragment().apply {
                arguments = Bundle().apply {

                }
            }

        @JvmStatic
        fun newCounsellingInstance() =
            MedicalAnalysisResultFragment().apply {
                arguments = Bundle().apply {
                    MEDICAL_ANALYSIS_TYPE = MEDICAL_ANALYSIS_COUNSELLING
                }
            }

        fun newHeathInstance() =
            MedicalAnalysisResultFragment().apply {
                arguments = Bundle().apply {
                    MEDICAL_ANALYSIS_TYPE = MEDICAL_ANALYSIS_HELATH
                }
            }
    }
}
