package com.example.module_video.debug

import com.example.common_base.base.BaseActivity
import com.example.module_video.R
import com.example.module_video.VideoFragment

class MainActivity : BaseActivity() {

    override fun getLayoutResId(): Int =
        R.layout.activity_main

    override fun initView() {}

    override fun initData() {
        val homeFragment = VideoFragment()
        supportFragmentManager.beginTransaction().apply {
            add(R.id.fl_content, homeFragment)
            show(homeFragment)
            commit()
        }
    }
}