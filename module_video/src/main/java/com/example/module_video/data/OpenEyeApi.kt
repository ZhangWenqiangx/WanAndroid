package com.example.module_video.data

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
    suspend fun getOpenEyeDaily(@Url url:String): OpenEyeResponse<MutableList<OpenRecBean>>
}