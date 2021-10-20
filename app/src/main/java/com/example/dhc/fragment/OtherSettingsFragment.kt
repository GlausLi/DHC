package com.example.dhc.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView

import com.example.dhc.R
import com.example.dhc.adapter.InformationMenuAdapter
import com.example.dhc.adapter.OtherMenuAdapter
import com.example.dhc.model.InformationMenu
import com.example.dhc.model.OtherMenu

class OtherSettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_other_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var menus = mutableListOf<OtherMenu>()

        menus.add(OtherMenu("機能設定"))
        menus.add(OtherMenu("利用規約"))
        menus.add(OtherMenu("個人情報保護方針"))
        menus.add(OtherMenu("お問い合わせ"))

        val listView = activity!!.findViewById<ListView>(R.id.listView)
        listView.adapter = OtherMenuAdapter(requireContext(), menus)

        listView.setOnItemClickListener {parent, view, position, id ->
            when(position) {
                0 -> {
//                    parentFragment!!.childFragmentManager.popBackStack()

                    val fragmentTransaction =
                        parentFragment!!.childFragmentManager.beginTransaction()

                    // 詳細画面を呼び出す
                    fragmentTransaction.replace(R.id.container, SettingsPushFragment.newInstance())
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                }
                1 -> {
                    val fragmentTransaction =
                        parentFragment!!.childFragmentManager.beginTransaction()

                    // 詳細画面を呼び出す
                    fragmentTransaction.replace(R.id.container, WebViewFragment.newTermsInstance())
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                }
                2 -> {
                    val fragmentTransaction =
                        parentFragment!!.childFragmentManager.beginTransaction()

                    // 詳細画面を呼び出す
                    fragmentTransaction.replace(R.id.container, WebViewFragment.newPolicyInstance())
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                }
                3 -> {
                    val fragmentTransaction =
                        parentFragment!!.childFragmentManager.beginTransaction()

                    // 詳細画面を呼び出す
                    fragmentTransaction.replace(R.id.container, WebViewFragment.newContactInstance())
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            OtherSettingsFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
