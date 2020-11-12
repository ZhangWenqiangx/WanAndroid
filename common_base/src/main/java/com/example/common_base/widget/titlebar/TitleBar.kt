package com.example.common_base.widget.titlebar

import android.app.Activity
import android.content.Context
import android.support.annotation.NonNull
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.common_base.R

/**
 * @describe :
 *
 * @author zwq 2020/11/12
 */
class TitleBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    RelativeLayout(context, attrs, defStyleAttr), BaseTitleView {
    var backBtn: View
    private val titleView: TextView

    @NonNull
    override fun showBackBtn(show: Boolean): TitleBar {
        backBtn.visibility = if (show) View.VISIBLE else View.GONE
        return this
    }

    @NonNull
    override fun setTitle(title: Int): TitleBar {
        titleView.setText(title)
        return this
    }

    override fun setTitle(title: String): BaseTitleView {
        titleView.text = title
        return this
    }

    @NonNull
    fun setTitle(@NonNull title: String?): TitleBar {
        titleView.text = title
        return this
    }

    @NonNull
    override fun setTitleColor(color: Int): TitleBar {
        titleView.setTextColor(color)
        return this
    }

    override fun setBackClickListener(listener: OnClickListener): BaseTitleView {
        backBtn.setOnClickListener(listener)
        return this
    }

    private fun initView(
        context: Context,
        attrs: AttributeSet?
    ) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleView)
        val titleId = typedArray.getResourceId(R.styleable.TitleView_title, 0)
        if (titleId != 0) {
            titleView.setText(titleId)
        }
        // 是否显示返回按钮
        val showBack = typedArray.getBoolean(R.styleable.TitleView_showBack, true)
        backBtn.visibility = if (showBack) View.VISIBLE else View.GONE
        typedArray.recycle()
        backBtn.setOnClickListener { v: View? -> (getContext() as Activity).finish() }
    }

    init {
        val view: View = LayoutInflater.from(context).inflate(R.layout.titleview, this)
        backBtn = view.findViewById(R.id.titleView_back)
        titleView = view.findViewById(R.id.titleView_title)
        initView(context, attrs)
    }
}