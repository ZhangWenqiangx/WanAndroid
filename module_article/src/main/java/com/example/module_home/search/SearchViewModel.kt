package com.example.module_home.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.common_base.base.BaseResult
import com.example.common_base.base.viewmodel.BaseViewModel
import com.example.common_base.base.viewmodel.ErrorState
import com.example.common_base.base.viewmodel.SuccessState
import com.example.module_home.data.ArticleRepository
import com.example.module_home.search.bean.HotKeyBean
import com.example.module_home.search.bean.SearchEntity
import com.example.module_home.search.bean.SearchResult
import kotlinx.coroutines.launch

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/3
 *  description :
 */
class SearchViewModel constructor(
    private val repository: ArticleRepository
) : BaseViewModel() {

    private var page = 0

    /**
     * 搜索关键词
     */
    val searchKey = MutableLiveData<String>()

    /**
     * 热门搜索
     */
    val hotKeyData: MutableLiveData<MutableList<HotKeyBean>> by lazy {
        MutableLiveData<MutableList<HotKeyBean>>()
    }

    /**
     * 历史查询
     */
    val historyData: MutableLiveData<MutableList<SearchEntity>> by lazy {
        MutableLiveData<MutableList<SearchEntity>>()
    }

    var searchDataList = mutableListOf<SearchResult>()

    /**
     * 搜索关键词后的数据
     */
    val searchData: MutableLiveData<MutableList<SearchResult>> by lazy {
        MutableLiveData<MutableList<SearchResult>>()
    }

    fun clearSearchData() {
        searchDataList.clear()
        searchData.value = mutableListOf()
    }

    fun getHotKey() {
        launch(tryBlock = {
            repository.getHotKey().let {
                if (it is BaseResult.Success) {
                    hotKeyData.value = it.data
                    mStateLiveData.value = SuccessState
                } else if (it is BaseResult.Error) {
                    mStateLiveData.value = ErrorState(it.exception.message)
                }
            }
        })
    }

    fun searchByKey(key: String, isRefresh: Boolean = false) {
        if (isRefresh) {
            page = 0
            searchDataList.clear()
        }
        launch(tryBlock = {
            repository.searchByKey(page, key).let {
                if (it is BaseResult.Success) {
                    it.data.datas.let { list ->
                        searchDataList.addAll(list)
                    }
                    searchData.value = searchDataList
                    page++
                    mStateLiveData.value = SuccessState
                } else if (it is BaseResult.Error) {
                    mStateLiveData.value = ErrorState(it.exception.message)
                }
            }
        })
        saveToLocal(key)
    }

    fun getAllHistory() {
        repository
        viewModelScope.launch {
            repository.getAllHistory().let {
                if (it is BaseResult.Success) {
                    historyData.value = it.data
                }
            }
        }
    }

    fun clearHistory() {
        historyData.value = mutableListOf()
        viewModelScope.launch {
            repository.deleteHistory()
        }
    }

    fun saveToLocal(key: String) {
        val value = historyData.value
        value?.add(SearchEntity(key = key))
        historyData.value = value

        viewModelScope.launch {
            repository.saveKey(key)
        }
    }
}