package com.example.module_video.data

import com.example.common_base.base.data.BaseResult


/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/10
 *  description :此模块所有数据获取接口
 */
interface OpenEyeRepository {

    suspend fun getRecommend(isRefresh:Boolean): BaseResult<MutableList<OpenRecBean>>
//
//    suspend fun getDetails(): BaseResult<MutableList<Article>>
//
//    suspend fun getComment(): BaseResult<MutableList<BannerBean>>
}