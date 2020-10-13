package com.example.common_base.base

import android.app.Dialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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
}