package com.example.android_kt_wandroid

import android.app.Application
import android.content.Context

class MainApplication : Application(){

    companion object{
        lateinit var mContext : Context
        fun getAppContext() : Context{
            return mContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
    }
}
