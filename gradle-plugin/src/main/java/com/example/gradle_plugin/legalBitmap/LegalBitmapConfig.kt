package com.example.gradle_plugin.legalBitmap

import com.example.gradle_plugin.trace.Config

/**
 * @Author: leavesCZY
 * @Desc:
 */
data class LegalBitmapConfig(
    private val monitorImageViewClass: String = "com.example.lib_trace.tracer.LegalBitmapTracer",
): Config() {

    val formatMonitorImageViewClass: String
        get() = monitorImageViewClass.replace(".", "/")

}