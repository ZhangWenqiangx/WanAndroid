package com.example.common_base.widget

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.MotionEvent.*
import android.view.View
import android.widget.ScrollView
import com.example.common_base.R

/**
 * Description:一个可以伴随手势下拉放大view的自定义view
 */
class ZoomScrollView(context: Context?, attrs: AttributeSet?) : ScrollView(context, attrs) {

    var zoomMax: Int = 0                            //放大的目标控件的最大距离
    var downY: Float = 0f
    var scaleRadio = 0.5f
    var zoomViewWidth = 0
    var zoomViewHeight = 0
    var scaling = false                             //当前是否缩放状态

    private lateinit var zoomView: View            //被放大的控件

    init {                                          //从xml布局中拿取属性
        val array = context?.obtainStyledAttributes(attrs, R.styleable.ZoomScrollView)
        zoomMax = array?.getDimensionPixelSize(R.styleable.ZoomScrollView_zoomMax, 20)!!
        array.recycle()
        overScrollMode = View.OVER_SCROLL_NEVER         //设置滑动的模式
    }

    /**
     * 注入控件
     */
    fun setZoomView(targetView: View) {
        zoomView = targetView
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {

        if (zoomViewWidth == 0 || zoomViewHeight == 0) {
            zoomViewHeight = zoomView.measuredHeight
            zoomViewWidth = zoomView.measuredWidth
        }
        when (ev?.action) {
            ACTION_DOWN -> true
            ACTION_MOVE -> {                    //记录按下的y 并且记录下滑的距离
                if (!scaling) if (scrollY == 0) downY = ev.y

                val distance = (ev.y - downY) * scaleRadio
                when {
                    distance < 0 -> false
                    distance > zoomMax -> false
                }
                scaling = true
                startZoom(distance)
                return true
            }
            ACTION_UP ->                        //reset the state of zoomView -> picture Back
                resetZoomView()
        }

        return super.onTouchEvent(ev)
    }

    /**
     * 通过动画修改view的属性
     */
    private fun resetZoomView() {
        scaling = false
        val distance = zoomView.measuredWidth - zoomViewWidth           //变化的属性 eg: 0-3
        val valueAnimator = ValueAnimator.ofFloat(distance.toFloat(), 0f)
            .setDuration(300)                                               //this function always use by every change
        valueAnimator.addUpdateListener { animation -> startZoom(animation?.animatedValue as Float) }
        valueAnimator.start()
    }

    /**
     * 开始缩放  改变控件的layoutParams
     */
    private fun startZoom(distance: Float) {
        if (zoomViewHeight == 0 || zoomViewHeight == 0) return

        val layoutParams = zoomView.layoutParams
        layoutParams.width = zoomViewWidth + distance.toInt()
        layoutParams.height = ((layoutParams.width) / zoomViewWidth) * zoomViewHeight

        zoomView.layoutParams = layoutParams
    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
        onScrollListener?.let {
            it.onScrollChange(this, l, t, oldl, oldt)
        }
    }

    protected fun isReadyForPullStart(): Boolean {
        return scrollY == 0
    }

    private var onScrollListener: OnScrollListener? = null

    interface OnScrollListener {
        fun onScrollChange(v: View, scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int)
    }

    fun setOnScrollListener(listener: OnScrollListener) {
        this.onScrollListener = listener
    }
}

