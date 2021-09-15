package com.example.module_video.recommend.adapter

import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.common_base.glide.GlideApp
import com.example.common_base.glide.ProgressImageViewTarget
import com.example.common_base.util.time
import com.example.common_base.widget.GlideRoundTransform
import com.example.module_video.R
import com.example.module_video.recommend.bean.OpenRecBean

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/16
 *  description :首页-多布局item-列表
 */
class SquareCardItemAdapter(
    layoutResId: Int,
    list: MutableList<OpenRecBean.DataBeanXX.ItemListBean>
) :
    BaseQuickAdapter<OpenRecBean.DataBeanXX.ItemListBean, BaseViewHolder>(layoutResId, list) {

    override fun convert(holder: BaseViewHolder, item: OpenRecBean.DataBeanXX.ItemListBean) {

        holder.setText(R.id.tv_title, item.data.header.title)
        holder.setText(
            R.id.tv_description,
            item.data.content.data.author.name + " / #" +
                    item.data.content.data.category
        )

        holder.setText(R.id.tv_video_time, item.data.content.data.duration.time())

        GlideApp.with(holder.itemView)
            .load(item.data.header.icon)
            .placeholder(R.drawable.img_def)
            .progress(context)
            .apply(RequestOptions.bitmapTransform(CircleCrop()))
            .into(ProgressImageViewTarget(item.data.header.icon, holder.getView(R.id.iv_author)))

        GlideApp.with(holder.itemView)
            .load(item.data.content.data.cover.detail)
            .placeholder(R.drawable.img_def)
            .transform(GlideRoundTransform(context))
            .progress(context)
            .into(
                ProgressImageViewTarget(
                    item.data.content.data.cover.detail,
                    holder.getView(R.id.iv_video_cover)
                )
            )
    }
}