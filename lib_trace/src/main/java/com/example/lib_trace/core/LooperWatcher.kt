package com.example.lib_trace.core

import android.util.Printer
import com.example.lib_trace.listeners.LooperObserver
import java.util.*

/**
 *  @author : zhang.wenqiang
 *  @date : 2021/5/24
 */
class LooperWatcher : Printer {
    private var mFinishTimeMillis: Long = 0
    private var mStartTimeMillis: Long = 0
    private var isValid = false
    private val observers: HashSet<LooperObserver> = HashSet<LooperObserver>()

    override fun println(x: String) {
        isValid = x[0] == '>' || x[0] == '<'
        if (isValid) {
            dispatch(x[0] == '>', x)
        }
    }

    private fun dispatch(isBegin: Boolean, log: String) {
        if (isBegin) {
            mStartTimeMillis = System.currentTimeMillis()
            for (observer in observers) {
                observer.dispatchBegin(mStartTimeMillis)
            }
        } else {
            mFinishTimeMillis = System.currentTimeMillis()
            for (observer in observers) {
                observer.dispatchEnd(mStartTimeMillis, mFinishTimeMillis)
            }
        }
    }

    fun registerObserver(observer: LooperObserver) {
        observers.add(observer)
    }
}