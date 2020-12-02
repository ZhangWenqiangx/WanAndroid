package com.example.module_home

import com.example.common_base.base.Result
import com.example.module_home.bean.Article
import com.example.module_home.bean.ArticleResponse
import com.example.module_home.bean.BannerBean
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @describe :
 *
 * @author zwq 2020/11/20
 */
interface Api {
    @GET("article/list/{page}/json")
    suspend fun getArticles(@Path("page") page: Int): Result<ArticleResponse>

    @GET("article/top/json")
    suspend fun getTopArticles(): Result<List<Article>>?

    @GET("banner/json")
    suspend fun getBanners(): Result<List<BannerBean>>
}