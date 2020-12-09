package com.example.common_base.base

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/8
 *  description :
 */
sealed class BaseResult<out R> {

    data class Success<out T>(val errorCode: Int = 0, val errorMsg: String = "", val data: T) : BaseResult<T>()
    data class Error(val exception: Throwable) : BaseResult<Nothing>()
    object Loading : BaseResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[errorCode=$errorCode,errorMsg=$errorMsg,data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}

/**
 * `true` if [Result] is of type [Success] & holds non-null [Success.data].
 */
val BaseResult<*>.succeeded
    get() = this is BaseResult.Success && data != null