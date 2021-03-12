package com.example.common_base.base.mvvm

import androidx.databinding.ViewDataBinding
import com.example.common_base.base.viewmodel.BaseViewModel

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/11
 *  description :适用于 add + show + hide
 */
abstract class BaseLazyFragment<V : ViewDataBinding, VM : BaseViewModel> :
    BaseMvvmFragment<V, VM>() {

    private var isLoaded = false

    override fun onResume() {
        super.onResume()
        if (!isLoaded && !isHidden) {
            loadData()
            isLoaded = true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isLoaded = false
    }

    protected abstract fun loadData()

}
