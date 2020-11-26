package com.example.android_kt_wandroid

import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common_base.base.BaseApplication

class MainApplication : BaseApplication() {

    companion object {
        lateinit var mContext: Context
        fun getAppContext(): Context = mContext
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this

        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
    }
}
