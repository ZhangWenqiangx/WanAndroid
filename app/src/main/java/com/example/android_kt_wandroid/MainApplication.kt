package com.example.android_kt_wandroid

import com.alibaba.android.arouter.launcher.ARouter
import com.example.common_base.base.BaseApplication

class MainApplication : BaseApplication() {
    override fun onCreate() {
        super.onCreate()

        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
    }
}
