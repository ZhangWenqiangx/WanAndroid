package com.example.common_base.performance

import android.util.Log
import java.util.*

/**
 * @author : zhang.wenqiang
 * @date : 2021/5/25
 * description :耗时监视器对象，记录整个过程的耗时情况，可以用在很多需要统计的地方，比如Activity的启动耗时和Fragment的启动耗时。
 */
class TimeMonitor(mMonitorId: Int) {
    private val TAG = TimeMonitor::class.java.simpleName
    var monitorId = -1

    // 保存一个耗时统计模块的各种耗时，tag对应某一个阶段的时间
    val timeTags = HashMap<String, Long?>()
    private var mStartTime: Long = 0

    fun startMonitor() {
        // 每次重新启动都把前面的数据清除，避免统计错误的数据
        if (timeTags.size > 0) {
            timeTags.clear()
        }
        mStartTime = System.currentTimeMillis()
    }

    /**
     * 每打一次点，记录某个tag的耗时
     */
    fun recordingTimeTag(tag: String) {
        // 若保存过相同的tag，先清除
        if (timeTags[tag] != null) {
            timeTags.remove(tag)
        }
        val time = System.currentTimeMillis() - mStartTime
        Log.d(TAG, "$tag: $time")
        timeTags[tag] = time
    }

    fun end(tag: String, writeLog: Boolean) {
        recordingTimeTag(tag)
        end(writeLog)
    }

    fun end(writeLog: Boolean) {
        if (writeLog) {
            //输出日志or上报
            for ((key, value) in timeTags) {
                Log.d(TAG, "event： $key --time--> $value")
            }
        }
    }

    init {
        Log.d(TAG, "init TimeMonitor id: $mMonitorId")
        monitorId = mMonitorId
    }
}