package com.example.module_home

import com.example.common_base.mvp.IView
import com.example.module_home.bean.Article

/**
 * @describe :
 *
 * @author zwq 2020/11/20
 */
interface FirstPageContract {
    interface View : IView {
        fun onGetArticles(page: Int, list: List<Article>?)
    }

    interface Presenter {
        fun getArticles(page: Int)
    }
}