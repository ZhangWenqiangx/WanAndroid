package com.example.module_video.recommend.adapter

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alibaba.android.arouter.launcher.ARouter
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.common_base.constants.AConstance
import com.example.common_base.constants.Constants
import com.example.module_video.R
import com.example.module_video.recommend.bean.OpenRecBean
import com.example.module_video.recommend.bean.VideoInfoBean


/**
 *  @author : zhang.wenqiang
 *  @date : 2021/3/30
 *  description :
 */
class ItemSquareCardProvider : BaseItemProvider<OpenRecBean>() {

    override val itemViewType: Int
        get() = OpenRecBean.SQUARE_CARD_COLLECTION

    override val layoutId: Int
        get() = R.layout.rec_item_square_card

    override fun convert(holder: BaseViewHolder, item: OpenRecBean) {
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
            ).apply {
                addChildClickViewIds(R.id.iv_video_cover)
                setOnItemChildClickListener { _, _, position ->
                    val openRecBean = this.data[position].data

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
                    }

                    ARouter.getInstance()
                        .build(AConstance.ACTIVITY_URL_VIDEO_PLAY)
                        .withParcelable(Constants.VIDEO_PLAY_VIDEO_INFO, infoBean)
                        .navigation()
                }
            }
        }
    }
}