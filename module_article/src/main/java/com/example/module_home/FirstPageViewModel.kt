package com.example.module_home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.common_base.base.viewmodel.BaseViewModel
import com.example.module_home.bean.Article
import com.example.module_home.bean.BannerBean
import kotlinx.coroutines.launch

/**
 * @describe :viewmodel for article firstpage
 *
 * @author zwq 2020/11/23
 */
class FirstPageViewModel constructor(
    private val repository: FirstPageRepository
) : BaseViewModel() {

    private var dataList = mutableListOf<Article>()
    private var page = 0

    val bannersData:MutableLiveData<MutableList<BannerBean>> by lazy {
        MutableLiveData<MutableList<BannerBean>>()
    }

    val articleData: MutableLiveData<MutableList<Article>> by lazy {
        MutableLiveData<MutableList<Article>>()
    }

    fun getBanner(){
        viewModelScope.launch {
            val banners = repository.getBanners()
            bannersData.value = banners?.data?.toMutableList()
        }
    }

    fun getArticles(isRefresh: Boolean = false) {
        viewModelScope.launch {

            if (isRefresh || page == 0) {
                val topArticles = repository.getTopArticles()
                topArticles?.let {
                    dataList.clear()
                    dataList.addAll(it.data)
                }
            }

            val articles = repository.getArticles(page)
            articles.data.datas?.let {
                dataList.addAll(it.toMutableList())
            }

            articleData.value = dataList
            page++
        }
    }
}