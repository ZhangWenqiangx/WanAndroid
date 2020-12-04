package com.example.module_home

import androidx.fragment.app.FragmentManager
import com.example.common_base.base.BaseActivity

/**
 * 单独运行时承载fragment
 */
class MainActivity : BaseActivity() {
    private lateinit var fm: FragmentManager

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun initView() {}

    override fun initData() {
        fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        val homeFragment = HomeFragment()
        transaction.add(R.id.fl_content, homeFragment)
        transaction.commit()
        val ft = fm.beginTransaction()
        ft.show(homeFragment)
        ft.commit()
    }
}