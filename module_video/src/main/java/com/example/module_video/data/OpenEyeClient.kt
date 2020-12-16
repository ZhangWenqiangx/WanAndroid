package com.example.module_video.data

import com.example.common_base.http.RetrofitFactory
import okhttp3.Interceptor

const val OPEN_EYE_BASE_URL = "http://baobab.kaiyanapp.com/"

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/16
 *  description :
 */
object OpenEyeClient : RetrofitFactory<OpenEyeApi>() {

    override fun baseUrl(): String = OPEN_EYE_BASE_URL

    override fun getService(): Class<OpenEyeApi> = OpenEyeApi::class.java

    override fun getInterceptorList(): MutableList<Interceptor> = mutableListOf()
}