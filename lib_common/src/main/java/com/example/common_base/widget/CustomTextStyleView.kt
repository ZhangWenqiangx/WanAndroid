package com.example.common_base.widget

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/17
 *  description :
 */
class CustomTextStyleView : androidx.appcompat.widget.AppCompatTextView {

    constructor(context: Context?) : super(context!!)
    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context!!,
        attrs,
        defStyleAttr
    )

    init {
        typeface = Typeface.createFromAsset(context.assets, "fonts/Lobster-1.4.otf")
    }
}