package com.example.module_video.recommend.adapter

import com.chad.library.adapter.base.BaseProviderMultiAdapter
import com.example.module_video.data.OpenRecBean


/**
 *  @author : zhang.wenqiang
 *  @date : 2021/3/30
 *  description : 多布局实现 提供不同的provider
 */
class VideoPlayMultiAdapter : BaseProviderMultiAdapter<OpenRecBean>() {

    init {
        addItemProvider(ItemVideoSmallCardProvider())

    }

    override fun getItemType(data: List<OpenRecBean>, position: Int): Int {
        return data[position].itemType
    }
}