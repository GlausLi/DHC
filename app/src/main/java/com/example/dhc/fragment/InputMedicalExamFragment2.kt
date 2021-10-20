package com.example.dhc.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction

import com.example.dhc.R

class InputMedicalExamFragment2 : Fragment() {

    // Fragment transaction
    private lateinit var fragmentTransaction: FragmentTransaction


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_medical_exam2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Fragment transaction
        fragmentTransaction = parentFragment!!.childFragmentManager.beginTransaction()

        // Handle save button
        var saveBtn: TextView = view.findViewById(R.id.saveBtn)
        saveBtn.setOnClickListener{
            replaceFragment(MedicalAnalysisResultFragment.newHeathInstance());
        }
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
            InputMedicalExamFragment2().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
