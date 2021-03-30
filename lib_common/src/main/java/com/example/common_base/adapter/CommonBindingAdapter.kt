package com.example.common_base.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.common_base.R

/**
 *  @author : zhang.wenqiang
 *  @date : 2021/3/30
 *  description :
 */
class CommonBindingAdapter {
    companion object {
        @JvmStatic
        @BindingAdapter("imageCircleUrl")
        fun loadCircleImage(
            imageView: ImageView,
            url: String?
        ) {
            url?.run {
                Glide.with(imageView.context)
                    .load(this)
                    .placeholder(R.drawable.img_def)
                    .apply(RequestOptions.bitmapTransform(CircleCrop()))
                    .into(imageView)
            }
        }
    }
}