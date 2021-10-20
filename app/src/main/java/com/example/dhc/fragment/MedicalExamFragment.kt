package com.example.dhc.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction

import com.example.dhc.R
import com.example.dhc.customviews.ChallengeItem

class MedicalExamFragment : Fragment() {

    // Fragment transaction
    private lateinit var fragmentTransaction: FragmentTransaction


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_medical_exam, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentTransaction = parentFragment!!.childFragmentManager.beginTransaction()

        val examResultBtn: ChallengeItem = view.findViewById(R.id.examResult)
        examResultBtn.setOnClickListener {

            fragmentTransaction.replace(R.id.container, InputMedicalExamFragment1.newInstance())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        val latestExamResultBtn: ChallengeItem = view.findViewById(R.id.latestExamResult)
        latestExamResultBtn.setOnClickListener {
            replaceFragment(TempFragment.newInstance());
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
            MedicalExamFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
