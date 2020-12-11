package com.example.module_home.data

import com.example.common_base.base.data.BaseResult
import com.example.module_home.data.source.LocalDataSource
import com.example.module_home.data.source.RemoteDataSource
import com.example.module_home.recommend.bean.Article
import com.example.module_home.recommend.bean.ArticleResponse
import com.example.module_home.recommend.bean.BannerBean
import com.example.module_home.search.bean.HotKeyBean
import com.example.module_home.search.bean.SearchEntity
import com.example.module_home.search.bean.SearchResultResponse

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/10
 *  description : 负责调度数据来源 将数据来源分为本地与网络 各自实现
 */
class DefaultArticleRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : ArticleRepository {
    override suspend fun getArticles(page: Int): BaseResult<ArticleResponse> {
        return remoteDataSource.getArticles(page)
    }

    override suspend fun getTopArticles(): BaseResult<MutableList<Article>> {
        return remoteDataSource.getTopArticles()
    }

    override suspend fun getBanners(): BaseResult<MutableList<BannerBean>> {
        return remoteDataSource.getBanners()
    }

    override suspend fun getHotKey(): BaseResult<MutableList<HotKeyBean>> {
        return remoteDataSource.getHotKey()
    }

    override suspend fun searchByKey(page: Int, key: String): BaseResult<SearchResultResponse> {
        return remoteDataSource.searchByKey(page, key)
    }

    override suspend fun getAllHistory(): BaseResult<MutableList<SearchEntity>> {
        return localDataSource.getAllHistory()
    }

    override suspend fun saveKey(key: String) {
        localDataSource.saveKey(key)
    }

    override suspend fun deleteHistory() {
        localDataSource.deleteHistory()
    }

    override suspend fun delete(data: SearchEntity) {
        localDataSource.deleteHistory(data)
    }
}