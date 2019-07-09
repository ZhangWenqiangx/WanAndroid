package com.example.module_usercenter.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common_base.constants.AConstance
import com.example.common_base.base.BaseActivity
import com.example.module_usercenter.R

@Route(path = AConstance.ACTIVITY_URL_SPLASH)
class SplashActivity : BaseActivity() {
    override fun getLayoutResId(): Int = R.layout.activity_splash

    override fun initView() {}

    override fun initData() { lifecycle.addObserver(SplashObserver(this)) }
}
