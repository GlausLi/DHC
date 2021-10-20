package com.example.dhc.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dhc.R
import com.example.dhc.adapter.PurchaseHistoryAdapter
import com.example.dhc.model.PurchasedHistory
import com.example.dhc.model.RecommendItem


/**
 * A simple [Fragment] subclass.
 * Use the [PurchasedHistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PurchasedHistoryFragment : Fragment() {

    private var mListView: RecyclerView? = null
    private var mAdapter: PurchaseHistoryAdapter? = null
    private var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var historyView = inflater.inflate(R.layout.fragment_purchased_history, container, false)

        mListView = historyView.findViewById(R.id.list_purchased)
        mListView?.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        mListView?.layoutManager = layoutManager

        var items = createDummyData()
        mAdapter = PurchaseHistoryAdapter(items)
        mListView?.adapter = mAdapter

        return historyView
    }

    private fun createDummyData(): ArrayList<PurchasedHistory> {
        var items = ArrayList<PurchasedHistory>()

        var item1 = PurchasedHistory("2019.09.27に購入", "DHC パーソナルサプリ SELECT3\n" +
                "30日分 / ￥0,000")
        items.add(item1)

        var item2 = PurchasedHistory("2019.10.9に購入", "DHC パーソナルサプリ SELECT3\n" +
                "30日分 / ￥0,000")
        items.add(item2)

        var item3 = PurchasedHistory("2019.11.3に購入", "DHC パーソナルサプリ SELECT3\n" +
                "30日分 / ￥0,000")
        items.add(item3)

        var item4 = PurchasedHistory("2019.11.9に購入", "DHC パーソナルサプリ SELECT3\n" +
                "30日分 / ￥0,000")
        items.add(item4)

        return items
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment RecommendIngredientFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            PurchasedHistoryFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
