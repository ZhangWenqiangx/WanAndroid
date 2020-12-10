package com.example.common_base.base.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 *
 */
open class BaseViewModel : ViewModel() {

    /**
     * 状态驱动
     * tips:同一个LiveData不可以使用不同的viewLifecycleOwner管理
     */
    val mStateLiveData = MutableLiveData<StateActionEvent>()

    /**
     * 执行代码块 且驱动状态为Loading
     * @param dispatcher 指定协程调度线程
     */
    fun launch(
        tryBlock: suspend CoroutineScope.() -> Unit,
        dispatcher: CoroutineDispatcher = Dispatchers.Main
    ) {
        mStateLiveData.postValue(LoadingState)
        viewModelScope.launch(dispatcher) {
            tryBlock()
        }
    }
}