package com.example.module_home

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.module_home.bean.Article
import kotlinx.coroutines.launch

/**
 * @describe :viewmodel for article firstpage
 *
 * @author zwq 2020/11/23
 */
class FirstPageViewModel @ViewModelInject constructor(
    private val repository: FirstPageRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val articles: MutableLiveData<MutableList<Article>> by lazy {
        MutableLiveData<MutableList<Article>>()
    }

    fun getArticles(page: Int) = viewModelScope.launch {
        val articles1 = repository.getArticles(page)
//        val articles1 = FirstPageRepository().getArticles(page)
        articles.value = articles1.data.datas?.toMutableList()
    }

}