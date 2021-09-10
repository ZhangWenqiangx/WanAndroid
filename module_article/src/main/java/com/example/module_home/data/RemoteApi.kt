package com.example.module_home.data

import com.example.common_base.base.data.BaseResponse
import com.example.module_home.composite.bean.ProjectResponse
import com.example.module_home.composite.bean.ProjectTab
import com.example.module_home.home.bean.Article
import com.example.module_home.home.bean.ArticleResponse
import com.example.module_home.home.bean.BannerBean
import com.example.module_home.search.bean.HotKeyBean
import com.example.module_home.search.bean.SearchResultResponse
import retrofit2.http.*

/**
 * @describe :retrofit api
 *
 * @author zwq 2020/11/20
 */
interface RemoteApi {
    @GET("article/list/{page}/json")
    suspend fun getArticles(@Path("page") page: Int): BaseResponse<ArticleResponse>

    @GET("article/top/json")
    suspend fun getTopArticles(): BaseResponse<MutableList<Article>>

    @GET("banner/json")
    suspend fun getBanners(): BaseResponse<MutableList<BannerBean>>

    @GET("hotkey/json")
    suspend fun getHotKey(): BaseResponse<MutableList<HotKeyBean>>

    @POST("article/query/{page}/json")
    @FormUrlEncoded
    suspend fun searchByKey(
        @Path("page") page: Int,
        @Field("k") keyword: String
    ): BaseResponse<SearchResultResponse>

    @GET("project/tree/json")
    suspend fun getTree(): BaseResponse<MutableList<ProjectTab>>

    @GET("project/list/{page}/json")
    suspend fun getTreeNode(
        @Path("page") page: Int,
        @Query("cid") id: Int
    ): BaseResponse<ProjectResponse>

    @POST("lg/collect/{id}/json")
    suspend fun collect(@Path("id") id: Int): BaseResponse<Any>

    @POST("lg/uncollect_originId/{id}/json")
    suspend fun unCollect(
        @Path("id") id: Int
    ): BaseResponse<Any>
}