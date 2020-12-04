package com.example.module_home.search.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.module_home.R

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/4
 *  description :
 */
class SearchHistoryAdapter(layoutResId: Int) :
    BaseQuickAdapter<String, BaseViewHolder>(layoutResId),
    LoadMoreModule {

    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.tv_content, item)
    }
}