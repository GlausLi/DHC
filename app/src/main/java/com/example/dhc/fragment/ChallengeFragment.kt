package com.example.dhc.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isInvisible

import com.example.dhc.R

class ChallengeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_challenge, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val challengeButton = activity!!.findViewById<Button>(R.id.challenge_button)
        val historyButton = activity!!.findViewById<Button>(R.id.history_button)
        val badgeButton = activity!!.findViewById<Button>(R.id.badge_button)
        val challengeView = activity!!.findViewById<LinearLayout>(R.id.challenge_view)
        val historyView = activity!!.findViewById<LinearLayout>(R.id.history_view)
        val badgeView = activity!!.findViewById<LinearLayout>(R.id.badge_view)
        val informationButton = activity!!.findViewById<Button>(R.id.information_button)
        val closeButton = activity!!.findViewById<Button>(R.id.close_button)
        val informationBoard = activity!!.findViewById<ConstraintLayout>(R.id.information_board)

        closeButton.setOnClickListener {
            informationBoard.visibility = View.INVISIBLE
        }
        informationButton.setOnClickListener {
            informationBoard.visibility = View.VISIBLE
        }
        challengeButton.setOnClickListener {
            challengeButton.setBackgroundResource(R.drawable.bg_round30_brand7)
            historyButton.setBackgroundResource(R.drawable.bg_transparent)
            badgeButton.setBackgroundResource(R.drawable.bg_transparent)
            challengeView.visibility = View.VISIBLE
            historyView.visibility = View.INVISIBLE
            badgeView.visibility = View.INVISIBLE
        }
        historyButton.setOnClickListener {
            challengeButton.setBackgroundResource(R.drawable.bg_transparent)
            historyButton.setBackgroundResource(R.drawable.bg_round30_brand7)
            badgeButton.setBackgroundResource(R.drawable.bg_transparent)
            challengeView.visibility = View.INVISIBLE
            historyView.visibility = View.VISIBLE
            badgeView.visibility = View.INVISIBLE
        }
        badgeButton.setOnClickListener {
            challengeButton.setBackgroundResource(R.drawable.bg_transparent)
            historyButton.setBackgroundResource(R.drawable.bg_transparent)
            badgeButton.setBackgroundResource(R.drawable.bg_round30_brand7)
            challengeView.visibility = View.INVISIBLE
            historyView.visibility = View.INVISIBLE
            badgeView.visibility = View.VISIBLE
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ChallengeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
