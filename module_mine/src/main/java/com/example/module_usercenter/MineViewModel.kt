package com.example.module_usercenter

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.room.util.StringUtil
import com.example.common_base.base.data.BaseResult
import com.example.common_base.base.viewmodel.BaseViewModel
import com.example.common_base.base.viewmodel.ErrorState
import com.example.common_base.constants.Constants
import com.example.common_base.util.SpUtil
import com.example.common_base.util.SpUtil.read
import com.example.module_usercenter.api.MineRepository
import com.example.module_usercenter.bean.UserInfoResult

/**
 *  @author : zhang.wenqiang
 *  @date : 2021/4/16
 *  description :
 */
class MineViewModel(
    private val repository: MineRepository
) : BaseViewModel() {

    val userInfo: MutableLiveData<UserInfoResult> by lazy {
        MutableLiveData<UserInfoResult>()
    }

    fun isLogin(): Boolean {
        return !TextUtils.isEmpty(read(Constants.USER_LOGIN, Constants.PASSWORD, ""))
    }

    fun getUserInfo() {
        launch(tryBlock = {
            repository.getUserInfo().let {
                if (it is BaseResult.Success) {
                    userInfo.value = it.data
                } else if (it is BaseResult.Error) {
                    mStateLiveData.value = ErrorState(it.exception.message)
                }
            }
        })
    }

}