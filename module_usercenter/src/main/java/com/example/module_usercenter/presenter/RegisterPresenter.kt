package com.example.module_usercenter.presenter

import com.example.common_base.mvp.BasePresenter
import com.example.module_usercenter.contract.RegisterContract

/**
 * Description:
 */
class RegisterPresenter : BasePresenter<RegisterContract.View>(),RegisterContract.Presenter{
    override fun register(phone: String, pwd: String, repwd: String) {

    }
}