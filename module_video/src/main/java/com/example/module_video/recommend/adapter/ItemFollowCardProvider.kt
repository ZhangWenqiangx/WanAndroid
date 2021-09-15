package com.example.module_video.recommend.adapter

import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.common_base.constants.AConstance
import com.example.common_base.constants.Constants
import com.example.common_base.glide.GlideApp
import com.example.common_base.glide.ProgressImageViewTarget
import com.example.common_base.util.time
import com.example.common_base.widget.GlideRoundTransform
import com.example.module_video.R
import com.example.module_video.recommend.bean.OpenRecBean
import com.example.module_video.recommend.bean.VideoInfoBean


/**
 *  @author : zhang.wenqiang
 *  @date : 2021/3/30
 *  description :
 */
class ItemFollowCardProvider : BaseItemProvider<OpenRecBean>() {

    override val itemViewType: Int
        get() = OpenRecBean.FOLLOW_CARD

    override val layoutId: Int
        get() = R.layout.rec_item_follow_card_view

    override fun convert(holder: BaseViewHolder, item: OpenRecBean) {
        holder.setText(R.id.tv_title, item.data.content.data.title)
        holder.setText(
            R.id.tv_description, item.data.content.data.author.name + " / #" +
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
            .skipMemoryCache(false)
            .dontAnimate()
            .transform(GlideRoundTransform(context))
            .progress(context)
            .into(
                ProgressImageViewTarget(
                    item.data.content.data.cover.detail,
                    holder.getView(R.id.iv_video_cover)
                )
            )
    }

    override fun onClick(helper: BaseViewHolder, view: View, data: OpenRecBean, position: Int) {
        super.onClick(helper, view, data, position)
        val openRecBean = data.data
        val infoBean = VideoInfoBean()
            .apply {
                videoTitle = openRecBean.header.title
                category = openRecBean.content.data.author.name + " / #" +
                        openRecBean.content.data.category
                video_description = openRecBean.content.data.description
                collectionCount = openRecBean.content.data.consumption.collectionCount
                shareCount = openRecBean.content.data.consumption.shareCount
                avatar = openRecBean.content.data.author.icon
                nickName = openRecBean.content.data.author.name
                user_description = openRecBean.content.data.author.description
                playerUrl = openRecBean.content.data.playUrl
                blurredUrl = openRecBean.content.data.cover.blurred
                videoId = openRecBean.content.data.id
                coverImg = openRecBean.content.data.cover.detail
            }

        ARouter.getInstance()
            .build(AConstance.ACTIVITY_URL_VIDEO_PLAY)
            .withParcelable(Constants.VIDEO_PLAY_VIDEO_INFO, infoBean)
            .navigation()
    }
}