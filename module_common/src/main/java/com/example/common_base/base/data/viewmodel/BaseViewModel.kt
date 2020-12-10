package com.example.common_base.base.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    val mStateLiveData = MutableLiveData<StateActionEvent>()

    /**
     * 如果指定其他Dispatcher需要postValue
     */
    fun launch(
        tryBlock: suspend CoroutineScope.() -> Unit,
        ioDispatcher: CoroutineDispatcher = Dispatchers.Main
    ) {
        mStateLiveData.postValue(LoadingState)
        viewModelScope.launch(ioDispatcher) {
            tryBlock()
        }
    }
}