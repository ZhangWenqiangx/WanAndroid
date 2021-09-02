package com.example.common_base.base.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.common_base.base.BaseFragment
import com.example.common_base.base.viewmodel.*
import com.youth.banner.util.LogUtils
import java.lang.reflect.ParameterizedType

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/1
 *  description : 包含DataBinding父类
 */
abstract class BaseMvvmFragment<V : ViewDataBinding, VM : BaseViewModel> : BaseFragment() {

    protected lateinit var viewModel: VM

    protected lateinit var viewDataBinding: V

    protected var rootView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (null == rootView) {
            viewDataBinding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
            rootView = viewDataBinding.root
        }
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = createViewModel()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner
        addObserver()
    }

    override fun initView(view: View?) {
    }

    override fun initData() {
    }

    open fun addObserver() {
        viewModel.mStateLiveData.observe(viewLifecycleOwner, {
            when (it) {
                is SuccessState -> LogUtils.d("success")
                is ErrorState -> LogUtils.d("error ${it.message}")
                is LoadingState -> LogUtils.d("loading")
                else -> LogUtils.d("begin")
            }
        })
    }

//    private fun createViewModel() {
//        val type = javaClass.genericSuperclass
//        if (type is ParameterizedType) {
//            val tp = type.actualTypeArguments[0]
//            val tClass = tp as? Class<VM> ?: BaseViewModel::class.java
//            viewModel = ViewModelProvider(this,
//                ViewModelFactory()
//            ).get(tClass) as VM
//        }
//    }

    abstract fun createViewModel(): VM
}