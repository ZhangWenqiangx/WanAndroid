package com.example.common_base.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common_base.base.Result
import kotlinx.coroutines.*

typealias Cancel = (e: Exception) -> Unit

open class BaseViewModel : ViewModel() {

    val mStateLiveData = MutableLiveData<StateActionEvent>()

    fun <T> launch(
        cancel: Cancel? = null,
        liveData: MutableLiveData<T>,
        block: suspend CoroutineScope.() -> Result<T>
    ) {
        viewModelScope.launch {
            try {
                mStateLiveData.value = LoadState
                val result = withContext(Dispatchers.IO) { block() }
                if (result.errorCode == 0 or 200) {
                    mStateLiveData.value = SuccessState
                    liveData.value = result.data
                } else {
                    mStateLiveData.value = ErrorState(result.errorMsg)
                }
            } catch (e: Exception) {
                when (e) {
                    is CancellationException -> cancel?.invoke(e)
                    else -> mStateLiveData.value = ErrorState(e.message)
                }
            }
        }
    }
}