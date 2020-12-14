package com.example.module_home.data.source

import com.example.common_base.base.data.BaseResult
import com.example.common_base.base.data.viewmodel.BaseDataOperate
import com.example.common_base.http.RetrofitClient
import com.example.module_home.composite.bean.ProjectResponse
import com.example.module_home.composite.bean.ProjectTab
import com.example.module_home.data.RemoteApi
import com.example.module_home.home.bean.Article
import com.example.module_home.home.bean.ArticleResponse
import com.example.module_home.home.bean.BannerBean
import com.example.module_home.search.bean.HotKeyBean
import com.example.module_home.search.bean.SearchResultResponse

/**
 * @describe : 网络请求相关操作
 *
 * @author zwq 2020/11/23
 */
class RemoteDataSource : BaseDataOperate() {

    private val api by lazy { RetrofitClient.getInstance().retrofit.create(RemoteApi::class.java) }

    suspend fun getArticles(page: Int): BaseResult<ArticleResponse> =
        execute { convert(api.getArticles(page)) }

    suspend fun getTopArticles(): BaseResult<MutableList<Article>> =
        execute { convert(api.getTopArticles()) }

    suspend fun getBanners(): BaseResult<MutableList<BannerBean>> =
        execute { convert(api.getBanners()) }

    suspend fun getHotKey(): BaseResult<MutableList<HotKeyBean>> =
        execute { convert(api.getHotKey()) }

    suspend fun searchByKey(page: Int, key: String): BaseResult<SearchResultResponse> =
        execute { convert(api.searchByKey(page, key)) }

    suspend fun getTree(): BaseResult<MutableList<ProjectTab>> =
        execute { convert(api.getTree()) }

    suspend fun getTreeNode(page: Int, id: Int): BaseResult<ProjectResponse> =
        execute { convert(api.getTreeNode(page, id)) }
}