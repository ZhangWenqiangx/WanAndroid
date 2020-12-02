package com.example.module_home

import com.example.common_base.base.Result
import com.example.common_base.http.RetrofitClient
import com.example.module_home.bean.Article
import com.example.module_home.bean.ArticleResponse
import com.example.module_home.bean.BannerBean

/**
 * @describe :
 *
 * @author zwq 2020/11/23
 */
class FirstPageRepository {

    private val api by lazy { RetrofitClient.getInstance().retrofit.create(Api::class.java) }

    suspend fun getArticles(page: Int): Result<ArticleResponse> = api.getArticles(page)

    suspend fun getTopArticles(): Result<List<Article>>? = api.getTopArticles()

    suspend fun getBanners():Result<List<BannerBean>>? = api.getBanners()
}