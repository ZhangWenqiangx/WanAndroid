package com.example.common_base.http

import com.example.common_base.base.BaseApplication
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/16
 *  description :
 */
abstract class RetrofitFactory<T> {

    var mService: T
    private var mBaseUrl = ""

    private var okHttpClient: OkHttpClient

    abstract fun baseUrl(): String

    abstract fun getService(): Class<T>

    abstract fun getInterceptorList(): MutableList<Interceptor>

    init {
        mBaseUrl = this.baseUrl()
        if (mBaseUrl.isEmpty()) {
            throw RuntimeException("base url can't be empty")
        }
        okHttpClient = getOkHttpClient()
        mService = getRetrofit()!!.create(getService())
    }

    private fun getRetrofit(): Retrofit? {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(mBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private fun getOkHttpClient(): OkHttpClient {
        val cookieJar = PersistentCookieJar(
            SetCookieCache(),
            SharedPrefsCookiePersistor(BaseApplication.sApplication)
        )

        val builder = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .cookieJar(cookieJar)
            .addInterceptor(InterceptorUtil.headerInterceptor())
            .addInterceptor(InterceptorUtil.logInterceptor())

        if (getInterceptorList().isNotEmpty()) {
            for (index in getInterceptorList().indices) {
                builder.addInterceptor(getInterceptorList()[index])
            }
        }

        return builder.build()
    }
}