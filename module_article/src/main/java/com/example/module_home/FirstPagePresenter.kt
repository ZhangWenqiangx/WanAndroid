package com.example.module_home

import android.util.Log
import com.example.common_base.base.BaseObserver
import com.example.common_base.mvp.BasePresenter
import com.example.module_home.bean.ArticleResponse

/**
 * @describe :
 *
 * @author zwq 2020/11/20
 */
class FirstPagePresenter : BasePresenter<FirstPageContract.View>(),FirstPageContract.Presenter {
    override fun getArticles(page: Int) {
        addSubscirbe(
            create(Api::class.java).getArticles(page),
            object : BaseObserver<ArticleResponse>(getView()) {
                override fun onSuccess(data: ArticleResponse?) {
                    Log.d("99788",data.toString())
                }
            })
    }
}