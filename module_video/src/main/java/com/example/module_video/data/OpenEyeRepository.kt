package com.example.module_video.data

import com.example.common_base.base.data.BaseResult
import com.example.module_video.recommend.bean.OpenRecBean

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/10
 *  description :视频模块相关
 */
interface OpenEyeRepository {

    /**
     * 推荐页 获取推荐视频
     */
    suspend fun getRecommend(isRefresh: Boolean): BaseResult<MutableList<OpenRecBean>>

    /**
     * 获取相关视频
     */
    suspend fun getRelatedVideo(id: Int): BaseResult<MutableList<OpenRecBean>>

    /**
     * 获取相关评论
     */
    suspend fun getRelatedReplies(
        isLoadMore: Boolean,
        id: Int
    ): BaseResult<MutableList<OpenRecBean>>
}