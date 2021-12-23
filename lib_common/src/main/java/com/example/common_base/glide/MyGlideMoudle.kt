package com.example.common_base.glide

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.Excludes
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpLibraryGlideModule
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.RequestOptions
import com.example.common_base.R
import okhttp3.OkHttpClient
import java.io.InputStream

/**
 *  author : zhang.wenqiang
 *  date : 2021/9/15
 *  description :
 */
@GlideModule
@Excludes(value = [OkHttpLibraryGlideModule::class])
open class MyGlideMoudle : AppGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        super.applyOptions(context, builder)
        builder.setDefaultRequestOptions {
            return@setDefaultRequestOptions RequestOptions()
                .placeholder(R.drawable.img_def)
                .encodeQuality(90)
        }
    }

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(ProgressInterceptor())
            .build()

        registry.replace(GlideUrl::class.java, InputStream::class.java, OkHttpUrlLoader.Factory(okHttpClient))
    }
}