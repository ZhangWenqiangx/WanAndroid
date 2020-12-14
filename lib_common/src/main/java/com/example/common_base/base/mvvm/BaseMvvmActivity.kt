package com.example.common_base.base.mvvm

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.common_base.base.BaseActivity
import com.example.common_base.base.data.viewmodel.BaseViewModel

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/3
 *  description :
 */
abstract class BaseMvvmActivity<V : ViewDataBinding, VM : BaseViewModel> : BaseActivity() {

    private var viewModelId = 0
    protected lateinit var viewModel: VM
    protected var viewDataBinding: V? = null

    override fun initBinding() {
        viewModel = createViewModel()
        viewModelId = initVariableId()
        performDataBinding()
    }

    private fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutResId())
        viewDataBinding?.setVariable(viewModelId, viewModel)
        viewDataBinding?.lifecycleOwner = this
        viewDataBinding?.executePendingBindings()
    }

    /**
     * 初始化ViewModel的id
     *
     * @return BR的id
     */
    abstract fun initVariableId(): Int

    abstract fun createViewModel(): VM
}