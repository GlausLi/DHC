package com.example.dhc.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.example.dhc.R
import kotlinx.android.synthetic.main.item_challenge.view.*

/**
 * TODO: document your custom view class.
 */
class ChallengeItem : ConstraintLayout {
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
        LayoutInflater.from(context).inflate(R.layout.item_challenge, this)

        val attr = context.obtainStyledAttributes(attrs, R.styleable.ChallengeItem)

        val board = attr.getString(R.styleable.ChallengeItem_board)
        val boardId = resources.getIdentifier(board,"drawable", context.packageName)
        challenge_item_layout.background = ResourcesCompat.getDrawable(resources, boardId, null)

        val avatar = attr.getString(R.styleable.ChallengeItem_avatar)
        val avatarId = resources.getIdentifier(avatar, "drawable", context.packageName)
        image_avatar.setImageDrawable(ResourcesCompat.getDrawable(resources, avatarId, null))

        var text = attr.getString(R.styleable.ChallengeItem_text)
        val textId = resources.getIdentifier(text, "string", context.packageName)
        text_main.text = context.getString(textId)

        attr.recycle()
    }
}
