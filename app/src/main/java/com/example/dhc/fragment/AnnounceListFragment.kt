package com.example.dhc.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import com.example.dhc.R
import com.example.dhc.adapter.AnnounceListAdapter
import com.example.dhc.model.Announce
import com.example.dhc.viewmodel.ComponentViewModel

class AnnounceListFragment : Fragment() {

    private var viewModel: ComponentViewModel = ViewModelProviders.of(this).get(ComponentViewModel::class.java)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_announce_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var announce = mutableListOf<Announce>()

        announce.add(Announce("アプリのバージョンアップについて","2019/08/01","テキストがはいります"))
        announce.add(Announce("アプリのバージョンアップについて","2019/08/01","テキストがはいります"))
        announce.add(Announce("アプリのバージョンアップについて","2019/08/01","テキストがはいります"))
        announce.add(Announce("アプリのバージョンアップについて","2019/08/01","テキストがはいります"))

        val listView = activity!!.findViewById<ListView>(R.id.listView)
        listView.adapter = AnnounceListAdapter(requireContext(), announce)

        listView.setOnItemClickListener {parent, view, position, id ->
            when(position) {
                0 -> {
                    val fragmentTransaction =
                        parentFragment!!.childFragmentManager.beginTransaction()

                    // 詳細画面を呼び出す
                    fragmentTransaction.replace(R.id.container, AnnounceFragment.newInstance())
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            AnnounceListFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
