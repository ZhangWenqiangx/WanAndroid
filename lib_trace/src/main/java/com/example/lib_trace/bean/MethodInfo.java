package com.example.lib_trace.bean;

/**
 * author : zhang.wenqiang
 * date : 2021/10/13
 * description :
 */
public class MethodInfo {
    private String name;
    private long costTime;
    private int startPos;
    private int endPos;
    private boolean isMainThread;

    public MethodInfo(String name, long costTime, int startPos, int endPos, boolean isMainThread) {
        this.name = name;
        this.costTime = costTime;
        this.startPos = startPos;
        this.endPos = endPos;
        this.isMainThread = isMainThread;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCostTime() {
        return costTime;
    }

    public void setCostTime(long costTime) {
        this.costTime = costTime;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public int getEndPos() {
        return endPos;
    }

    public void setEndPos(int endPos) {
        this.endPos = endPos;
    }

    public boolean isMainThread() {
        return isMainThread;
    }

    public void setMainThread(boolean mainThread) {
        isMainThread = mainThread;
    }

    @Override
    public String toString() {
        return "MethodInfo{" +
                "name='" + name + '\'' +
                ", costTime=" + costTime +
                ", startPos=" + startPos +
                ", endPos=" + endPos +
                ", isMainThread=" + isMainThread +
                '}';
    }
}
