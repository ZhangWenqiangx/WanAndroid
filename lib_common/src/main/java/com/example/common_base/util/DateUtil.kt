package com.example.common_base.util

/**
 * @param duration 秒钟
 */
fun format(duration: Int): String? {
    var second = ""
    var minute = ""
    var time = ""
    //获取到时间
    val mm = duration / 60 //分
    val ss = duration % 60 //秒
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
    time = "$minute:$second"
    return time
}