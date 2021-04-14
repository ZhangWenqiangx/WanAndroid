package com.example.common_base.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.example.common_base.util.ExtensionsKt;

/**
 * @author : zhang.wenqiang
 * @date : 2021/4/9
 * description :
 */
public class HeadZoomScrollView extends ScrollView {

    /**
     * 缩放view
     */
    private View mZoomView;
    /**
     * 下滑view
     */
    private View mScrollView;
    private int mZoomViewWidth;
    private int mZoomViewHeight;
    /**
     * 第一次按下的位置
     */
    private float firstPosition;
    /**
     * 是否正在缩放
     */
    private boolean isScrolling;
    /**
     * 缩放系数，缩放系数越大，变化的越大
     */
    private float mScrollRate = 0.3f;
    /**
     * 回调系数，越大，回调越慢
     */
    private float mReplyRate = 0.5f;

    public HeadZoomScrollView(Context context) {
        super(context);
    }

    public HeadZoomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HeadZoomScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setScrollRate(float mScrollRate) {
        this.mScrollRate = mScrollRate;
    }

    public void setReplyRate(float mReplyRate) {
        this.mReplyRate = mReplyRate;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
    }

    private void init() {
        setOverScrollMode(OVER_SCROLL_NEVER);
        if (getChildAt(0) != null) {
            ViewGroup vg = (ViewGroup) getChildAt(0);
            if (vg.getChildAt(0) != null) {
                mZoomView = vg.getChildAt(0);
            }
            if (vg.getChildAt(1) != null) {
                mScrollView = vg.getChildAt(1);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (mZoomViewWidth <= 0 || mZoomViewHeight <= 0) {
            mZoomViewWidth = mZoomView.getMeasuredWidth();
            mZoomViewHeight = mZoomView.getMeasuredHeight();
        }
        switch (ev.getAction()) {
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                //手指离开后恢复图片
                isScrolling = false;
                replyImage();
                break;
            case MotionEvent.ACTION_MOVE:
                if (!isScrolling) {
                    if (getScrollY() == 0) {
                        firstPosition = ev.getY();
                        // 滚动到顶部时记录位置，否则正常返回
                    } else {
                        break;
                    }
                }
                int distance = (int) ((ev.getY() - firstPosition) * mScrollRate);
                // 滚动距离乘以一个系数
                if (distance < 0 || ExtensionsKt.dp(140) < distance) {
                    // 当前位置比记录位置要小，正常返回
                    break;
                }
                // 处理放大
                isScrolling = true;
                setZoom(distance);
                setScroll(distance);
                return true;
            // 返回true表示已经完成触摸事件，不再处理
            default:
                break;
        }
        return true;
    }

    private void setScroll(int distance) {
        mScrollView.scrollTo(mScrollView.getScrollX(), -distance);
    }

    public void setZoom(float zoom) {
        if (mZoomViewWidth <= 0 || mZoomViewHeight <= 0) {
            return;
        }
        ViewGroup.LayoutParams lp = mZoomView.getLayoutParams();
        lp.width = (int) (mZoomViewWidth + zoom);
        lp.height = (int) (mZoomViewHeight * ((mZoomViewWidth + zoom) / mZoomViewWidth));
        ((MarginLayoutParams) lp).setMargins(-(lp.width - mZoomViewWidth) / 2, 0, 0, 0);
        mZoomView.setLayoutParams(lp);
    }

    private void replyImage() {
        float distance = mZoomView.getMeasuredWidth() - mZoomViewWidth;
        long duration = (long) (distance * mReplyRate);

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(distance, 0f).setDuration(duration);
        valueAnimator.addUpdateListener(animation -> setZoom((Float) animation.getAnimatedValue()));
        valueAnimator.start();

        ValueAnimator valueAnimator2 = ValueAnimator.ofFloat(mScrollView.getScrollY(), 0f).setDuration(duration);
        valueAnimator2.addUpdateListener(animation -> mScrollView.scrollTo(mScrollView.getScrollX(), (int) ((float) animation.getAnimatedValue())));
        valueAnimator2.start();
    }
}