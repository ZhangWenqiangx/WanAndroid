package com.example.module_gank.api

import com.example.common_base.base.data.BaseResponse
import com.example.module_gank.bean.MeiziResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Streaming
import retrofit2.http.Url

/**
 * Description:
 */
interface GankApi {

    @GET("http://gank.io/api/data/福利/{pageSize}/{page}")
    fun getMeiZiList(@Path("pageSize") pageSize: Int, @Path("page") page: Int): Observable<BaseResponse<List<MeiziResult>>>

    @Streaming
    @GET
    fun downloadImage(@Url url:String)
}