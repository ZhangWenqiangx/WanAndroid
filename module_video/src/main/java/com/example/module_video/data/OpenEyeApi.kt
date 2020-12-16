package com.example.module_video.data

import retrofit2.http.GET

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/16
 *  description :
 */
interface OpenEyeApi {

    /**
     * 开眼每日推荐
     */
    @GET("api/v5/index/tab/allRec")
    suspend fun getOpenEyeDaily(): OpenEyeResponse<MutableList<OpenRecBean>>
}