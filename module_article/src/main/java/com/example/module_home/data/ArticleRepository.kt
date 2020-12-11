package com.example.module_home.data

import com.example.common_base.base.data.BaseResult
import com.example.module_home.recommend.bean.Article
import com.example.module_home.recommend.bean.ArticleResponse
import com.example.module_home.recommend.bean.BannerBean
import com.example.module_home.search.bean.HotKeyBean
import com.example.module_home.search.bean.SearchEntity
import com.example.module_home.search.bean.SearchResultResponse

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/10
 *  description :此模块所有数据获取接口
 */
interface ArticleRepository {

    suspend fun getArticles(page: Int): BaseResult<ArticleResponse>

    suspend fun getTopArticles(): BaseResult<MutableList<Article>>

    suspend fun getBanners(): BaseResult<MutableList<BannerBean>>

    suspend fun getHotKey(): BaseResult<MutableList<HotKeyBean>>

    suspend fun searchByKey(page: Int, key: String): BaseResult<SearchResultResponse>

    suspend fun getAllHistory(): BaseResult<MutableList<SearchEntity>>

    suspend fun saveKey(key: String)

    suspend fun deleteHistory()

    suspend fun delete(data:SearchEntity)
}