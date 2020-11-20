package com.example.module_usercenter.contract

import com.example.common_base.mvp.IView

/**
 * Description:
 */
interface RegisterContract {

    interface View : IView {
        fun registSuccess()
    }

    interface Presenter {
        fun register(phone :String,pwd :String,repwd :String)
    }

}