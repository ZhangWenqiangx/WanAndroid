package com.example.module_video.recommend.adapter

import android.view.View
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.module_video.R
import com.example.module_video.recommend.bean.OpenRecBean
import com.youth.banner.util.LogUtils


/**
 *  @author : zhang.wenqiang
 *  @date : 2021/3/30
 *  description :
 */
class ItemTextCardProvider(val lightMode: Boolean = false) : BaseItemProvider<OpenRecBean>() {

    override val itemViewType: Int
        get() = OpenRecBean.TEXT_CARD

    override val layoutId: Int
        get() = R.layout.rec_item_text_card

    override fun convert(helper: BaseViewHolder, item: OpenRecBean) {
        if(lightMode){
            helper.setTextColor(
                R.id.tv_title,
                context.resources.getColor(R.color.white_f4f5f6)
            )
        }
        helper.setText(R.id.tv_title, item.data.text)
    }
}