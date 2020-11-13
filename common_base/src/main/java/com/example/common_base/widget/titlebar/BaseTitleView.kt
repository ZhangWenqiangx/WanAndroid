package com.example.common_base.widget.titlebar

import androidx.annotation.ColorInt
import android.view.View

/**
 * @describe :标题栏实现的基本功能
 *
 * @author zwq 2020/11/12
 */
interface BaseTitleView {
    fun showBackBtn(show: Boolean): BaseTitleView

    fun setBackClickListener(listener: View.OnClickListener): BaseTitleView

    fun setTitle(title: Int): BaseTitleView

    fun setTitle(title: String): BaseTitleView

    fun setTitleColor(@ColorInt color: Int): BaseTitleView
}