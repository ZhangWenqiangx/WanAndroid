package com.example.lib_trace

import android.app.Application
import android.os.Looper
import com.example.lib_trace.core.BlockPrinter
import com.example.lib_trace.tracer.EvilMethodTracer

/**
 *  author : zhang.wenqiang
 *  date : 2021/10/19
 *  description :
 */
class Trace {
    var blockPrinter: BlockPrinter? = null

    fun init(app: Application) {
        blockPrinter = BlockPrinter()

        blockPrinter!!.registerObserver(EvilMethodTracer())

        Looper.getMainLooper().setMessageLogging(blockPrinter)
    }
}