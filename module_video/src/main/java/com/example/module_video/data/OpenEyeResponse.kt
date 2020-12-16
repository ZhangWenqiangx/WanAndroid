package com.example.module_video.data

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/16
 *  description :
 */
data class OpenEyeResponse<T>(
    var count: Int,
    val total: Int,
    val nextPageUrl: String,
    val adExist: Boolean,
    val itemList: T
)
