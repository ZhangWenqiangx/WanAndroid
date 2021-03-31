package com.example.module_video.videoDetail

import androidx.lifecycle.MutableLiveData
import com.example.common_base.base.data.BaseResult
import com.example.common_base.base.viewmodel.BaseViewModel
import com.example.common_base.base.viewmodel.SuccessState
import com.example.module_video.data.OpenEyeRepository
import com.example.module_video.recommend.bean.OpenRecBean

/**
 *  @author : zhang.wenqiang
 *  @date : 2021/3/12
 *  description :
 */
class VideoPlayViewModel(
    private val repository: OpenEyeRepository
) : BaseViewModel() {

    /**
     * 视频ID
     */
    var videoId: Int = 0

    /**
     * 相关数据
     */
    val relatedData: MutableLiveData<MutableList<OpenRecBean>> by lazy {
        MutableLiveData<MutableList<OpenRecBean>>()
    }
    val relatedAllListData = mutableListOf<OpenRecBean>()
    val relatedListData = mutableListOf<OpenRecBean>()

    fun loadData() {
        launch(tryBlock = {
            repository.getRelatedVideo(videoId).let {
                if (it is BaseResult.Success) {
                    it.data.let { list ->
                        relatedAllListData.addAll(list)
                        relatedListData.addAll(list.subList(0, 6))
                        relatedListData.add(OpenRecBean().apply { type = "more" })
                    }
                    mStateLiveData.value = SuccessState
                }
            }
            repository.getRelatedReplies(isLoadMore = false, id = videoId).let {
                if (it is BaseResult.Success) {
                    it.data.let { list ->
                        relatedListData.addAll(list)
                    }
                    relatedData.value = relatedListData
                    mStateLiveData.value = SuccessState
                }
            }
        })
    }

    fun getRelatedReplies(isLoadMore: Boolean = false) {
        launch(tryBlock = {
            repository.getRelatedReplies(isLoadMore = isLoadMore, id = videoId).let {
                if (it is BaseResult.Success) {
                    it.data.let { list ->
                        relatedListData.addAll(list)
                    }
                    relatedData.value = relatedListData
                    mStateLiveData.value = SuccessState
                }
            }
        })
    }
}