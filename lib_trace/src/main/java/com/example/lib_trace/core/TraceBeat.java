package com.example.lib_trace.core;

import android.os.Build;
import android.os.Looper;
import android.os.Trace;

import androidx.annotation.RequiresApi;

import com.example.lib_trace.bean.MethodInfo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * author : zhang.wenqiang
 * date : 2021/10/13
 * description :
 * 1.method in  invoke start record method info(name,curtime,type,mainThread)
 * 2.method out invoke end record method info
 * 3.start collect sign flag true
 * 4.end collect sign flag false and dump List<Entity> methodList data
 * todo - always collect methodList and index a flag when start,at end invoke get the method over a period of time
 * todo 1.# 2.# 3.帧率检测 4.# 5.慢方法上传 6.set/get/return ignore
 */
public class TraceBeat {

    public static boolean openTrace = false;
    private static int sIndex = 0;
    private static final List<Entity> methodList = new LinkedList<>();

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static void start(String name) {
        if (isOpenTraceMethod()) {
            Trace.beginSection(name);
            synchronized (methodList) {
                methodList.add(new Entity(name, System.currentTimeMillis(), true, isInMainThread()));
            }
            ++sIndex;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    public static void end(String name) {
        if (isOpenTraceMethod()) {
            Trace.endSection();
            synchronized (methodList) {
                methodList.add(new Entity(name, System.currentTimeMillis(), false, isInMainThread()));
            }
            ++sIndex;
        }
    }

    private static IndexRecord sIndexRecordHead = null;

    public static IndexRecord mark(String source) {
        sIndexRecordHead = new IndexRecord(sIndex - 1);
        sIndexRecordHead.source = source;
        return sIndexRecordHead;
    }

    public static void resetTraceData() {
        synchronized (methodList) {
            methodList.clear();
        }
    }

    public static List<MethodInfo> collectTraceData(IndexRecord startIndex) {
        return collectTraceData(startIndex.index, sIndex - 1);
    }

    public static List<MethodInfo> collectTraceData(int start, int size) {
        synchronized (methodList) {
            List<MethodInfo> resultList = new ArrayList();
            for (int i = start; i < size; i++) {
                Entity startEntity = methodList.get(i);
                if (!startEntity.isStart) {
                    continue;
                }
                startEntity.pos = i;
                Entity endEntity = findEndEntity(startEntity.name, i + 1);
                if (endEntity != null && endEntity.time - startEntity.time > 0) {
                    MethodInfo methodInfo = createMethodInfo(startEntity, endEntity);
                    resultList.add(methodInfo);
                }
            }
            return resultList;
        }
    }

    private static Entity findEndEntity(String name, int startPos) {
        int sameCount = 1;
        for (int i = startPos; i < methodList.size(); i++) {
            Entity endEntity = methodList.get(i);
            if (endEntity.name.equals(name)) {
                if (endEntity.isStart) {
                    sameCount++;
                } else {
                    sameCount--;
                }
                if (sameCount == 0 && !endEntity.isStart) {
                    endEntity.pos = i;
                    return endEntity;
                }
            }
        }
        return null;
    }

    private static MethodInfo createMethodInfo(Entity startEntity, Entity endEntity) {
        return new MethodInfo(startEntity.name,
                endEntity.time - startEntity.time,
                startEntity.pos,
                endEntity.pos,
                startEntity.isMainThread);
    }

    private static boolean isInMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static boolean isOpenTraceMethod() {
        return openTrace;
    }

    public static final class Entity {
        public String name;
        public Long time;
        public boolean isStart;
        public int pos;
        public boolean isMainThread;

        public Entity(String name, Long time, boolean isStart, boolean isMainThread) {
            this.name = name;
            this.time = time;
            this.isStart = isStart;
            this.isMainThread = isMainThread;
        }
    }

    public static final class IndexRecord {
        public IndexRecord(int index) {
            this.index = index;
        }

        public int index;
        public String source;

        @Override
        public String toString() {
            return "index:" + index + ",\t" + " source:" + source;
        }
    }
}
