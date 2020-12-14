package com.example.common_base.util

import java.text.SimpleDateFormat
import java.util.*

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/1
 *  description :
 */
fun format(time: Long): String {
    var date = Date(time)
    var sdf = SimpleDateFormat("yyyy-MM-dd")
    return sdf.format(date)
}