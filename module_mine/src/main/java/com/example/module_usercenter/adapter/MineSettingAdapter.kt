package com.example.module_usercenter.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.module_usercenter.R

/**
 *  @author : zhang.wenqiang
 *  @date : 2021/4/14
 *  description :
 */
class MineSettingAdapter(layoutResId: Int) : BaseQuickAdapter<String, BaseViewHolder>(layoutResId) {
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.mine_tv_title, item)
    }
}