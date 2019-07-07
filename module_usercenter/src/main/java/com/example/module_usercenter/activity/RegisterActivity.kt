package com.example.module_usercenter.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common_base.AConstance
import com.example.common_base.base.BaseMVPActivity
import com.example.module_usercenter.R
import com.example.module_usercenter.contract.RegisterContract
import com.example.module_usercenter.presenter.RegisterPresenter

@Route(path = AConstance.ACTIVITY_URL_REGISTER)
class RegisterActivity : BaseMVPActivity<RegisterPresenter>(),RegisterContract.View {
    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun getLayoutResId(): Int = R.layout.activity_register

    override fun initView() {
    }

    override fun createPresenter(): RegisterPresenter = RegisterPresenter()

    override fun registSuccess() {
    }

}
