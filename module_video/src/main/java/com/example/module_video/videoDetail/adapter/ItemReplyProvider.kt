package com.example.module_video.videoDetail.adapter

import android.view.ViewStub
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.module_video.R
import com.example.module_video.recommend.bean.OpenRecBean


/**
 *  @author : zhang.wenqiang
 *  @date : 2021/3/30
 *  description :
 */
class ItemReplyProvider : BaseItemProvider<OpenRecBean>() {

    override val itemViewType: Int
        get() = OpenRecBean.REPLY

    override val layoutId: Int
        get() = R.layout.video_rec_item_reply

    override fun convert(helper: BaseViewHolder, item: OpenRecBean) {
        Glide.with(helper.itemView)
            .load(item.data.user.avatar)
            .placeholder(R.drawable.img_def)
            .apply(RequestOptions.bitmapTransform(CircleCrop()))
            .into(helper.getView(R.id.iv_user_avatar))
        helper.apply {
            setText(R.id.tv_title, item.data.user.nickName)
            setText(R.id.tv_content, item.data.message)
            setText(R.id.tv_create_time, item.data.createTime)
            setText(R.id.tv_like_count, item.data.likeCount)
        }

        if (item.data.parentReply != null) {
            helper.setVisible(R.id.tv_show_reply, true)
            helper.setVisible(R.id.tv_des, true)
            helper.setText(R.id.tv_des, "回复 @" + item.data.parentReply.user.nickName)
            helper.getView<ViewStub>(R.id.video_vs_parent_reply).apply {
                try {
                    val inflate = inflate()
                    Glide.with(helper.itemView)
                        .load(item.data.parentReply.user.avatar)
                        .placeholder(R.drawable.img_def)
                        .apply(RequestOptions.bitmapTransform(CircleCrop()))
                        .into(inflate.findViewById(R.id.iv_parent_avatar))

                    inflate.findViewById<TextView>(R.id.tv_parent_title)
                        .setText(item.data.parentReply.user.nickName)
                    inflate.findViewById<TextView>(R.id.tv_parent_content)
                        .setText(item.data.parentReply.message)
                } catch (e: Exception) {
                }

            }
        }

    }
}