package com.example.module_video.recommend.adapter

import android.view.View
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.common_base.util.time
import com.example.common_base.widget.GlideRoundTransform
import com.example.module_video.R
import com.example.module_video.data.OpenRecBean
import com.youth.banner.util.LogUtils


/**
 *  @author : zhang.wenqiang
 *  @date : 2021/3/30
 *  description :
 */
class ItemVideoSmallCardProvider : BaseItemProvider<OpenRecBean>() {

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
    }

    override fun onClick(helper: BaseViewHolder, view: View, data: OpenRecBean, position: Int) {
        super.onClick(helper, view, data, position)
        LogUtils.d(data.toString())
    }
}