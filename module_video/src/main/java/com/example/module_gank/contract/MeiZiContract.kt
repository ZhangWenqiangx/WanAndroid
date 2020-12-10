package com.example.module_gank.contract

import com.example.common_base.base.mvp.IView
import com.example.module_gank.bean.MeiziResult

/**
 * Description:
 */
interface MeiZiContract {

    interface View : IView {
        fun onMeiZiList(meiziListResult: List<MeiziResult>)
    }

    interface Presenter {
        fun getMeiZiList(pageSize: Int, page: Int)
    }
}