package com.example.module_usercenter.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common_base.AConstance
import com.example.common_base.base.BaseMVPActivity
import com.example.module_usercenter.R
import com.example.module_usercenter.contract.LoginPresenter

@Route(path = AConstance.ACTIVITY_URL_LOGIN)
class LoginActivity : BaseMVPActivity<LoginPresenter>() {

    override fun showLoading() {}

    override fun hideLoading() {}

    override fun getLayoutResId(): Int = R.layout.activity_login

    override fun createPresenter(): LoginPresenter = LoginPresenter()

    override fun initView() {}
}
