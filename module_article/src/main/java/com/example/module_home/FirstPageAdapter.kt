package com.example.module_home

import android.text.TextUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.module_home.bean.Article

/**
 * @describe :
 *
 * @author zwq 2020/11/20
 */
class FirstPageAdapter(layoutResId: Int) :BaseQuickAdapter<Article, BaseViewHolder>(layoutResId),LoadMoreModule{
    override fun convert(holder: BaseViewHolder, item: Article) {

    }
}