package com.example.lib_trace.tracer

import com.example.lib_trace.core.TraceBeat
import com.example.lib_trace.listeners.LogReporter
import com.example.lib_trace.listeners.LooperObserver
import com.example.lib_trace.util.LogUtils
import com.example.lib_trace.util.TraceHandlerThread
import com.example.lib_trace.util.Utils.stackTraceToString

/**
 *  author : zhang.wenqiang
 *  date : 2021/10/19
 *  description : 慢方法监控
 *  1. begin record index method
 *  2. end check cost
 *  3. collect trace data by index
 */
class EvilMethodTracer(private val reporter: LogReporter? = null) : LooperObserver {

    companion object {
        val TAG = EvilMethodTracer::class.java.simpleName
        val MARK = "EvilMethodTrace#dispatchBegin"
        val DURATION = 500
    }

    private var indexRecord: TraceBeat.IndexRecord? = null

    init {
        TraceBeat.openTrace = true
        TraceBeat.resetTraceData()
    }

    override fun dispatchBegin(beginNs: Long, first: Long) {
        TraceBeat.resetTraceData()
        TraceBeat.openTrace = true
        indexRecord = TraceBeat.mark(MARK)
    }

    override fun dispatchEnd(beginNs: Long, endNs: Long) {
        if (isBlock(endNs - beginNs)) {
            TraceBeat.openTrace = false
            TraceHandlerThread.getDefaultHandler().post(AnalyseTask(indexRecord!!, reporter))
        }
    }

    private fun isBlock(duration: Long): Boolean {
        return duration > DURATION
    }

    private class AnalyseTask(
        val indexRecord: TraceBeat.IndexRecord,
        val reporter: LogReporter? = null
    ) : Runnable {

        override fun run() {
            analyse()
        }

        fun analyse() {
            val data = TraceBeat.collectTraceData(indexRecord)
            TraceBeat.openTrace = true
            LogUtils.e(TAG, stackTraceToString(data))
            reporter?.report(data.toString())
        }
    }
}