package com.example.module_home

import com.example.common_base.base.BaseResponse
import com.example.module_home.bean.ArticleResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @describe :
 *
 * @author zwq 2020/11/20
 */
interface Api {
    @GET("article/list/{page}/json")
    suspend fun getArticles(@Path("page") page: Int): BaseResponse<ArticleResponse>
}