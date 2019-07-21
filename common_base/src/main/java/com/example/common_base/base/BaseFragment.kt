package com.example.common_base.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Description:
 */
abstract class BaseFragment : Fragment() {

    lateinit var mContext: Context

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mContext = context!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        this.javaClass.isAnnotationPresent()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(getLayoutResId(), container, false)
        initView(view)
        initData()
        return view
    }

    abstract fun initView(view: View?)

    abstract fun initData()

    abstract fun getLayoutResId(): Int


}