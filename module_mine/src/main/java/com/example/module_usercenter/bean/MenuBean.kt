package com.example.module_usercenter.bean

/**
 *  author : zhang.wenqiang
 *  date : 2021/9/8
 *  description :
 */
data class MenuBean(
    var imageResId: Int,
    var title: String,
    var stubTitle: String? = "",
    var routeUrl: String,
    var showRightIcon: Boolean = true,
    var arguments: Map<String, Any>? = mapOf(),
)
