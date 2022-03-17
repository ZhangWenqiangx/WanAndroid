package com.example.lib_trace.tracer

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Looper
import android.os.MessageQueue
import android.util.AttributeSet
import com.example.lib_trace.util.LogUtils

/**
 *  author : zhang.wenqiang
 *  date : 2022/3/17
 *  description :
 */
@SuppressLint("AppCompatCustomView")
open class LegalBitmapTracer @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : android.widget.ImageView(context, attrs, defStyleAttr), MessageQueue.IdleHandler {

    companion object {
        private const val MAX_ALARM_IMAGE_SIZE = 1024
    }

    override fun setImageDrawable(drawable: Drawable?) {
        super.setImageDrawable(drawable)
        monitor()
    }

    override fun setImageBitmap(bm: Bitmap?) {
        super.setImageBitmap(bm)
        monitor()
    }

    override fun setImageResource(resId: Int) {
        super.setImageResource(resId)
        monitor()
    }

    override fun setBackgroundResource(resid: Int) {
        super.setBackgroundResource(resid)
        monitor()
    }

    override fun setBackground(background: Drawable?) {
        super.setBackground(background)
        monitor()
    }

    private fun monitor() {
        Looper.myQueue().removeIdleHandler(this)
        Looper.myQueue().addIdleHandler(this)
    }

    override fun queueIdle(): Boolean {
        checkDrawable()
        return false
    }

    private fun checkDrawable() {
        val mDrawable = drawable ?: return

        val drawableWidth = mDrawable.intrinsicWidth
        val drawableHeight = mDrawable.intrinsicHeight
        val viewWidth = measuredWidth
        val viewHeight = measuredHeight
        val imageSize = calculateImageSize(mDrawable)

        LogUtils.d(
            javaClass.simpleName,
            "图片info: drawable{ %s x %s },view{ %s x %s },size{%s}",
            drawableWidth,
            drawableHeight,
            viewWidth,
            viewHeight,
            imageSize
        )

        if (imageSize > MAX_ALARM_IMAGE_SIZE) {
            LogUtils.e(javaClass.simpleName, "图片大小超标: %s", imageSize)
        }
        if (drawableWidth > viewWidth || drawableHeight > viewHeight) {
            LogUtils.e(
                javaClass.simpleName,
                "图片尺寸超标: drawable{ %s x %s },view{ %s x %s }",
                drawableWidth,
                drawableHeight,
                viewWidth,
                viewHeight
            )
        }
    }

    private fun calculateImageSize(drawable: Drawable): Int {
        return when (drawable) {
            is BitmapDrawable -> {
                drawable.bitmap.byteCount
            }
            else -> {
                0
            }
        }
    }
}