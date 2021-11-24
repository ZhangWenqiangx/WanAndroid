package com.example.lib_trace.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

import java.util.HashSet;
import java.util.Iterator;

public class TraceHandlerThread {
    private static final String TAG = "Trace.HandlerThread";

    public static final String MATRIX_THREAD_NAME = "default_trace_thread";

    private static volatile HandlerThread defaultHandlerThread;
    private static volatile Handler defaultHandler;
    private static volatile Handler defaultMainHandler = new Handler(Looper.getMainLooper());
    private static HashSet<HandlerThread> handlerThreads = new HashSet<>();

    public static Handler getDefaultMainHandler() {
        return defaultMainHandler;
    }

    public static HandlerThread getDefaultHandlerThread() {

        synchronized (TraceHandlerThread.class) {
            if (null == defaultHandlerThread) {
                defaultHandlerThread = new HandlerThread(MATRIX_THREAD_NAME);
                defaultHandlerThread.start();
                defaultHandler = new Handler(defaultHandlerThread.getLooper());
            }
            return defaultHandlerThread;
        }
    }

    public static Handler getDefaultHandler() {
        if (defaultHandler == null) {
            getDefaultHandlerThread();
        }
        return defaultHandler;
    }

    public static HandlerThread getNewHandlerThread(String name) {
        return getNewHandlerThread(name, 5);
    }

    public static HandlerThread getNewHandlerThread(String name, int priority) {
        for (Iterator<HandlerThread> i = handlerThreads.iterator(); i.hasNext(); ) {
            HandlerThread element = i.next();
            if (!element.isAlive()) {
                i.remove();
            }
        }
        HandlerThread handlerThread = new HandlerThread(name);
        handlerThread.setPriority(priority);
        handlerThread.start();
        handlerThreads.add(handlerThread);
        return handlerThread;
    }
}
