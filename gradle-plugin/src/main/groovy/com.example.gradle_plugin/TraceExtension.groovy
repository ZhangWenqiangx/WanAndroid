package com.example.gradle_plugin

/**
 * 自定义的配置项extension
 */
class TraceExtension {
    String output
    boolean open
    String traceConfigFile
    boolean logTraceInfo

    TraceExtension() {
        open = true
        output = ""
        logTraceInfo = false
    }
}