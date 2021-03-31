package com.example.module_video.videoDetail.adapter

import com.chad.library.adapter.base.BaseProviderMultiAdapter
import com.example.module_video.recommend.adapter.ItemTextCardProvider
import com.example.module_video.recommend.bean.OpenRecBean
import com.example.module_video.recommend.adapter.ItemVideoSmallCardProvider

/**
 *  @author : zhang.wenqiang
 *  @date : 2021/3/30
 *  description : 多布局实现 提供不同的provider
 *  头布局：视频标题 简介等内容 √
 *  布局一：标题：相关视频
 *  布局二：热门视频推荐Item
 *  布局三：查看更多->dialog
 *  布局四：评论
 */
class VideoPlayMultiAdapter : BaseProviderMultiAdapter<OpenRecBean>() {

    init {
        addItemProvider(ItemVideoSmallCardProvider(lightMode = true))
        addItemProvider(ItemTextCardProvider(lightMode = true))
        addItemProvider(ItemViewMoreProvider())
        addItemProvider(ItemReplyProvider())
    }

    override fun getItemType(data: List<OpenRecBean>, position: Int): Int {
        return data[position].itemType
    }
}