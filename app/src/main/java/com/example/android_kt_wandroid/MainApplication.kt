package com.example.android_kt_wandroid

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter

class MainApplication : Application() {

    companion object {
        lateinit var mContext: Context
        fun getAppContext(): Context = mContext
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this

        ARouter.openLog()     // 打印日志
        ARouter.openDebug()   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)

        ARouter.init(this) // 尽可能早，推荐在Application中初始化
    }
}
