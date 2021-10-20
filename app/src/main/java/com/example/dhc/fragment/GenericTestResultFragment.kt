package com.example.dhc.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction

import com.example.dhc.R
import com.example.dhc.customviews.ChallengeItem


class GenericTestResultFragment : Fragment() {

    // Fragment transaction
    private lateinit var fragmentTransaction: FragmentTransaction


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_generic_test_result, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentTransaction = parentFragment!!.childFragmentManager.beginTransaction()

        val viewWebBtn: ChallengeItem = view.findViewById(R.id.viewWebBtn)
        viewWebBtn.setOnClickListener {

            fragmentTransaction.replace(R.id.container, TempFragment.newInstance())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        val testKitBtn: ChallengeItem = view.findViewById(R.id.testKitBtn)
        testKitBtn.setOnClickListener {
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
            GenericTestResultFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
