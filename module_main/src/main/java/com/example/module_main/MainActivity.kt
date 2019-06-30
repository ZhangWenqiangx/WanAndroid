package com.example.module_main

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common_base.AConstance
import com.example.common_base.base.BaseActivity

@Route(path = AConstance.ACTIVITY_URL_MAIN)
class MainActivity : BaseActivity() {
    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView() {
    }

    override fun initData() {
    }
}
