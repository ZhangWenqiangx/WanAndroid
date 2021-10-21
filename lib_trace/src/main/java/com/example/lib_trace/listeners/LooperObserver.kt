package com.example.lib_trace.listeners


/**
 *  author : zhang.wenqiang
 *  date : 2021/10/19
 *  description :
 */
interface LooperObserver {

    fun dispatchBegin(beginNs: Long)

    fun dispatchEnd(beginNs: Long, endNs: Long)
}