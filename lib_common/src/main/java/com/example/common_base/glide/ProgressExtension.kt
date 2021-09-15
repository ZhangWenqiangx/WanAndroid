package com.example.common_base.glide

import android.content.Context
import android.graphics.Color
import com.bumptech.glide.annotation.GlideExtension
import com.bumptech.glide.annotation.GlideOption
import com.bumptech.glide.request.BaseRequestOptions

/**
 *  author : zhang.wenqiang
 *  date : 2021/9/15
 *  description :
 */
@GlideExtension
object ProgressExtension {

    @GlideOption
    @JvmStatic
    fun progress(options: BaseRequestOptions<*>, context: Context): BaseRequestOptions<*> {
        val progressPlaceholderDrawable =
            ProgressPlaceholderDrawable(
                context,
                options.placeholderDrawable,
                options.placeholderId
            )
        progressPlaceholderDrawable.setTint(Color.GRAY)
        return options.placeholder(progressPlaceholderDrawable)
    }
}