package com.example.module_video.recommend.adapter

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.common_base.widget.GlideRoundTransform
import com.example.module_video.R
import com.example.module_video.recommend.bean.OpenRecBean
import com.youth.banner.util.LogUtils


/**
 *  @author : zhang.wenqiang
 *  @date : 2021/3/30
 *  description :
 */
class ItemBannerProvider : BaseItemProvider<OpenRecBean>() {

    override val itemViewType: Int
        get() = OpenRecBean.BANNER

    override val layoutId: Int
        get() = R.layout.rec_item_banner_item_view

    override fun convert(holder: BaseViewHolder, item: OpenRecBean) {
        holder.setText(R.id.tv_title, item.data.header.title)
        holder.setText(R.id.tv_description, item.data.header.description)
        holder.setText(R.id.tv_ad, item.data.label.text)

        Glide.with(holder.itemView)
            .load(item.data.header.icon)
            .placeholder(R.drawable.img_def)
            .apply(RequestOptions.bitmapTransform(CircleCrop()))
            .into(holder.getView(R.id.iv_author))

        Glide.with(holder.itemView)
            .load(item.data.image)
            .placeholder(R.drawable.img_def)
            .transform(GlideRoundTransform(context))
            .into(holder.getView(R.id.banner_bg))
    }

    override fun onClick(helper: BaseViewHolder, view: View, data: OpenRecBean, position: Int) {
        super.onClick(helper, view, data, position)
        LogUtils.d(data.toString())
    }
}