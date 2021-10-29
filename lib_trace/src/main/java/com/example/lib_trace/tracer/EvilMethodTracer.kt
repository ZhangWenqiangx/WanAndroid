package com.example.lib_trace.tracer

import com.example.lib_trace.bean.MethodInfo
import com.example.lib_trace.core.TraceBeat
import com.example.lib_trace.listeners.LogReporter
import com.example.lib_trace.listeners.LooperObserver
import com.example.lib_trace.util.LogUtils
import com.example.lib_trace.util.TraceHandlerThread

/**
 *  author : zhang.wenqiang
 *  date : 2021/10/19
 *  description : 慢方法监控 检测每次dispatchMsg期间的超时方法
 */
class EvilMethodTracer(private val reporter: LogReporter? = null) : LooperObserver {

    companion object {
        val TAG = EvilMethodTracer::class.java.simpleName
        val MARK = "EvilMethodTrace#dispatchBegin"
        val DURATION = 16
    }

    private var indexRecord: TraceBeat.IndexRecord? = null

    init {
        TraceBeat.openTrace = true
        TraceBeat.resetTraceData()
    }

    override fun dispatchBegin(beginNs: Long) {
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
            LogUtils.e("99788/$TAG", stackTraceToString(data))
            reporter?.report(data.toString())
        }

        private fun stackTraceToString(elements: List<MethodInfo>?): String {
            val result = StringBuilder()
            if (null != elements && elements.isNotEmpty()) {
                for (i in elements.indices) {
                    result.append("\t ")
                    result.append(elements[i].toString())
                    result.append("\n")
                }
            }
            return result.toString()
        }
    }
}