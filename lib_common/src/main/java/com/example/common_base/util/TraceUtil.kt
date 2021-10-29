package com.example.common_base.util

import android.os.Trace

/**
 *  author : zhang.wenqiang
 *  date : 2021/10/29
 *  description :
 */
object TraceUtil {
    fun i(name: String) {
        Trace.beginSection(name)
    }

    fun o() {
        Trace.endSection()
    }
}