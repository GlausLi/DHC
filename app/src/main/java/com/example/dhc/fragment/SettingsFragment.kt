package com.example.dhc.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.example.dhc.R
import com.example.dhc.adapter.InformationMenuAdapter
import com.example.dhc.model.InformationMenu


class SettingsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var menus = mutableListOf<InformationMenu>()

        menus.add(InformationMenu(R.drawable.ic_icon_information,"お知らせ"))
        menus.add(InformationMenu(R.drawable.ic_icon_howto,"使い方"))
        menus.add(InformationMenu(R.drawable.ic_icon_question,"よくある質問"))
        menus.add(InformationMenu(R.drawable.ic_icon_settings,"その他・設定"))

        val listView = activity!!.findViewById<ListView>(R.id.listView)
        listView.adapter = InformationMenuAdapter(requireContext(), menus)

        listView.setOnItemClickListener {parent, view, position, id ->
            when(position) {
                0 -> {
                    val fragmentTransaction = parentFragment!!.childFragmentManager.beginTransaction()

                    // 詳細画面を呼び出す
                    fragmentTransaction.replace(R.id.container, AnnounceListFragment.newInstance())
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                }
                1 -> {
                    val fragmentTransaction =
                        parentFragment!!.childFragmentManager.beginTransaction()

                    // 詳細画面を呼び出す
                    fragmentTransaction.replace(R.id.container, GuidanceFragment.newInstance())
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                }
                2 -> {
                    val fragmentTransaction =
                        parentFragment!!.childFragmentManager.beginTransaction()

                    // 詳細画面を呼び出す
                    fragmentTransaction.replace(R.id.container, WebViewFragment.newHelpInstance())
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                }
                3 -> {
                    val fragmentTransaction =
                        parentFragment!!.childFragmentManager.beginTransaction()

                    // 詳細画面を呼び出す
                    fragmentTransaction.replace(R.id.container, OtherSettingsFragment.newInstance())
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SettingsFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
