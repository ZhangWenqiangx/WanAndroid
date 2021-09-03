package com.example.common_base.util

import android.text.TextUtils
import com.example.common_base.constants.Constants
import com.example.common_base.util.SpUtil.read
import com.example.common_base.util.SpUtil.write

/**
 *  author : zhang.wenqiang
 *  date : 2021/9/2
 *  description :
 */
object UserHelper {
    fun isLogin(): Boolean {
        return !TextUtils.isEmpty(getUserPwd())
    }

    fun saveUserNamePwd(name: String, pwd: String) {
        write(Constants.USER_LOGIN, Constants.USERNAME, name)
        write(Constants.USER_LOGIN, Constants.PASSWORD, pwd)
    }

    fun getUserName(): String {
        return read(Constants.USER_LOGIN, Constants.USERNAME, "")
    }

    fun getUserPwd(): String {
        return read(Constants.USER_LOGIN, Constants.PASSWORD, "")
    }
}