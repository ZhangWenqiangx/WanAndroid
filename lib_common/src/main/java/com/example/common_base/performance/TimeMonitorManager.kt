package com.example.common_base.performance

import java.util.*

/**
 *  @author : zhang.wenqiang
 *  @date : 2021/5/25
 *  description :采用单例管理各个耗时统计的数据。
 */
object TimeMonitorManager {
    private var mTimeMonitorManager: TimeMonitorManager? = null
    private var mTimeMonitorMap: HashMap<Int, TimeMonitor?>? = null

    fun TimeMonitorManager() {
        mTimeMonitorMap = HashMap()
    }

    /**
     * 初始化打点模块
     */
    fun resetTimeMonitor(id: Int) {
        if (mTimeMonitorMap!![id] != null) {
            mTimeMonitorMap!!.remove(id)
        }
        getTimeMonitor(id).startMonitor()
    }

    /**
     * 获取打点器
     */
    fun getTimeMonitor(id: Int): TimeMonitor {
        var monitor = mTimeMonitorMap!![id]
        if (monitor == null) {
            monitor = TimeMonitor(id)
            mTimeMonitorMap!![id] = monitor
        }
        return monitor
    }
}