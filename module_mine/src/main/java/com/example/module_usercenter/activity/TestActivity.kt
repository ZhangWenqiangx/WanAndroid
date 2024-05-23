package com.example.module_usercenter.activity

import android.util.Log
import android.widget.Button
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common_base.base.BaseActivity
import com.example.common_base.constants.AConstance
import com.example.common_base.util.StatusBarUtil
import com.example.module_usercenter.R
import kotlin.math.acos
import kotlin.math.asin
import kotlin.math.cos
import kotlin.math.sin

@Route(path = AConstance.ACTIVITY_URL_SPLASH)
class TestActivity : BaseActivity() {
    override fun getLayoutResId(): Int = R.layout.activity_test

    override fun initView() {
        StatusBarUtil.setDarkMode(this, true)
        findViewById<Button>(R.id.btn_1).setOnClickListener {
            funA()
        }
        findViewById<Button>(R.id.btn_2).setOnClickListener {
            haha(10000000)
        }
        findViewById<Button>(R.id.btn_3).setOnClickListener {
            funD(1000)
        }
    }

    override fun initData() {

    }

    private fun haha(l: Long): Double {
        val haha2 = haha2(l)
        val haha3 = haha3(l)
        return haha2 + haha3
    }

    private fun haha2(l: Long): Double {
        var result = 0.0
        for (i in 0 until l) {
            result += acos(cos(i.toDouble()))
            result -= asin(sin(i.toDouble()))
        }
        return result
    }

    private fun haha3(l: Long): Double {
        var result = 0.0
        for (i in 0 until l) {
            result += acos(cos(i.toDouble()))
            result -= asin(sin(i.toDouble()))
        }
        return result
    }

    private fun funD(i: Int) {
        if (i == 1) {
            Log.e("99788", "1*1=1")
        } else {
            for (j in 1 until i) {
                Log.e("99788", j.toString() + "*" + i + "=" + j * i + " ")
            }
            funD(i - 1)
        }
    }

    fun funA() {
        Thread.sleep(110)
        funB()
    }

    fun funB() {
        Thread.sleep(812)
        funC()
    }

    fun funC() {
        Thread.sleep(101)
    }

}
