package com.example.module_home


import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common_base.base.BaseFragment
import com.example.common_base.constants.AConstance

@Route(path = AConstance.FRAGMENT_URL_HOME)
class HomeFragment : BaseFragment() {

    override fun initView(view: View?) {

    }

    override fun initData() {

    }

    override fun getLayoutResId(): Int = R.layout.fragment_home
}
