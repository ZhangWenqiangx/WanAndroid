package com.example.common_base.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.text.TextUtils
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import com.example.common_base.R


/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/3
 *  description :
 */
class SearchableView : SearchView {

    private var onCloseLinstener: OnCloseClickListener? = null

    constructor(context: Context) : super(context) {
        initAttrs()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initAttrs()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initAttrs()
    }

    @SuppressLint("ClickableViewAccessibility")
    fun initAttrs() {
        val viewById: View = findViewById(R.id.search_plate)
        viewById.setBackgroundColor(Color.TRANSPARENT)

        val searcButton: ImageView = findViewById(R.id.search_button)
        searcButton.setImageResource(R.drawable.ic_search)

        val closeButton: ImageView = findViewById(R.id.search_close_btn)
        closeButton.setImageResource(R.drawable.icon_close)

        val editText: EditText = findViewById(R.id.search_src_text)
        editText.setTextSize(TypedValue.COMPLEX_UNIT_PX, resources
                .getDimension(R.dimen.textSizePrimaryContent))

        val cancleView: ImageView = findViewById(R.id.search_close_btn)
        if(cancleView.isClickable){
            cancleView.setOnTouchListener { _, _ ->
                onCloseLinstener?.onClose()
                cancleView.clearFocus()
                return@setOnTouchListener false
            }
        }
    }

    fun setOnCloseClickListener(listener: OnCloseClickListener) {
        onCloseLinstener = listener
    }

    interface OnCloseClickListener {
        fun onClose()
    }
}