package com.example.module_usercenter.api

import com.example.common_base.base.data.BaseResult
import com.example.module_usercenter.bean.UserInfoResult

/**
 *  author : zhang.wenqiang
 *  date : 2021/9/1
 *  description :
 */
interface MineRepository {
    suspend fun getUserInfo(): BaseResult<UserInfoResult>
}