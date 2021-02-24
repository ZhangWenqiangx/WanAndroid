package com.example.common_base.util

import android.content.res.Resources
import android.util.TypedValue

/**
 * float 变成 px
 */
fun Float.dp(): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this,
        Resources.getSystem().displayMetrics
    )
}

fun Int.dp(): Float =
    this.toFloat().dp()

/**
 * int ms/毫秒 变成 分：秒 格式
 */
fun Int.time(): String? {
    val second: String
    val minute: String
    //获取到时间
    val mm = this / 60 //分
    val ss = this % 60 //秒
    second = if (ss < 10) {
        "0$ss"
    } else {
        ss.toString()
    }
    minute = if (mm < 10) {
        "0$mm"
    } else {
        mm.toString() //分钟
    }
    return "$minute:$second"
}