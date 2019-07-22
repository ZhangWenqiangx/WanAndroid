package com.example.common_base.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.common_base.R
import com.scwang.smartrefresh.layout.util.DensityUtil.dp2px

/**
 * Description:
 */
class ItemView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    LinearLayout(context, attrs, defStyleAttr) {

    private var leftIcon: Int = 0
    private var rightIcon: Int = 0
    private var dividerView: ImageView? = null
    private var leftImageView: ImageView? = null
    private var titleTextView: TextView? = null
    private var rightImageView: ImageView? = null
    private var title: String? = null
    private var itemBackgroundColor: Int = 0
    private var dividerVisible: Boolean = false
    private var dividerLeftMargin: Float = 0.toFloat()
    private var dividerRightMargin: Float = 0.toFloat()


    init {
        readAttrs(context,attrs)
        init(context)
    }

    private fun init(context: Context?) {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_item_view, this, false)
        leftImageView = view.findViewById(R.id.iv_item_left_icon)
        titleTextView = view.findViewById(R.id.tv_item_title)
        rightImageView = view.findViewById(R.id.iv_right_icon)
        dividerView = view.findViewById(R.id.v_divider)
        val layoutParams = dividerView!!.layoutParams as LayoutParams
        layoutParams.leftMargin = dividerLeftMargin.toInt()
        layoutParams.rightMargin = dividerRightMargin.toInt()

        if (itemBackgroundColor != 0) {
            view.setBackgroundColor(itemBackgroundColor)
        }
        if (leftIcon != 0) {
            leftImageView!!.setImageResource(leftIcon)
        }
        if (rightIcon != 0) {
            rightImageView!!.setImageResource(rightIcon)
        }
        titleTextView!!.text = title
        dividerView!!.visibility = if (dividerVisible) View.VISIBLE else View.GONE
    }

    private fun readAttrs(context: Context?,attrs: AttributeSet?) {
        val typedArray = context?.obtainStyledAttributes(attrs, R.styleable.ItemView)
        leftIcon = typedArray!!.getResourceId(R.styleable.ItemView_leftIcon,0)
        rightIcon = typedArray.getResourceId(R.styleable.ItemView_rightIcon, 0)
        title = typedArray.getString(R.styleable.ItemView_itemTitle)
        itemBackgroundColor = typedArray.getColor(R.styleable.ItemView_itemBackgroundColor, 0)
        dividerVisible = typedArray.getBoolean(R.styleable.ItemView_dividerVisible, true)
        dividerLeftMargin = typedArray.getDimension(R.styleable.ItemView_dividerLeftMargin, dp2px(40F).toFloat())
        dividerRightMargin = typedArray.getDimension(R.styleable.ItemView_dividerRightMargin, 0f)
        typedArray.recycle()
    }
}