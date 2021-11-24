package com.example.lib_trace.util;

import android.os.Looper;

import com.example.lib_trace.bean.MethodInfo;

import java.util.List;

public class Utils {

    public static String getStack() {
        StackTraceElement[] trace = new Throwable().getStackTrace();
        return getStack(trace);
    }

    public static String getStack(StackTraceElement[] trace) {
        return getStack(trace, "", -1);
    }

    public static String getStack(StackTraceElement[] trace, String preFixStr, int limit) {
        if ((trace == null) || (trace.length < 3)) {
            return "";
        }
        if (limit < 0) {
            limit = Integer.MAX_VALUE;
        }
        StringBuilder t = new StringBuilder(" \n");
        for (int i = 3; i < trace.length - 3 && i < limit; i++) {
            t.append(preFixStr);
            t.append("at ");
            t.append(trace[i].getClassName());
            t.append(":");
            t.append(trace[i].getMethodName());
            t.append("(" + trace[i].getLineNumber() + ")");
            t.append("\n");

        }
        return t.toString();
    }

    public static String getWholeStack(StackTraceElement[] trace, String preFixStr) {
        if ((trace == null) || (trace.length < 3)) {
            return "";
        }

        StringBuilder t = new StringBuilder(" \n");
        for (int i = 0; i < trace.length; i++) {
            t.append(preFixStr);
            t.append("at ");
            t.append(trace[i].getClassName());
            t.append(":");
            t.append(trace[i].getMethodName());
            t.append("(" + trace[i].getLineNumber() + ")");
            t.append("\n");

        }
        return t.toString();
    }

    public static String getWholeStack(StackTraceElement[] trace) {
        StringBuilder stackTrace = new StringBuilder();
        for (StackTraceElement stackTraceElement : trace) {
            stackTrace.append(stackTraceElement.toString()).append("\n");
        }
        return stackTrace.toString();
    }

    public static String getMainThreadJavaStackTrace() {
        StringBuilder stackTrace = new StringBuilder();
        for (StackTraceElement stackTraceElement : Looper.getMainLooper().getThread().getStackTrace()) {
            stackTrace.append(stackTraceElement.toString()).append("\n");
        }
        return stackTrace.toString();
    }

    public static String calculateCpuUsage(long threadMs, long ms) {
        if (threadMs <= 0) {
            return ms > 1000 ? "0%" : "100%";
        }

        if (threadMs >= ms) {
            return "100%";
        }

        return String.format("%.2f", 1.f * threadMs / ms * 100) + "%";
    }

    public static boolean isEmpty(String str) {
        return null == str || str.equals("");
    }

    public static String formatTime(final long timestamp) {
        return new java.text.SimpleDateFormat("[yy-MM-dd HH:mm:ss]").format(new java.util.Date(timestamp));
    }

    public static String stackTraceToString(List<MethodInfo> elements) {
        StringBuilder result = new StringBuilder();
        if (null != elements && !elements.isEmpty()) {
            for (MethodInfo info : elements) {
                result.append("\t ");
                result.append(info.toString());
                result.append("\n");
            }
        }
        return result.toString();
    }
}
