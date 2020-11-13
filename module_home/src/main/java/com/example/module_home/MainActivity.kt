package com.example.module_home

import androidx.fragment.app.FragmentManager
import com.example.common_base.base.BaseActivity

class MainActivity   : BaseActivity() {
    private lateinit var fm: androidx.fragment.app.FragmentManager

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun initView() {
        fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        val homeFragment = HomeFragment()
        transaction.add(R.id.fl_content, homeFragment)
        transaction.commit()
        val ft = fm.beginTransaction()
        ft.show(homeFragment)
        ft.commit()
    }

    override fun initData() {

    }
}