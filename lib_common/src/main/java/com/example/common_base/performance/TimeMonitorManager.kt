package com.example.common_base.performance

import android.content.Context
import android.os.Looper
import java.util.*

const val TIME_MONITOR_APP_ONCREATE = 1

/**
 *  @author : zhang.wenqiang
 *  @date : 2021/5/25
 *  description :采用单例管理各个耗时统计的数据。
 */
object TimeMonitorManager {
    private var mTimeMonitorMap: HashMap<Int, TimeMonitor?> = HashMap()

    /**
     * 初始化对应id的打点模块
     * @param id event id
     */
    fun resetTimeMonitor(id: Int) {
        if (mTimeMonitorMap[id] != null) {
            mTimeMonitorMap.remove(id)
        }
        getTimeMonitor(id).startMonitor()
    }

    /**
     * 通过事件的id获取打点器
     * @param id event id
     */
    fun getTimeMonitor(id: Int): TimeMonitor {
        var monitor = mTimeMonitorMap[id]
        if (monitor == null) {
            monitor = TimeMonitor(id)
            mTimeMonitorMap[id] = monitor
        }
        return monitor
    }

    fun initBlock(context: Context) {
        Looper.getMainLooper().setMessageLogging(BlockPrinter(context))
    }

    fun quitBlock() {
        Looper.getMainLooper().setMessageLogging(null)
    }
}