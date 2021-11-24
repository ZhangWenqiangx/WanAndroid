package com.example.lib_trace

import android.app.Application
import android.os.Looper
import com.example.lib_trace.core.LooperWatcher
import com.example.lib_trace.listeners.LogReporter
import com.example.lib_trace.listeners.LooperObserver
import com.example.lib_trace.tracer.AnrTracer
import com.example.lib_trace.tracer.EvilMethodTracer

/**
 *  author : zhang.wenqiang
 *  date : 2021/10/19
 *  description :
 */
class Trace(builder: Builder) {
    val app:Application = builder.application
    private var observers: List<LooperObserver> = builder.observers

    private val looperWatcher: LooperWatcher = LooperWatcher()

    fun start() {
        observers.forEach {
            looperWatcher.registerObserver(it)
        }

        Looper.getMainLooper().setMessageLogging(looperWatcher)
    }

    class Builder(app: Application?) {
        val application: Application
        var logReporter: LogReporter? = null
        var observers: MutableList<LooperObserver> = mutableListOf()

        fun logReporter(logReporter: LogReporter?): Builder {
            this.logReporter = logReporter
            return this
        }

        fun enableEvil(enable: Boolean): Builder {
            if (enable)
                observers.add(EvilMethodTracer(logReporter))
            return this
        }

        fun enableAnr(enable: Boolean): Builder {
            if (enable)
                observers.add(AnrTracer(logReporter))
            return this
        }

        fun addObserver(observer: LooperObserver): Builder {
            observers.add(observer)
            return this
        }

        fun build(): Trace {
            return Trace(this)
        }

        init {
            if (app == null) {
                throw RuntimeException("Trace init, application is null")
            }
            application = app
        }
    }
}