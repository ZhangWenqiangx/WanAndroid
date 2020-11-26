package com.example.module_home

import com.example.common_base.base.BaseResponse
import com.example.common_base.http.RetrofitClient
import com.example.module_home.bean.ArticleResponse
import javax.inject.Inject

/**
 * @describe :
 *
 * @author zwq 2020/11/23
 */
class FirstPageRepository @Inject constructor(){

    suspend fun getArticles(page: Int): BaseResponse<ArticleResponse> {
        val service = RetrofitClient.getInstance().retrofit.create(Api::class.java)
        return service.getArticles(page)
    }
}