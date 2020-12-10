package com.example.module_home.firstpage

import androidx.lifecycle.MutableLiveData
import com.example.common_base.base.BaseResult
import com.example.common_base.base.viewmodel.BaseViewModel
import com.example.common_base.base.viewmodel.ErrorState
import com.example.common_base.base.viewmodel.SuccessState
import com.example.module_home.data.source.RemoteDataSource
import com.example.module_home.firstpage.bean.Article
import com.example.module_home.firstpage.bean.BannerBean

/**
 * @describe :viewmodel for article firstpage
 *
 * @author zwq 2020/11/23
 */
class ArticleViewModel constructor(
    private val repository: RemoteDataSource
) : BaseViewModel() {

    private var articleDataList = mutableListOf<Article>()
    private var page = 0

    val bannersData: MutableLiveData<MutableList<BannerBean>> by lazy {
        MutableLiveData<MutableList<BannerBean>>()
    }

    val articleData: MutableLiveData<MutableList<Article>> by lazy {
        MutableLiveData<MutableList<Article>>()
    }

    fun getBanner() {
        launch(tryBlock = {
            repository.getBanners().let {
                if (it is BaseResult.Success) {
                    bannersData.value = it.data
                    mStateLiveData.value = SuccessState
                } else if (it is BaseResult.Error) {
                    mStateLiveData.value = ErrorState(it.exception.message)
                }
            }
        })
    }

    fun getArticles(isRefresh: Boolean = false) {
        launch(tryBlock = {
            if (isRefresh || page == 0) {
                repository.getTopArticles()?.let {
                    if (it is BaseResult.Success) {
                        page = 0
                        articleDataList.clear()
                        articleDataList.addAll(it.data)
                        mStateLiveData.value = SuccessState
                    } else if (it is BaseResult.Error) {
                        mStateLiveData.value = ErrorState(it.exception.message)
                    }
                }
            }

            repository.getArticles(page).let {
                if (it is BaseResult.Success) {
                    articleDataList.addAll(it.data.datas)

                    articleData.value = articleDataList
                    page++
                    mStateLiveData.value = SuccessState
                } else if (it is BaseResult.Error) {
                    mStateLiveData.value = ErrorState(it.exception.message)
                }
            }
        })
    }
}