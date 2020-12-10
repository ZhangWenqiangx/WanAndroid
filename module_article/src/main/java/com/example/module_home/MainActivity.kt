package com.example.module_home

import androidx.fragment.app.FragmentManager
import com.example.common_base.base.BaseActivity
import com.example.module_home.firstpage.HomeFragment

/**
 * 单独运行时承载fragment
 */
class MainActivity : BaseActivity() {
    private lateinit var fm: FragmentManager

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun initView() {}

    override fun initData() {
        val homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction().apply {
            add(R.id.fl_content, homeFragment)
            show(homeFragment)
            commit()
        }
    }
}