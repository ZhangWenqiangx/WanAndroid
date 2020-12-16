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

    /**
     * 将服务器数据转接为BaseResult类型
     */
    suspend fun <T : Any> convert(
        response: OpenEyeResponse<T>
    ): BaseResult<T> {
        return coroutineScope {
            BaseResult.Success(data = response.itemList)
        }
    }

    override suspend fun getRecommend(): BaseResult<MutableList<OpenRecBean>> =
        execute { convert(api.getOpenEyeDaily()) }
}