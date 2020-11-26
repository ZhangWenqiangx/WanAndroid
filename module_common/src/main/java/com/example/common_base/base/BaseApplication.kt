package com.example.common_base.base

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import dagger.hilt.android.HiltAndroidApp

/**
 * Description:
 */
@HiltAndroidApp
open class BaseApplication : Application() {

    companion object {
        lateinit var sApplication: Application
    }

    override fun onCreate() {
        super.onCreate()
        sApplication = this
        initArouter()
    }

    private fun initArouter() {
        if (isDebug()) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }

    private fun isDebug(): Boolean = true
}