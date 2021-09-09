package com.example.common_base.http

import com.example.common_base.base.BaseApplication
import com.example.common_base.constants.Constants
import com.example.common_base.util.CookieHelper
import com.example.common_base.util.NetWorkUtil
import com.example.common_base.util.SpUtil
import com.youth.banner.util.LogUtils
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Description:头部 和 日志拦截器
 * @author zhang.wenqiang
 */
object InterceptorUtil {
    /**
     * 头部拦截器
     * @return
     */
    @JvmStatic
    fun headerInterceptor(): Interceptor {
        return Interceptor { chain: Interceptor.Chain ->
            val request = chain.request()
            val builder = request.newBuilder()
            builder.addHeader("Content-type", "application/json; charset=utf-8")
            val domain = request.url.host
            if (domain.isNotEmpty()) {
                val spDomain = SpUtil.read(Constants.FILE_NAME, domain, "")
                val cookie: String = if (spDomain.isNotEmpty()) spDomain else ""
                if (cookie.isNotEmpty()) {
                    builder.addHeader(Constants.COOKIE_NAME, cookie)
                }
            }
            chain.proceed(builder.build())
        }
    }

    @JvmStatic
    fun logInterceptor(): Interceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @JvmStatic
    fun cacheInterceptor(): Interceptor {
        return Interceptor { chain: Interceptor.Chain ->
            var request = chain.request()
            if (!NetWorkUtil.isNetworkAvailable(BaseApplication.sApplication)) {
                request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build()
            }
            val response = chain.proceed(request)
            if (NetWorkUtil.isNetworkAvailable(BaseApplication.sApplication)) {
                val maxAge = 60 * 3
                response.newBuilder()
                    .header("Cache-Control", "public, max-age=$maxAge")
                    .removeHeader("Retrofit")
                    .build()
            } else {
                val maxStale = 60 * 60 * 24 * 28
                response.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=$maxStale")
                    .removeHeader("nyn")
                    .build()
            }
        }
    }

    @JvmStatic
    fun cookieInterceptor(): Interceptor {
        return Interceptor { chain: Interceptor.Chain ->

            val request = chain.request()
            val response = chain.proceed(request)
            val requestUrl = request.url.toString()
            val domain = request.url.host

            if ((requestUrl.contains(Constants.SAVE_USER_LOGIN_KEY)
                        || requestUrl.contains(Constants.SAVE_USER_REGISTER_KEY))
                && response.headers(Constants.SET_COOKIE_KEY).isNotEmpty()
            ) {
                val cookies = response.headers(Constants.SET_COOKIE_KEY)
                val cookie = CookieHelper.encodeCookie(cookies)
                CookieHelper.saveCookie(requestUrl, domain, cookie)
            }
            return@Interceptor response
        }
    }
}
