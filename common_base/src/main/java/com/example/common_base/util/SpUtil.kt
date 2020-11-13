package com.example.common_base.util

import android.annotation.SuppressLint
import android.content.Context
import com.example.common_base.base.BaseApplication

/**
 * Description:SharePreferences工具类
 */
object SpUtil {

    @SuppressLint("CommitPrefEdits")
    fun write(name: String, key: String, value: Any) {
        val sp = BaseApplication.sApplication.getSharedPreferences(name, Context.MODE_PRIVATE)
        val editor = sp.edit()

        when (value) {
            is String -> editor.putString(key, value)
            is Int -> editor.putInt(key, value)
            is Float -> editor.putFloat(key, value)
            is Long -> editor.putLong(key, value)
            is Boolean -> editor.putBoolean(key, value)
        }

        editor.apply()
    }

    fun read(name: String, key: String, defValue: String): String {
        val sp = BaseApplication.sApplication.getSharedPreferences(name, Context.MODE_PRIVATE)
        return sp.getString(key, defValue) ?: ""
    }
}