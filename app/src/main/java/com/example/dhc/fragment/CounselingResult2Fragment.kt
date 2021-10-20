package com.example.dhc.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.dhc.R
import com.example.dhc.adapter.IndegredientAdapter
import com.example.dhc.adapter.SupplementAdapter
import com.example.dhc.model.RecommendItem
import com.example.dhc.model.SupplementsItem


/**
 * A simple [Fragment] subclass.
 * Use the [CounselingResult2Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CounselingResult2Fragment : Fragment() {

    private var mRecyclerView: RecyclerView? = null
    private var mAdapter: SupplementAdapter? = null
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
        var recommendView = inflater.inflate(R.layout.fragment_counseling_result2, container, false)
        mRecyclerView = recommendView.findViewById(R.id.list_recommend_supplement)
        mRecyclerView?.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        mRecyclerView?.layoutManager = layoutManager

        var items = createDummyData()
        mAdapter = SupplementAdapter(items)
        mRecyclerView?.adapter = mAdapter
        return recommendView
    }

    private fun createDummyData(): ArrayList<SupplementsItem> {
        var items = ArrayList<SupplementsItem>()

        var item1 = SupplementsItem("体型のスタイルサポートに","アフリカマンゴノキエキス", "【健康食品】", 30, 617)
        items.add(item1)

        var item2 = SupplementsItem("目の光対策に","ルテイン", "【機能性表示食品】", 30, 617)
        items.add(item2)

        var item3 = SupplementsItem("目の光対策に","ルテイン", "【機能性表示食品】", 30, 617)
        items.add(item3)

        return items
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CounselingResult2Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            CounselingResult2Fragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
