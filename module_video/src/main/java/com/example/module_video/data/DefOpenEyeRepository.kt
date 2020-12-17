package com.example.module_video.data

import com.example.common_base.base.data.BaseResult
import com.example.common_base.base.data.viewmodel.BaseDataOperate
import kotlinx.coroutines.coroutineScope

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/16
 *  description :
 */
class DefOpenEyeRepository : OpenEyeRepository, BaseDataOperate() {

    private val api by lazy { OpenEyeClient.mService }

    private var url: String = "http://baobab.kaiyanapp.com/api/v5/index/tab/allRec"
    private var nextUrl: String = ""

    /**
     * 将服务器数据转接为BaseResult类型
     */
    suspend fun <T : Any> convert(
        response: OpenEyeResponse<T>
    ): BaseResult<T> {
        return coroutineScope {
            nextUrl = response.nextPageUrl
            BaseResult.Success(data = response.itemList)
        }
    }

    override suspend fun getRecommend(isRefresh: Boolean): BaseResult<MutableList<OpenRecBean>> {
        if (isRefresh) nextUrl = ""
        return execute { convert(api.getOpenEyeDaily(if (nextUrl.isEmpty()) url else nextUrl)) }
    }
}