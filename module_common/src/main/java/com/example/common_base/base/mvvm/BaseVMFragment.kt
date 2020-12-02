package com.example.common_base.base.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.common_base.base.viewmodel.BaseViewModel

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/1
 *  description :
 */
abstract class BaseVMFragment<M : BaseViewModel> : Fragment() {

    protected val viewModel by lazy {
        ViewModelProvider(this, getFactory())[getViewModelClass()]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(getLayoutId(), container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        addObserver()
    }

    open fun addObserver(){}

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun getViewModelClass(): Class<M>

    abstract fun getFactory(): ViewModelProvider.Factory
}