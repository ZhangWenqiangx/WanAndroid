package com.example.module_usercenter.bean

/**
 * Description:
 */
data class LoginResult(var email: String, var icon: String, var id: Int = 0, var password: String,
                       var token: String, var type: Int, var username: String,
                       var chapterTops: List<*>, var collectIds: List<*>)

