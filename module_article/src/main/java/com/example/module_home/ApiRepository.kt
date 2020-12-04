package com.example.module_home

import com.example.common_base.base.Result
import com.example.common_base.http.RetrofitClient
import com.example.module_home.firstpage.bean.Article
import com.example.module_home.firstpage.bean.ArticleResponse
import com.example.module_home.firstpage.bean.BannerBean
import com.example.module_home.search.bean.HotKeyBean
import com.example.module_home.search.bean.SearchResultResponse

/**
 * @describe :
 *
 * @author zwq 2020/11/23
 */
class ApiRepository {

    private val api by lazy { RetrofitClient.getInstance().retrofit.create(Api::class.java) }

    suspend fun getArticles(page: Int): Result<ArticleResponse> = api.getArticles(page)

    suspend fun getTopArticles(): Result<List<Article>>? = api.getTopArticles()

    suspend fun getBanners():Result<List<BannerBean>>? = api.getBanners()

    suspend fun getHotKey():Result<ArrayList<HotKeyBean>> = api.getHotKey()

    suspend fun searchByKey(page: Int,key:String):Result<SearchResultResponse>? = api.searchByKey(page,key)
}