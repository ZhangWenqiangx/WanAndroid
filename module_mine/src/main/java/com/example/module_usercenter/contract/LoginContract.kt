package com.example.module_usercenter.contract

import com.example.common_base.mvp.IView
import com.example.module_usercenter.bean.LoginResult

/**
 * Description:
 */
interface LoginContract{
    interface View :IView{
        fun loginSuccess(loginResult: LoginResult)
    }
    interface Presenter {
        fun login(phone: String, password: String)
    }
}