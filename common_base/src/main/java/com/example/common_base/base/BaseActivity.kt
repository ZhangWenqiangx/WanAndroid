package com.example.common_base.base

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import com.example.common_base.mvp.IView
import com.example.common_base.widget.LoadingDialog

/**
 * Description:所有activity得父类抽取了一些公用方法
 */
abstract class BaseActivity : AppCompatActivity(), IView {

    val mLoadingView by lazy { createLoadingDialog() }

    abstract fun getLayoutResId(): Int

    protected abstract fun initView()
    protected abstract fun initData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())
        setStatusColor(this, isTranslate = false, isDarkText = true)

        initView()
        initData()
    }

    override fun showLoading() {
        mLoadingView.show()
    }

    override fun hideLoading() {
        mLoadingView.dismiss()
    }

    open fun createLoadingDialog(): Dialog {
        return LoadingDialog.Builder(this).create()
    }

    open fun setStatusColor(
        activity: Activity,
        isTranslate: Boolean,
        isDarkText: Boolean
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val window = activity.window
            val decorView = window.decorView
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility =
                (if (isTranslate) View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN else 0) or
                        if (isDarkText) View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR else 0

            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //添加Flag把状态栏设为可绘制模式
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色
            window.statusBarColor = if (isTranslate) Color.TRANSPARENT else Color.WHITE
        }
    }
}