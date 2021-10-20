package com.example.dhc.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.example.dhc.R


class ServiceIntroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View? = inflater.inflate(R.layout.fragment_service_intro,
            container, false)

        val titleView: TextView = view!!.findViewById(R.id.title)
        val descView: TextView =view.findViewById(R.id.description)
        val imgView: ImageView =view.findViewById(R.id.img)

        imgView.setImageResource(arguments!!.getInt("image"))
        titleView.text = getString(arguments!!.getInt("title"))
        descView.text  = getString(arguments!!.getInt("description"))
//            .replace("", "\u00A0")

        return view
    }

    companion object {
        fun newInstance(imgId: Int, titleId: Int, descId: Int): ServiceIntroFragment {

            val fragment = ServiceIntroFragment()

            val bundle = Bundle(1)

            bundle.putInt("title", titleId)
            bundle.putInt("description", descId)
            bundle.putInt("image", imgId)

            fragment.setArguments(bundle)

            return fragment
        }
    }
}