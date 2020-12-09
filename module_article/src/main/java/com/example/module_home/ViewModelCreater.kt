package com.example.module_home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.module_home.firstpage.ArticleViewModel
import com.example.module_home.search.SearchViewModel

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/1
 *  description :
 */
class ViewModelCreater : ViewModelProvider.Factory {

    private val repository by lazy { ApiRepository() }

    override fun <T : ViewModel?> create(modelClass: Class<T>) = with(modelClass) {
        when {
            isAssignableFrom(ArticleViewModel::class.java) ->
                ArticleViewModel(repository)
            isAssignableFrom(SearchViewModel::class.java) ->
                SearchViewModel(repository)
            else ->
                throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    } as T
}