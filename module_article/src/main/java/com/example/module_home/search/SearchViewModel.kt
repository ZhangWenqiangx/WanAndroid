package com.example.module_home.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.common_base.base.viewmodel.BaseViewModel
import com.example.module_home.ApiRepository
import com.example.module_home.search.bean.HotKeyBean
import com.example.module_home.search.bean.SearchResult
import kotlinx.coroutines.launch

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/3
 *  description :
 */
class SearchViewModel constructor(
    private val repository: ApiRepository
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
    val historyKeyData: MutableLiveData<MutableList<HotKeyBean>> by lazy {
        MutableLiveData<MutableList<HotKeyBean>>()
    }

    private var searchDataList = mutableListOf<SearchResult>()

    /**
     * 搜索关键词后的数据
     */
    val searchData: MutableLiveData<MutableList<SearchResult>> by lazy {
        MutableLiveData<MutableList<SearchResult>>()
    }

    fun getHotKey() {
        viewModelScope.launch {
            val hotKey = repository.getHotKey()
            hotKeyData.value = hotKey.data
        }
    }

    fun searchByKey(key: String, isRefresh: Boolean = false) {
        viewModelScope.launch {
            if (isRefresh) {
                page = 0
                searchDataList.clear()
            }
            val searchByKey = repository.searchByKey(page, key)
            searchByKey?.data?.datas?.let {
                searchDataList.addAll(it.toMutableList())
            }
            searchData.value = searchDataList
            page++
        }
    }

    fun saveKeyForHistory(key: String) {

    }

}