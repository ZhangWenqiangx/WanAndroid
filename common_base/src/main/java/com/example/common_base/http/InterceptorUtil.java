package com.example.common_base.http;

import android.text.TextUtils;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

import java.io.IOException;

/**
 * Description:
 */
public class InterceptorUtil {

    /**
     * 头部拦截器
     * @return
     */
    public static Interceptor headerInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request.Builder builder = chain.request().newBuilder();
                builder.addHeader("X-APP-Agent", "corp_zx_app")
                        .addHeader("X-OS", "Android")
//                        .addHeader("X-APP-ID", "20181018000061")
                        .addHeader("X-APP-ID", "20181130000009")
                        .addHeader("X-DEVICE-TYPE", "USERNAME")
                        .addHeader("appId", "281")
                        .addHeader("businessType", "610001");

                String token = "";
                if (!TextUtils.isEmpty(token)) {
                    builder.addHeader("Access-Token", token);
                }

                Request build = builder.build();
                return chain.proceed(build);
            }
        };
    }

    public static Interceptor logInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }
}
