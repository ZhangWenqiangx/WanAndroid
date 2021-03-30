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
class ItemTextCardProvider : BaseItemProvider<OpenRecBean>() {

    override val itemViewType: Int
        get() = OpenRecBean.TEXT_CARD

    override val layoutId: Int
        get() = R.layout.rec_item_text_card

    override fun convert(helper: BaseViewHolder, item: OpenRecBean) {
        helper.setText(R.id.tv_title, item.data.text)
    }

    override fun onClick(helper: BaseViewHolder, view: View, data: OpenRecBean, position: Int) {
        super.onClick(helper, view, data, position)
        LogUtils.d(data.toString())
    }
}