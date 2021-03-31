package com.example.module_video.data

import com.example.module_video.recommend.bean.OpenRecBean
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/16
 *  description :
 */
interface OpenEyeApi {

    /**
     * 开眼每日推荐
     */
    @GET
    suspend fun getOpenEyeDaily(@Url url: String): OpenEyeResponse<MutableList<OpenRecBean>>

    /**
     * 视频相关
     */
    @GET("api/v4/video/related")
    suspend fun getOpenEyeRelatedVideo(@Query("id") id: Int): OpenEyeResponse<MutableList<OpenRecBean>>

    /**
     * 评论
     */
    @GET
    suspend fun getOpenEyeRelatedReplies(@Url url: String): OpenEyeResponse<MutableList<OpenRecBean>>
}