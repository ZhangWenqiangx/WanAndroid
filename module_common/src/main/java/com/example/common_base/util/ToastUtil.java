package com.example.common_base.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Toast提示框
 * 1.增加左图 右文形式
 *
 * @author zwq
 */
public class ToastUtil {

    private static String oldMsg;
    private static long time;

    private static Toast toast;
    private static Toast mCustomToast;

    /**
     * 显示长时间Toast
     *
     * @param context 上下文对象
     * @param text    提示内容
     */
    public static void showLongToast(Context context, String text) {

        if (TextUtils.isEmpty(text)) {
            return;
        }
        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
        }
        toast.setText(text);
        toast.show();
    }

    /***
     * 显示短时间Toast
     *
     *  @param context 上下文对象
     *  @param text 提示内容
     */
    public static void showShortToast(Context context, String text) {

        if (TextUtils.isEmpty(text)) {
            return;
        }

        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        }
        toast.setText(text);
        toast.show();
    }

    public static void showToast(Context context, String msg) {
        if (!msg.equals(oldMsg)) {
            showShortToast(context, msg);
            time = System.currentTimeMillis();
        } else {
            if (System.currentTimeMillis() - time > 2000) {
                showShortToast(context, msg);
                time = System.currentTimeMillis();
            }
        }
        oldMsg = msg;
    }

    /**
     * 吐司居中提示
     *
     * @param context 上下文对象
     * @param text    提示内容
     */
    public static void showCenterToast(Context context, String text) {

        if (TextUtils.isEmpty(text)) {
            return;
        }

        if (toast == null) {
            toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        }
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setText(text);
        toast.show();
    }

    public static void cancel() {
        if (toast != null) {
            toast.cancel();
        }
    }
}
