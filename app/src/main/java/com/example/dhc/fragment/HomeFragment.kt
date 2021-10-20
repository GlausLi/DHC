package com.example.dhc.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction

import com.example.dhc.R
import com.example.dhc.activity.GuidanceActivity
import com.example.dhc.customviews.ChallengeItem


class HomeFragment : Fragment() {

    // Variables for handling of purchased history
    private var purchasedHistory: Boolean = false
    private lateinit var purchasedDate: String
    private lateinit var purchasedFrom: String
    private lateinit var purchasedAmount: String

    // Fragment transaction
    private lateinit var fragmentTransaction: FragmentTransaction


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Fragment transaction
        fragmentTransaction = parentFragment!!.childFragmentManager.beginTransaction()

        // Handle guidance activity
        var guidance: ImageView = view.findViewById(R.id.guidance)
        guidance.setOnClickListener{
            var intent = Intent(activity, GuidanceActivity::class.java)
            startActivity(intent)
        }

        // Handle the list layout
        listLayoutProcessing(view)

        // Handle the purchased history layout
        purchasedHistoryProcessing(view)
    }


    /**
     * Inflate each item views of list layout for this fragment
     * Define its click listener
     */
    private fun listLayoutProcessing(view: View?) {

        // Inflate counseling item and define its click listener
        var counselingItem: ChallengeItem = view!!.findViewById(R.id.counselingItem)
        counselingItem.setOnClickListener{
            replaceFragment(BuyCounselingFragment.newInstance());
        }

        // Inflate checkup item and its click listener
        var checkupItem: ChallengeItem = view.findViewById(R.id.checkupItem)
        checkupItem.setOnClickListener{
            replaceFragment(MedicalExamFragment.newInstance());
        }

        // Inflate create item and its click listener
        var createItem: ChallengeItem = view.findViewById(R.id.createItem)
        createItem.setOnClickListener{
            replaceFragment(PersonalTaskFragment.newInstance());
        }

        // Inflate test item and its click listener
        var testItem: ChallengeItem = view.findViewById(R.id.testItem)
        testItem.setOnClickListener{
            replaceFragment(GenericTestResultFragment.newInstance());
        }

        // Inflate ingredient item and its click listener
        var ingredientItem: ChallengeItem = view.findViewById(R.id.ingredientItem)
        ingredientItem.setOnClickListener{
            replaceFragment(SelectMaterialFragment.newInstance());
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


    /**
     * Handle the purchased history layout
     * Check purchased history
     * If it exists, show its info
     *   - Inflate purchased info views for purchased history
     *   - Define its click listener
     * Else, don't show its layout
     */
    @SuppressLint("ResourceType")
    private fun purchasedHistoryProcessing(view: View?) {

        // Check purchased history
        checkPurchasedHistory()

        // Inflate purchased info of this fragment
        var purchaseHistoryLayout: LinearLayout = view!!.findViewById(R.id.purchaseHistoryLayout)

        // If the history exists, show its info
        // Else, don't show its layout
        if (purchasedHistory) {
            purchaseHistoryLayout.visibility = View.VISIBLE

            // Purchased info
            var purchasedDateView: TextView = view.findViewById(R.id.purchasedDate)
            var purchasedFromView: TextView = view.findViewById(R.id.purchasedFrom)
            var purchasedAmountView: TextView = view.findViewById(R.id.purchasedAmount)

            purchasedDateView.text = purchasedDate
            purchasedFromView.text = purchasedFrom
            purchasedAmountView.text = purchasedAmount

            // Counseling button
            var counselingBtnView: TextView = view.findViewById(R.id.counselingBtn)
            counselingBtnView.setOnClickListener{
                replaceFragment(TempFragment.newInstance());
            }

            // Medical check button
            var medicalCheckupBtnView: TextView = view.findViewById(R.id.medicalCheckupBtn)
            medicalCheckupBtnView.setOnClickListener{
                replaceFragment(TempFragment.newInstance());
            }

            // Buy again button
            var buyAgainBtnView: TextView = view.findViewById(R.id.buyAgainBtn)
            buyAgainBtnView.setOnClickListener{
                replaceFragment(TempFragment.newInstance());
            }

            // Purchased list button
            var purchasedListBtnView: TextView = view.findViewById(R.id.purchasedListBtn)
            purchasedListBtnView.setOnClickListener{
                replaceFragment(TempFragment.newInstance());
            }
        }
        else {
            purchaseHistoryLayout.visibility = View.GONE
        }
    }


    /**
     * Check purchased history
     */
    private fun checkPurchasedHistory() {

        // delete function
        temp_initPurchasedHistory()
    }


    /**
     * Temporary purchased history
     * (Must be deleted in real app)
     */
    private fun temp_initPurchasedHistory() {
        purchasedHistory = true
        purchasedDate = "2019.09.27に購入"
        purchasedFrom = "DHC パーソナルサプリ SELECT3"
        purchasedAmount = "30日分 / ￥0,000"
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
