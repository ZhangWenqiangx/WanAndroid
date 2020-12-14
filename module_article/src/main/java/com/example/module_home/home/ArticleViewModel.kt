package com.example.module_home.home

import androidx.lifecycle.MutableLiveData
import com.example.common_base.base.data.BaseResult
import com.example.common_base.base.data.viewmodel.BaseViewModel
import com.example.common_base.base.data.viewmodel.CompleteState
import com.example.common_base.base.data.viewmodel.ErrorState
import com.example.common_base.base.data.viewmodel.SuccessState
import com.example.module_home.composite.bean.Project
import com.example.module_home.composite.bean.ProjectTab
import com.example.module_home.data.source.RemoteDataSource
import com.example.module_home.home.bean.Article
import com.example.module_home.home.bean.BannerBean

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

    val treeData: MutableLiveData<MutableList<ProjectTab>> by lazy {
        MutableLiveData<MutableList<ProjectTab>>()
    }

    fun getBanner() {
        launch(tryBlock = {
            repository.getBanners().let {
                if (it is BaseResult.Success) {
                    bannersData.value = it.data
                } else if (it is BaseResult.Error) {
                    mStateLiveData.value = ErrorState(it.exception.message)
                }
            }
        })
    }

    fun getArticles(isRefresh: Boolean = false) {
        launch(tryBlock = {
            if (isRefresh || page == 0) {
                repository.getTopArticles().let {
                    if (it is BaseResult.Success) {
                        page = 0
                        articleDataList.clear()
                        articleDataList.addAll(it.data)
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

    fun getTree() {
        launch(tryBlock = {
            repository.getTree().let {
                if (it is BaseResult.Success) {
                    treeData.value = it.data
                    mStateLiveData.value = SuccessState
                } else if (it is BaseResult.Error) {
                    mStateLiveData.value = ErrorState(it.exception.message)
                }
            }
        })
    }

    val treeNodeData: MutableLiveData<MutableList<Project>> by lazy {
        MutableLiveData<MutableList<Project>>()
    }

    fun getTreeNode(page: Int, id: Int) {
        launch(tryBlock = {
            repository.getTreeNode(page, id).let {
                if (it is BaseResult.Success) {
                    if (it.data.datas.isNotEmpty()) {
                        treeNodeData.value = it.data.datas
                        mStateLiveData.value = SuccessState
                    } else {
                        mStateLiveData.value = CompleteState
                    }
                } else if (it is BaseResult.Error) {
                    mStateLiveData.value = ErrorState(it.exception.message)
                }
            }
        })
    }
}