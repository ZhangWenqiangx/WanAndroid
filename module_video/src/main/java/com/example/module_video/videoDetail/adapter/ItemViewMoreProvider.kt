package com.example.module_video.videoDetail.adapter

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
class ItemViewMoreProvider : BaseItemProvider<OpenRecBean>() {

    override val itemViewType: Int
        get() = OpenRecBean.SHOW_MORE

    override val layoutId: Int
        get() = R.layout.rec_item_show_more

    override fun convert(helper: BaseViewHolder, item: OpenRecBean) {
        helper.setText(R.id.tv_title, "查看更多")
    }

    override fun onClick(helper: BaseViewHolder, view: View, data: OpenRecBean, position: Int) {
        super.onClick(helper, view, data, position)
        //todo shou all rec list at dialog
    }
}