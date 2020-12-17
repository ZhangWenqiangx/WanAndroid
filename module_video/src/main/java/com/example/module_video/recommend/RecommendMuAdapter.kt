package com.example.module_video.recommend

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.common_base.util.format
import com.example.common_base.widget.GlideRoundTransform
import com.example.module_video.R
import com.example.module_video.data.OpenRecBean
import com.youth.banner.util.LogUtils

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/16
 *  description :
 */
class RecommendMuAdapter(data: MutableList<OpenRecBean>) :
    BaseMultiItemQuickAdapter<OpenRecBean, BaseViewHolder>(data) {

    init {
        addItemType(OpenRecBean.SQUARE_CARD_COLLECTION, R.layout.rec_item_square_card)
        addItemType(OpenRecBean.AUTO_PLAY_VIDEO_AD, R.layout.rec_item_auto_play)
        addItemType(OpenRecBean.TEXT_CARD, R.layout.rec_item_text_card)
        addItemType(OpenRecBean.FOLLOW_CARD, R.layout.rec_item_follow_card_view)
        addItemType(OpenRecBean.VIDEO_SMALL_CARD, R.layout.rec_item_video_card)
        addItemType(OpenRecBean.BANNER, R.layout.rec_item_banner_item_view)
    }

    override fun convert(holder: BaseViewHolder, item: OpenRecBean) {
        when (holder.itemViewType) {
            OpenRecBean.BANNER -> {
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
            OpenRecBean.AUTO_PLAY_VIDEO_AD -> {
                holder.setText(R.id.tv_title, item.data.detail.title)
                holder.setText(R.id.tv_description, item.data.detail.description)

                Glide.with(holder.itemView)
                    .load(item.data.detail.icon)
                    .placeholder(R.drawable.img_def)
                    .apply(RequestOptions.bitmapTransform(CircleCrop()))
                    .into(holder.getView(R.id.iv_author))

                Glide.with(holder.itemView)
                    .load(item.data.detail.imageUrl)
                    .transform(GlideRoundTransform(context))
                    .placeholder(R.drawable.img_def)
                    .into(holder.getView(R.id.iv_video_cover))
            }
            OpenRecBean.TEXT_CARD -> {
                holder.setText(R.id.tv_title, item.data.text)
            }
            OpenRecBean.VIDEO_SMALL_CARD -> {
                holder.setText(R.id.tv_video_title, item.data.title)
                holder.setText(R.id.textView, item.data.author.name + " / #" + item.data.category)
                holder.setText(R.id.tv_video_time, format(item.data.duration))

                Glide.with(holder.itemView)
                    .load(item.data.cover.detail)
                    .transform(GlideRoundTransform(context))
                    .placeholder(R.drawable.img_def)
                    .into(holder.getView(R.id.iv_video_cover))
            }
            OpenRecBean.FOLLOW_CARD -> {
                holder.setText(R.id.tv_title, item.data.content.data.title)
                holder.setText(
                    R.id.tv_description, item.data.content.data.author.name + " / #" +
                            item.data.content.data.category
                )

                holder.setText(R.id.tv_video_time, format(item.data.content.data.duration))

                Glide.with(holder.itemView)
                    .load(item.data.header.icon)
                    .placeholder(R.drawable.img_def)
                    .apply(RequestOptions.bitmapTransform(CircleCrop()))
                    .into(holder.getView(R.id.iv_author))

                Glide.with(holder.itemView)
                    .load(item.data.content.data.cover.detail)
                    .transform(GlideRoundTransform(context))
                    .placeholder(R.drawable.img_def)
                    .into(holder.getView(R.id.iv_video_cover))
            }
            OpenRecBean.SQUARE_CARD_COLLECTION -> {
                holder.setText(R.id.tv_title, item.data.header.title)
                holder.setText(R.id.tv_action_title, item.data.header.rightText)

                val rv: RecyclerView = holder.getView(R.id.rv_content)
                rv.apply {
                    layoutManager = LinearLayoutManager(context)
                    isNestedScrollingEnabled = false
                    setHasFixedSize(true)
                    adapter = SquareCardItemAdapter(
                        R.layout.rec_item_follow_card_view,
                        item.data.itemList
                    )
                }
            }
            else -> {
            }
        }
    }
}