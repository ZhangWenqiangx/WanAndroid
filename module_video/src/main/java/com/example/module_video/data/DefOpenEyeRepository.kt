package com.example.module_video.data

import com.example.common_base.base.data.BaseResult
import com.example.common_base.base.viewmodel.BaseDataOperate
import com.example.module_video.recommend.bean.OpenRecBean
import kotlinx.coroutines.coroutineScope

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/16
 *  description :
 */
class DefOpenEyeRepository : OpenEyeRepository, BaseDataOperate() {

    private val api by lazy { OpenEyeClient.mService }

    private var recUrl: String = OPEN_EYE_BASE_URL + "api/v5/index/tab/allRec"
    private var repliesUrl: String = OPEN_EYE_BASE_URL + "api/v2/replies/video?videoId="

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
        return execute { convert(api.getOpenEyeDaily(if (nextUrl.isEmpty()) recUrl else nextUrl)) }
    }

    override suspend fun getRelatedVideo(id: Int): BaseResult<MutableList<OpenRecBean>> {
        return execute { convert(api.getOpenEyeRelatedVideo(id)) }
    }

    override suspend fun getRelatedReplies(
        isLoadMore: Boolean,
        id: Int
    ): BaseResult<MutableList<OpenRecBean>> {
        if (isLoadMore) nextUrl = ""
//        return execute { convert(api.getOpenEyeRelatedReplies(if (nextUrl.isEmpty()) repliesUrl else nextUrl)) }
        return execute { convert(api.getOpenEyeRelatedReplies(repliesUrl + id.toString())) }
    }
}