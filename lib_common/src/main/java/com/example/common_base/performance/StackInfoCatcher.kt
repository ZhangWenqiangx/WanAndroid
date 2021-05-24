package com.example.common_base.performance

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Looper
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager

/**
 *  @author : zhang.wenqiang
 *  @date : 2021/5/24
 *  description :
 */
class StackInfoCatcher(val mContext: Context) : Thread() {
    private var stop = false
    private var mLastTime: Long = 0
    private val mList: MutableList<StackTraceInfo> = ArrayList(SIZE)
    private val mBroadcastReceiver: BroadcastReceiver

    private fun getInfoByTime(endTime: Long, startTime: Long): StackTraceInfo? {
        for (info in mList) {
            if (info.mTime in startTime..endTime) {
                return info
            }
        }
        return null
    }

    fun stopTrace() {
        stop = true
        LocalBroadcastManager.getInstance(mContext).unregisterReceiver(mBroadcastReceiver)
    }

    override fun run() {
        super.run()
        while (!stop) {
            val currentTime = System.currentTimeMillis()
            if (currentTime - mLastTime > 500) {
                mLastTime = System.currentTimeMillis()
                val info = StackTraceInfo()
                info.mTime = mLastTime
                val stackTrace = Looper.getMainLooper().thread.stackTrace
                info.mLog = stackTraceToString(stackTrace)
                mList.add(info)
            }
            if (mList.size > SIZE) {
                mList.removeAt(0)
            }
        }
    }

    private fun stackTraceToString(elements: Array<StackTraceElement>?): String {
        val result = StringBuilder()
        if (null != elements && elements.isNotEmpty()) {
            for (i in elements.indices) {
                result.append("\tat ")
                result.append(elements[i].toString())
                result.append("\n")
            }
        }
        return result.toString()
    }

    private inner class StackTraceInfo {
        var mTime: Long = 0
        var mLog: String? = null
    }

    companion object {
        private const val TAG = "--99788---Block-----"
        private const val SIZE = 1024
    }

    init {
        val manager = LocalBroadcastManager.getInstance(mContext)
        mBroadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val endTime = intent.getLongExtra("finish", 0)
                val startTime = intent.getLongExtra("start", 0)
                val info = getInfoByTime(endTime, startTime)
                if (null != info) {
                    Log.e(TAG, "find block line" + (endTime - startTime))
                    Log.e(TAG, info.mLog.toString())
                } else {
                    Log.e(TAG, "no block line find")
                }
            }
        }
        manager.registerReceiver(mBroadcastReceiver, IntentFilter("ACTION_BLOCK"))
    }
}