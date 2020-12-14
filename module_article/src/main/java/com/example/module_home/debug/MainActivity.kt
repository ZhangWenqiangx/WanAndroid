package com.example.module_home.debug

import com.example.common_base.base.BaseActivity
import com.example.module_home.ArticleFragment
import com.example.module_home.R

/**
 * 单独运行时承载fragment
 */
class MainActivity : BaseActivity() {

    override fun getLayoutResId(): Int =
        R.layout.activity_main

    override fun initView() {}

    override fun initData() {
        val homeFragment = ArticleFragment()
        supportFragmentManager.beginTransaction().apply {
            add(R.id.fl_content, homeFragment)
            show(homeFragment)
            commit()
        }
    }
}