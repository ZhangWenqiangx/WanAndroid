package com.example.common_base.performance

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.util.Printer
import androidx.localbroadcastmanager.content.LocalBroadcastManager

/**
 *  @author : zhang.wenqiang
 *  @date : 2021/5/24
 *  description :检测 mainlooper 是否间隔大于16后处理事件
 */
class BlockPrinter constructor(context: Context) : Printer {
    private var mFinishTimeMillis: Long = 0
    private var mStartTimeMillis: Long = 0
    private val stackInfoCatcher: StackInfoCatcher = StackInfoCatcher(context)
    private val mContext: Context = context

    override fun println(x: String) {
        when (isStart(x)) {
            START -> mStartTimeMillis = System.currentTimeMillis()
            FINISH -> {
                mFinishTimeMillis = System.currentTimeMillis()
                val duration = mFinishTimeMillis - mStartTimeMillis
                if (isBlock(duration)) {
                    val manager = LocalBroadcastManager.getInstance(mContext)
                    val intent = Intent("ACTION_BLOCK")
                    intent.putExtra("start", mStartTimeMillis)
                    intent.putExtra("finish", mFinishTimeMillis)
                    manager.sendBroadcast(intent)
                }
            }
            else -> {
            }
        }
    }

    fun isStart(x: String): Int {
        if (!TextUtils.isEmpty(x)) {
            if (x.startsWith(">>>>> Dispatching to Handler")) {
                return START
            } else if (x.startsWith("<<<<< Finished to Handler")) {
                return FINISH
            }
        }
        return UNKONW
    }

    private fun isBlock(duration: Long): Boolean {
        return duration > 16
    }

    companion object {
        private const val START = 0
        private const val FINISH = 1
        private const val UNKONW = 2
    }

    init {
        stackInfoCatcher.start()
    }
}