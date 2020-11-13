package com.example.module_usercenter.activity

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common_base.constants.AConstance

/**
 * Description: splashActivity关于lifecyce 小试牛刀
 */
class SplashObserver(var activity: SplashActivity) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onActivityResume(){
        ARouter.getInstance().build(AConstance.ACTIVITY_URL_LOGIN).navigation()
        activity.finish()
    }
}