package com.example.dhc.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction

import com.example.dhc.R
import com.example.dhc.activity.GuidanceActivity
import com.example.dhc.customviews.ExamItem
import com.example.dhc.customviews.IconButton
import kotlinx.android.synthetic.main.fragment_input_medical_exam1.*
import kotlinx.android.synthetic.main.item_exam.view.*

class InputMedicalExamFragment1 : Fragment() {

    // Fragment transaction
    private lateinit var fragmentTransaction: FragmentTransaction


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_medical_exam1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Fragment transaction
        fragmentTransaction = parentFragment!!.childFragmentManager.beginTransaction()

        // Handle input button with camera
        var inputWithCamera: IconButton = view.findViewById(R.id.inputWithCamera)
        inputWithCamera.setOnClickListener{
            replaceFragment(TempFragment.newInstance());
        }

        // Handle save button
        var saveBtn: TextView = view.findViewById(R.id.saveBtn)
        saveBtn.setOnClickListener{
            replaceFragment(MedicalAnalysisResultFragment.newHeathInstance());
        }

//        var bodyWeightEdit: ExamItem = view.findViewById(R.id.bodyWeightEdit1)
//        bodyWeightEdit.examEdit.setText("123123123")

    }


    /**
     * Replace fragment with temp fragment
     */
    private fun replaceFragment(fragment: Fragment) {

        // Replace fragment
        fragmentTransaction.replace(R.id.container, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            InputMedicalExamFragment1().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
