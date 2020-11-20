package com.example.common_base.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Toast提示框
 * 1.增加左图 右文形式
 *
 * @author zlc
 */
public class ToastUtil {

    private static Toast toast;
    private static Toast mCustomToast;
    private static final int VALUE = 0;
    /**
     * true：提示原始的网络请求失败信息;false：提示网络请求失败
     */
    private static boolean showOriginalNetError = true;

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

    public static void showShortToast(Context context, int text) {
        String string = context.getResources().getString(text);
        showShortToast(context, string);
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
