package com.example.dhc.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import com.example.dhc.R
import kotlinx.android.synthetic.main.item_challenge.view.*
import kotlinx.android.synthetic.main.layout_icon_button.view.*

/**
 * TODO: document your custom view class.
 */
class IconButton : LinearLayout {
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
        LayoutInflater.from(context).inflate(R.layout.layout_icon_button, this)

        val attr = context.obtainStyledAttributes(attrs, R.styleable.IconButton)

        val bg = attr.getString(R.styleable.IconButton_btnBg)
        val bgId = resources.getIdentifier(bg,"drawable", context.packageName)
        btn_layout.background = ResourcesCompat.getDrawable(resources, bgId, null)

        val icon = attr.getString(R.styleable.IconButton_btnIcon)
        val iconId = resources.getIdentifier(icon, "drawable", context.packageName)
        btnIcon.setImageDrawable(ResourcesCompat.getDrawable(resources, iconId, null))

        val text = attr.getString(R.styleable.IconButton_btnText)
        val textId = resources.getIdentifier(text, "string", context.packageName)
        btnText.text = context.getString(textId)

        val textColor = attr.getString(R.styleable.IconButton_btnTextColor)
        val textColorId = resources.getIdentifier(textColor, "color", context.packageName)
        btnText.setTextColor(context.getColor(textColorId))

        attr.recycle()
    }
}
