package com.example.common_base.util

import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Resources
import android.util.TypedValue
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

fun Context.getCompatColor(@ColorRes colorId: Int) = ResourcesCompat.getColor(resources, colorId, null)

fun Context.getCompatDrawable(@DrawableRes drawableId: Int) = AppCompatResources.getDrawable(this, drawableId)!!

fun Context.hasPermissions(vararg permissions: String) = permissions.all { permission ->
    ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
}

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