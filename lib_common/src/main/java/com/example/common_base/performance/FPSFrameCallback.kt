package com.example.common_base.performance

import android.util.Log
import android.view.Choreographer

/**
 *  author : zhang.wenqiang
 *  date : 2021/10/26
 *  description :
 */
class FPSFrameCallback(lastFrameTimeNanos: Long) : Choreographer.FrameCallback {
    private var mLastFrameTimeNanos: Long = 0
    private val mFrameIntervalNanos: Long

    override fun doFrame(frameTimeNanos: Long) {
        if (mLastFrameTimeNanos == 0L) {
            mLastFrameTimeNanos = frameTimeNanos
        }
        val jitterNanos = frameTimeNanos - mLastFrameTimeNanos
        if (jitterNanos >= mFrameIntervalNanos) {
            val skippedFrames = jitterNanos / mFrameIntervalNanos
            if (skippedFrames > 30) {
                Log.i(
                    TAG, "Skipped " + skippedFrames + " frames!  "
                            + "The application may be doing too much work on its main thread."
                )
            }
        }
        mLastFrameTimeNanos = frameTimeNanos
        Choreographer.getInstance().postFrameCallback(this)
    }

    companion object {
        private const val TAG = "FPS_TEST"
    }

    init {
        mLastFrameTimeNanos = lastFrameTimeNanos
        mFrameIntervalNanos = (1000000000 / 60.0).toLong()
    }
}