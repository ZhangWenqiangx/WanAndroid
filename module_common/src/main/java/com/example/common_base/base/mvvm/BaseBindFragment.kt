package com.example.common_base.base.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.common_base.base.BaseFragment

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/1
 *  description : 包含DataBinding父类
 */
abstract class BaseBindFragment<V : ViewDataBinding> : BaseFragment() {
    
    protected var viewDataBinding: V? = null

    protected var rootView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (null == rootView) {
            viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
            rootView = viewDataBinding?.root
        }
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding?.lifecycleOwner = this.viewLifecycleOwner
        addObserver()
    }

    override fun initView(view: View?) {
    }

    override fun initData() {
    }

    open fun addObserver() {}
}