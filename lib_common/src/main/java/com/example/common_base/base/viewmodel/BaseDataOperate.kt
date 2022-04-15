package com.example.common_base.base.viewmodel

import com.example.common_base.base.data.BaseResponse
import com.example.common_base.base.data.BaseResult
import com.example.common_base.http.ExceptionHandler
import kotlinx.coroutines.coroutineScope

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/8
 *  description :
 */
open class BaseDataOperate {

    /**
     * 协程异常捕获
     */
    suspend fun <T : Any> execute(
        call: suspend () -> BaseResult<T>
    ): BaseResult<T> {
        return try {
            call()
        } catch (e: Throwable) {
            return BaseResult.Error(ExceptionHandler.handlerException(e))
        }
    }

    /**
     * 将服务器数据转接为BaseResult类型
     */
    fun <T : Any> convert(
        response: BaseResponse<T>
    ): BaseResult<T> {
        return if (response.errorCode == 0) {
            BaseResult.Success(data = response.data)
        } else {
            BaseResult.Error(Exception(response.errorMsg))
        }
    }
}