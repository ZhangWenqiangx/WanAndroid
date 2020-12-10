package com.example.module_usercenter.presenter

import com.example.common_base.base.mvp.BaseObserver
import com.example.common_base.base.mvp.BasePresenter
import com.example.module_usercenter.api.UserCenterApiService
import com.example.module_usercenter.bean.RegisterResult
import com.example.module_usercenter.contract.RegisterContract

/**
 * Description:
 */
class RegisterPresenter : BasePresenter<RegisterContract.View>(), RegisterContract.Presenter {

    override fun register(phone: String, pwd: String, repwd: String) {
        addSubscirbe(create(UserCenterApiService::class.java).register(phone,pwd, repwd),object: BaseObserver<RegisterResult>(getView()){
            override fun onSuccess(data: RegisterResult?) {
                isViewAttached().let {
                    getView().registSuccess()
                }
            }
        })
    }
}