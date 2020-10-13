package com.example.module_main.ui

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.View
import android.view.WindowManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common_base.base.BaseActivity
import com.example.common_base.constants.AConstance
import com.example.module_main.R
import com.example.module_main.ui.fragment.HomeFragment
import com.example.module_main.ui.fragment.MineFragment
import com.example.module_main.ui.fragment.ProjectFragment
import com.example.module_main.ui.fragment.SystemFragment
import kotlinx.android.synthetic.main.activity_main.*

@Route(path = AConstance.ACTIVITY_URL_MAIN)
class MainActivity : BaseActivity(), View.OnClickListener {

    private var currentSelectionId = R.id.rb_home
    private lateinit var fm: FragmentManager
    private var fragments = mutableListOf<Fragment>()

    override fun onClick(v: View?) {

    }

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun initView() {
        setStatusColor(this, isTranslate = false, isDarkText = true)
        fm = supportFragmentManager
        createFragment()
        selectFragment(0)
        rb_home.isChecked = true

        rg_radio_group.setOnCheckedChangeListener { _, checkedId ->
            if (currentSelectionId == checkedId) {
                return@setOnCheckedChangeListener
            }
            currentSelectionId = checkedId
            when (checkedId) {
                R.id.rb_home -> selectFragment(0)
                R.id.rb_project -> selectFragment(1)
                R.id.rb_system -> selectFragment(2)
                R.id.rb_mine -> selectFragment(3)
            }

        }
    }

    private fun setStatusColor(
        activity: Activity,
        isTranslate: Boolean,
        isDarkText: Boolean
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val window = activity.window
            val decorView = window.decorView
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility =
                (if (isTranslate) View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN else 0) or if (isDarkText) View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR else 0

            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //添加Flag把状态栏设为可绘制模式
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色
            window.statusBarColor = if (isTranslate) Color.TRANSPARENT else Color.WHITE
        }
    }

    override fun initData() {

    }

    private fun selectFragment(index: Int) {
        val ft = fm.beginTransaction()
        for (i in fragments.indices) {
            if (i == index) {
                ft.show(fragments[i])
            } else {
                ft.hide(fragments[i])
            }
        }
        ft.commit()
    }

    private fun createFragment() {
        val transaction = fm.beginTransaction()

        val homeFragment = HomeFragment()
        val projectFragment = ProjectFragment()
        val systemFragment = SystemFragment()
        val mineFragment = MineFragment()

        transaction.apply {
            add(R.id.fl_main_container, homeFragment)
            add(R.id.fl_main_container, projectFragment)
            add(R.id.fl_main_container, systemFragment)
            add(R.id.fl_main_container, mineFragment)
        }

        fragments.apply {
            add(homeFragment)
            add(projectFragment)
            add(systemFragment)
            add(mineFragment)
        }

        transaction.commit()
    }


}
