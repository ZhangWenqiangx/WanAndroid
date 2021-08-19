package com.example.common_base.widget.more;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.Nullable;

import java.text.DecimalFormat;


public class PieView extends View {

    private float radius = dpToPx(100);
    RectF bouns = new RectF();
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int[] mAngleData = {90, 90,90,90};
    private int[] mColorData = {Color.GREEN, Color.BLUE,Color.GREEN, Color.BLUE};
    DecimalFormat df = new DecimalFormat("0.00");

    {
        paint.setTextSize(dpToPx(12));
        paint.setTextAlign(Paint.Align.CENTER);
    }

    public PieView(Context context) {
        super(context);
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bouns.set((int) (getWidth() / 2 - radius)
                , (int) (getHeight() / 2 - radius)
                , (int) (getWidth() / 2 + radius)
                , (int) (getHeight() / 2 + radius));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int currentAngle = 0;
        for (int i = 0; i < mAngleData.length; i++) {
            paint.setColor(mColorData[i]);
            int angle = mAngleData[i];
            canvas.drawArc(bouns, currentAngle, angle, true, paint);

            float halfAngle = currentAngle + mAngleData[i] / 2;
            float cos = (float) Math.cos(Math.toRadians(halfAngle));
            float sin = (float) Math.sin(Math.toRadians(halfAngle));

            String value = df.format((float) angle * 100 / 360);
            canvas.drawText(value + "%"
                    , (float) cos * dpToPx(120) + getWidth() / 2
                    , (float) sin * dpToPx(120) + getHeight() / 2
                    , paint);
            currentAngle += angle;
        }
        paint.setColor(Color.BLACK);
    }

    private float dpToPx(float val) {
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                val,
                Resources.getSystem().getDisplayMetrics()
        );
    }
}
