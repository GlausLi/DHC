package com.example.dhc.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.dhc.R
import kotlinx.android.synthetic.main.fragment_select_ingredient.*
import kotlinx.android.synthetic.main.fragment_select_ingredient.view.*

/**
 * A simple [Fragment] subclass.
 * Use the [SelectIngredientFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectIngredientFragment : Fragment() {

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
        var ingredientView = inflater.inflate(R.layout.fragment_select_ingredient, container, false)

        ingredientView.btn_confirm.setOnClickListener{
            val fragmentTransaction = parentFragment!!.childFragmentManager.beginTransaction()

            fragmentTransaction.replace(R.id.container, IngredientConfirmFragment.newInstance())
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        return ingredientView;
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment SelectIngredientFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            SelectIngredientFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
