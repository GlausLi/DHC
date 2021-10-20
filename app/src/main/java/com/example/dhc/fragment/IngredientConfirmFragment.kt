package com.example.dhc.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dhc.R
import com.example.dhc.adapter.IndegredientAdapter
import com.example.dhc.model.RecommendItem


/**
 * A simple [Fragment] subclass.
 * Use the [IngredientConfirmFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class IngredientConfirmFragment : Fragment() {

    private var mIngredientView: RecyclerView? = null
    private var mAdapter: IndegredientAdapter? = null
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
        var confirmView = inflater.inflate(R.layout.fragment_ingredient_confirm, container, false)
        mIngredientView = confirmView.findViewById(R.id.list_ingredient)
        mIngredientView?.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(context)
        mIngredientView?.layoutManager = layoutManager

        var items = createDummyData()
        mAdapter = IndegredientAdapter(items)
        mIngredientView?.adapter = mAdapter
        return confirmView
    }

    private fun createDummyData(): ArrayList<RecommendItem> {
        var items = ArrayList<RecommendItem>()

        var list1 = ArrayList<String>()
        list1.add("燃焼")
        list1.add("食欲抑制")
        var item1 = RecommendItem("アフリカマンゴノキエキス", list1)
        items.add(item1)

        var list2 = ArrayList<String>()
        list2.add("難聴")
        var item2 = RecommendItem("乳酸菌H61", list2)
        items.add(item2)

        var list3 = ArrayList<String>()
        list3.add("脂質異常")
        var item3 = RecommendItem("紅麹濃縮エキス", list3)
        items.add(item3)

        var list4 = ArrayList<String>()
        list4.add("アルコール")
        var item4 = RecommendItem("還元型クルクミン包接体", list4)
        items.add(item4)

        var list5 = ArrayList<String>()
        list5.add("痛風")
        var item5 = RecommendItem("ルテオリン", list5)
        items.add(item5)

        var list6 = ArrayList<String>()
        list6.add("貧血")
        var item6 = RecommendItem("鉄", list6)
        items.add(item6)

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
            IngredientConfirmFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
