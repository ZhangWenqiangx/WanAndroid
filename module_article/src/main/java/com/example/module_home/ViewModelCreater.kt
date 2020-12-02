package com.example.module_home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/1
 *  description :
 */
class ViewModelCreater:ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FirstPageViewModel::class.java)) {
            return FirstPageViewModel(FirstPageRepository()) as T
        }
        throw  IllegalArgumentException(" unKnown ViewModel class ")
    }
}