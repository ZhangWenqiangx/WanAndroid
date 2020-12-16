package com.example.module_video.recommend

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.common_base.widget.GlideRoundTransform
import com.example.common_base.widget.LinearItemDecoration
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
            OpenRecBean.SQUARE_CARD_COLLECTION -> {
                holder.setText(R.id.tv_title, item.data.header.title)
                holder.setText(R.id.tv_action_title, item.data.header.rightText)

                val rv: RecyclerView = holder.getView(R.id.rv_content)
                rv.apply {
                    layoutManager = LinearLayoutManager(context)
                    isNestedScrollingEnabled = false
                    setHasFixedSize(true)
                    addItemDecoration(
                        LinearItemDecoration(context).color(
                            ContextCompat.getColor(context, R.color.gray_ea)
                        )
                            .height(1f)
                            .margin(12f, 12f)
                    )
                    adapter = SquareCardItemAdapter(
                        R.layout.rec_item_follow_card_view,
                        item.data.itemList
                    )
                }
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
                holder.setText(R.id.tv_title,item.data.text)
            }
            OpenRecBean.FOLLOW_CARD -> {
                holder.setText(R.id.tv_title, item.data.content.data.title)
                holder.setText(R.id.tv_description, item.data.content.data.description)

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
            OpenRecBean.VIDEO_SMALL_CARD -> {
                holder.setText(R.id.tv_video_title, item.data.title)
                holder.setText(R.id.textView, item.data.description)

                Glide.with(holder.itemView)
                    .load(item.data.cover.detail)
                    .transform(GlideRoundTransform(context))
                    .placeholder(R.drawable.img_def)
                    .into(holder.getView(R.id.iv_video_cover))
            }
            OpenRecBean.BANNER -> {
                Glide.with(holder.itemView)
                    .load(item.data.image)
                    .placeholder(R.drawable.img_def)
                    .into(holder.getView(R.id.banner_bg))
            }
            else -> {
            }
        }
    }
}