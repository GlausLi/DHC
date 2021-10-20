package com.example.dhc.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.example.dhc.R
import kotlinx.android.synthetic.main.item_challenge.view.*
import kotlinx.android.synthetic.main.item_exam.view.*

/**
 * TODO: document your custom view class.
 */
class ExamItem : ConstraintLayout {
    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        LayoutInflater.from(context).inflate(R.layout.item_exam, this)

        val attr = context.obtainStyledAttributes(attrs, R.styleable.ExamItem)

        val title = attr.getString(R.styleable.ExamItem_title)
        val titleId = resources.getIdentifier(title,"string", context.packageName)
        examTitle.text = context.getString(titleId)

        val unit = attr.getString(R.styleable.ExamItem_unit)
        val unitId = resources.getIdentifier(unit,"string", context.packageName)
        examUnit.text = context.getString(unitId)

        attr.recycle()
    }
}
