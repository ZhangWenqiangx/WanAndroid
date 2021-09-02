package com.example.common_base.widget

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.example.common_base.R
import com.youth.banner.util.BannerUtils

/**
 *  author : zhang.wenqiang
 *  date : 2021/9/1
 *  description :
 */
@RequiresApi(Build.VERSION_CODES.M)
class CircleImageView : androidx.appcompat.widget.AppCompatImageView {
    private var mPaint: Paint = Paint()
    private var mCirPaint: Paint = Paint()
    private var mMatrix: Matrix = Matrix()
    private var bitmapShader: BitmapShader
    private var bitmap: Bitmap
    private var mRadius = 0f
    private var mScale = 0f
    private val mCirPaintWidth = BannerUtils.dp2px(1f)
    private val distance = BannerUtils.dp2px(5f)

    init {
        mPaint.isAntiAlias = true
        mCirPaint.strokeWidth = mCirPaintWidth
        mCirPaint.color = ContextCompat.getColor(context, R.color.colorBlackSecondary)
        mCirPaint.isAntiAlias = true
        mCirPaint.style = Paint.Style.STROKE

        bitmap = drawableToBitmap(drawable)
        bitmapShader = BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
    }

    constructor(context: Context?) : super(context!!)
    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context!!,
        attrs,
        defStyleAttr
    )

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size: Int = measuredWidth.coerceAtMost(measuredHeight)
        mRadius = size / 2f
        setMeasuredDimension(size, size)
    }

    override fun onDraw(canvas: Canvas) {
        mScale = mRadius * 2.0f / bitmap.height.coerceAtMost(bitmap.width)
        mMatrix.setScale(mScale, mScale)
        bitmapShader.setLocalMatrix(mMatrix)
        mPaint.shader = bitmapShader
        canvas.drawCircle(mRadius, mRadius, mRadius - distance, mPaint)
        canvas.drawCircle(mRadius, mRadius, mRadius - mCirPaintWidth, mCirPaint)
    }

    private fun drawableToBitmap(drawable: Drawable): Bitmap {
        if (drawable is BitmapDrawable) {
            val bd: BitmapDrawable = drawable
            return bd.bitmap
        }
        val w: Int = drawable.intrinsicWidth
        val h: Int = drawable.intrinsicHeight
        val bitmap: Bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        drawable.setBounds(0, 0, w, h)
        drawable.draw(canvas)
        return bitmap
    }
}