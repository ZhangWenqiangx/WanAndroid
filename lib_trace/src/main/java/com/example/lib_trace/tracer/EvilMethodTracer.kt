package com.example.lib_trace.tracer

import com.example.lib_trace.listeners.LooperObserver
import com.example.lib_trace.core.TraceBeat
import com.example.lib_trace.util.TraceHandlerThread

/**
 *  author : zhang.wenqiang
 *  date : 2021/10/19
 *  description : 慢方法监控 检测每次dispatchMsg期间的超时方法
 */
class EvilMethodTracer : LooperObserver {

    private var indexRecord: TraceBeat.IndexRecord? = null

    init {
        TraceBeat.openTrace = true
        TraceBeat.resetTraceData()
    }

    override fun dispatchBegin(beginNs: Long) {
        indexRecord = TraceBeat.mark("EvilMethodTrace#dispatchBegin")
    }

    override fun dispatchEnd(beginNs: Long, endNs: Long) {
        if (isBlock(endNs - beginNs)) {
            TraceBeat.openTrace = false
            TraceHandlerThread.getDefaultHandler().post(AnalyseTask(indexRecord!!))
        }
    }

    private fun isBlock(duration: Long): Boolean {
        return duration > 16
    }

    private class AnalyseTask(val indexRecord: TraceBeat.IndexRecord) : Runnable {

        override fun run() {
            analyse()
        }

        fun analyse() {
            val data = TraceBeat.collectTraceData(indexRecord)
            TraceBeat.openTrace = true
            System.out.println("------------------------->")
            data.forEach {
                System.out.println(it.toString())
            }
            System.out.println("-------------------------<")
        }
    }
}