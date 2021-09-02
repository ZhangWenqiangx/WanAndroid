package com.example.module_usercenter.api

import com.example.common_base.base.data.BaseResult
import com.example.common_base.base.viewmodel.BaseDataOperate
import com.example.common_base.http.RetrofitClient
import com.example.module_usercenter.bean.UserInfoResult

/**
 *  author : zhang.wenqiang
 *  date : 2021/9/1
 *  description :
 */
class DefMineRepository : MineRepository, BaseDataOperate() {
    private val api by lazy {
        RetrofitClient.getInstance().retrofit.create(UserCenterApiService::class.java)
    }

    override suspend fun getUserInfo(): BaseResult<UserInfoResult> =
        execute { convert(api.getUserInfo()) }
}