package com.example.dhc.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

import com.example.dhc.R

class CounselingFragment : Fragment(), View.OnClickListener {

    val mPageCount = 3
    var mCurPage = 0
    val mQuestionArray = arrayOf(R.string.question_nervous_system, R.string.question_lifestyle_disease, R.string.question_lifestyle_disease)
    val mContentArray = arrayOf(R.string.answer_nervous_system, R.string.answer_lifestyle_disease, R.string.answer_lifestyle_disease)
    val mIconArray = arrayOf(R.drawable.c1, R.drawable.c2, R.drawable.c4)

    lateinit var mBtnPrev: Button
    lateinit var mBtnNext: Button
    lateinit var mBtnYes: Button
    lateinit var mBtnNo: Button

    lateinit var mTxtQuestionTitle: TextView
    lateinit var mTxtQuestionContent: TextView
    lateinit var mIvQuestion: ImageView
    lateinit var mTxtQuestionNumber: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var conselingView = inflater.inflate(R.layout.fragment_counseling, container, false)
        mBtnNext = conselingView.findViewById(R.id.btn_question_next)
        mBtnPrev = conselingView.findViewById(R.id.btn_question_prev)
        mBtnYes = conselingView.findViewById(R.id.btn_yes)
        mBtnNo = conselingView.findViewById(R.id.btn_no)

        mTxtQuestionTitle = conselingView.findViewById(R.id.txt_question_title)
        mTxtQuestionContent = conselingView.findViewById(R.id.txt_question_content)
        mIvQuestion = conselingView.findViewById(R.id.iv_question)
        mTxtQuestionNumber = conselingView.findViewById(R.id.txt_question_number)

        mBtnNext.setOnClickListener(this)
        mBtnPrev.setOnClickListener(this)
        mBtnYes.setOnClickListener(this)
        mBtnNo.setOnClickListener(this)

        setQuestion()
        return conselingView
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CounselingFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btn_question_prev -> prevQuestion()
            R.id.btn_question_next -> nextQuestion()
            R.id.btn_yes -> onYesClicked()
            R.id.btn_no -> onNoClicked()
        }
    }

    private fun prevQuestion() {
        if (mCurPage == 0) return
        mCurPage --
        setQuestion()
    }
    private fun nextQuestion() {
        if (mCurPage >= mPageCount - 1) return
        mCurPage ++
        setQuestion()
    }
    private fun onYesClicked() {
        if (mCurPage >= mPageCount - 1) return
        mCurPage ++
        /* Save data for Yes answer */

        setQuestion()
    }
    private fun onNoClicked() {
        if (mCurPage >= mPageCount - 1) return
        mCurPage ++
        /* Save data for No answer */
        
        setQuestion()
    }

    private fun setQuestion() {
        if (mCurPage >= mPageCount) return
        mTxtQuestionTitle.setText(mQuestionArray[mCurPage])
        mTxtQuestionContent.setText(mContentArray[mCurPage])
        mIvQuestion.setImageDrawable(context?.getDrawable(mIconArray[mCurPage]))

        if (mCurPage == 0){
            mBtnPrev.visibility = View.GONE
        }else{
            mBtnPrev.visibility = View.VISIBLE
        }
        if (mCurPage < mPageCount - 1){
            mBtnNext.visibility = View.VISIBLE
        }else{
            mBtnNext.visibility = View.GONE
        }
        mTxtQuestionNumber.setText(String.format("Q%d/%d", mCurPage+1, mPageCount))
    }
}
