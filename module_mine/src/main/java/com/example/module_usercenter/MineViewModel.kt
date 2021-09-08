package com.example.module_usercenter

import androidx.lifecycle.MutableLiveData
import com.example.common_base.base.data.BaseResult
import com.example.common_base.base.viewmodel.BaseViewModel
import com.example.common_base.base.viewmodel.ErrorState
import com.example.common_base.constants.FlutterConstance
import com.example.common_base.util.UserHelper
import com.example.module_usercenter.api.MineRepository
import com.example.module_usercenter.bean.MenuBean
import com.example.module_usercenter.bean.UserInfoResult

/**
 *  @author : zhang.wenqiang
 *  @date : 2021/4/16
 *  description :
 */
class MineViewModel(
    private val repository: MineRepository
) : BaseViewModel() {

    val userInfo: MutableLiveData<UserInfoResult> by lazy {
        MutableLiveData<UserInfoResult>()
    }

    fun isLogin(): Boolean = UserHelper.isLogin()

    fun getUserInfo() {
        launch(tryBlock = {
            repository.getUserInfo().let {
                if (it is BaseResult.Success) {
                    userInfo.value = it.data
                } else if (it is BaseResult.Error) {
                    mStateLiveData.value = ErrorState(it.exception.message)
                }
            }
        })
    }

    fun generateMenuList(): MutableList<MenuBean> {
        return mutableListOf<MenuBean>().apply {
            add(
                MenuBean(
                    imageResId = R.drawable.ic_coin,
                    title = "我的积分",
                    routeUrl = FlutterConstance.FLUTTER_PAGE_COIN_LIST,
                )
            )
            add(
                MenuBean(
                    imageResId = R.drawable.ic_rank,
                    title = "积分排行",
                    routeUrl = FlutterConstance.FLUTTER_PAGE_COIN_RANK,
                )
            )
            add(
                MenuBean(
                    imageResId = R.drawable.ic_share,
                    title = "我的分享",
                    routeUrl = FlutterConstance.FLUTTER_PAGE_SHARE,
                )
            )
            add(
                MenuBean(
                    imageResId = R.drawable.ic_collect,
                    title = "我的收藏",
                    routeUrl = FlutterConstance.FLUTTER_PAGE_COLLECTION,
                )
            )
            add(
                MenuBean(
                    imageResId = R.drawable.ic_mine_setting,
                    title = "系统设置",
                    routeUrl = FlutterConstance.FLUTTER_PAGE_COIN_LIST,
                )
            )
        }

    }
}