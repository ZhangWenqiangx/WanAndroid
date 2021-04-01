package com.example.module_video.recommend.adapter

import android.view.View
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.common_base.constants.AConstance
import com.example.common_base.constants.Constants
import com.example.common_base.util.time
import com.example.common_base.widget.GlideRoundTransform
import com.example.module_video.R
import com.example.module_video.recommend.bean.OpenRecBean
import com.example.module_video.recommend.bean.VideoInfoBean
import com.youth.banner.util.LogUtils


/**
 *  @author : zhang.wenqiang
 *  @date : 2021/3/30
 *  description :
 */
class ItemVideoSmallCardProvider(val lightMode: Boolean = false) : BaseItemProvider<OpenRecBean>() {

    override val itemViewType: Int
        get() = OpenRecBean.VIDEO_SMALL_CARD

    override val layoutId: Int
        get() = R.layout.rec_item_video_card

    override fun convert(helper: BaseViewHolder, item: OpenRecBean) {
        helper.setText(R.id.tv_video_title, item.data.title)
        helper.setText(R.id.textView, item.data.author?.name + " / #" + item.data.category)
        helper.setText(R.id.tv_video_time, item.data.duration.time())

        Glide.with(helper.itemView)
            .load(item.data.cover.detail)
            .transform(GlideRoundTransform(context))
            .placeholder(R.drawable.img_def)
            .skipMemoryCache(false)
            .dontAnimate()
            .into(helper.getView(R.id.iv_video_cover))

        if (lightMode) {
            helper.setTextColor(
                R.id.tv_video_title,
                context.resources.getColor(R.color.white_f4f5f6)
            )
            helper.setTextColor(R.id.textView, context.resources.getColor(R.color.gray_ea))
            helper.setTextColor(R.id.tv_video_time, context.resources.getColor(R.color.gray_ea))
        }
    }

    override fun onClick(helper: BaseViewHolder, view: View, data: OpenRecBean, position: Int) {
        super.onClick(helper, view, data, position)
        val openRecBean = data.data
        val infoBean = VideoInfoBean()
            .apply {
                videoTitle = openRecBean.title
                category = openRecBean.category
                video_description = openRecBean.description
                collectionCount = openRecBean.consumption.collectionCount
                shareCount = openRecBean.consumption.shareCount
                avatar = openRecBean.author.icon
                nickName = openRecBean.author.name
                user_description = openRecBean.author.description
                playerUrl = openRecBean.playUrl
                blurredUrl = openRecBean.cover.blurred
                videoId = openRecBean.id.toInt()
                coverImg  = openRecBean.cover.detail
            }

        ARouter.getInstance()
            .build(AConstance.ACTIVITY_URL_VIDEO_PLAY)
            .withParcelable(Constants.VIDEO_PLAY_VIDEO_INFO, infoBean)
            .navigation()
    }
}