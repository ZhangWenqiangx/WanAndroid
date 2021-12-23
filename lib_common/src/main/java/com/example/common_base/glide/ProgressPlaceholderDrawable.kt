package com.example.common_base.glide

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.annotation.IntRange
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import java.lang.Integer.min

/**
 *  author : zhang.wenqiang
 *  date : 2021/9/15
 *  description :显示进度
 */
class ProgressPlaceholderDrawable(
    private var context: Context,
    private var placeHolderDrawable: Drawable? = null,
    placeHolderId: Int = 0
) : Drawable() {

    private var mProgress: Int = 0
    private var mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mStartAngle = 270F
    private val mPaintStrokeWidth = getDensity() * 1.5F
    private val mProgressPadding = getDensity() * 3F

    init {
        // get original drawable
        if (placeHolderDrawable == null && placeHolderId != 0) {
            placeHolderDrawable = ContextCompat.getDrawable(context, placeHolderId)
        }

        mPaint.color = Color.GRAY
        mPaint.strokeWidth = mPaintStrokeWidth
    }

    override fun setBounds(bounds: Rect) {
        super.setBounds(bounds)
        placeHolderDrawable?.bounds = bounds
    }

    override fun setBounds(left: Int, top: Int, right: Int, bottom: Int) {
        super.setBounds(left, top, right, bottom)
        placeHolderDrawable?.setBounds(left, top, right, bottom)
    }

    override fun setTint(tintColor: Int) {
        super.setTint(tintColor)
        mPaint.color = tintColor
    }

    fun setProgress(@IntRange(from = 0, to = 100) progress: Int) {
        mProgress = progress
        invalidateSelf()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun draw(canvas: Canvas) {
        // draw original placeholder
        placeHolderDrawable?.draw(canvas)

        // calc center point
        val centerX = (bounds.width() ushr 1).toFloat()
        val centerY = (bounds.height() ushr 1).toFloat()
        var radius = (min(bounds.width(), bounds.height()) ushr 1).toFloat()
        // calc radius
        val dp30 = getDensity() * 30
        if (radius > dp30 * 1.25F) {
            radius = dp30
        } else {
            radius *= 0.6F
        }

        // draw outline circle
        mPaint.style = Paint.Style.STROKE
        canvas.drawCircle(centerX, centerY, radius, mPaint)

        // draw progress
        mPaint.style = Paint.Style.FILL
        val endAngle = (mProgress / 100F) * 360F
        val rect = RectF(
            centerX - radius + mProgressPadding,
            centerY - radius + mProgressPadding,
            centerX + radius - mProgressPadding,
            centerY + radius - mProgressPadding
        )
        canvas.drawArc(rect, mStartAngle, endAngle, true, mPaint)
    }

    override fun setAlpha(alpha: Int) {
        mPaint.alpha = alpha
        invalidateSelf()
    }

    override fun getOpacity() = PixelFormat.TRANSLUCENT

    override fun setColorFilter(colorFilter: ColorFilter?) {
        mPaint.colorFilter = colorFilter
        invalidateSelf()
    }

    private fun getDensity() = context.resources.displayMetrics.density
}