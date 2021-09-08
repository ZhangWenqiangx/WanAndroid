package com.example.module_usercenter.adapter

import android.widget.ImageView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.module_usercenter.R
import com.example.module_usercenter.bean.MenuBean

/**
 *  @author : zhang.wenqiang
 *  @date : 2021/4/14
 *  description :
 */
class MineSettingAdapter(layoutResId: Int) :
    BaseQuickAdapter<MenuBean, BaseViewHolder>(layoutResId) {
    override fun convert(holder: BaseViewHolder, item: MenuBean) {
        holder.setText(R.id.mine_tv_title, item.title)
        holder.setText(R.id.mine_tv_stub_title, item.stubTitle)
        holder.getView<ImageView>(R.id.mine_iv_icon).setBackgroundResource(item.imageResId)
        if (!item.showRightIcon) {
            holder.setVisible(R.id.mine_arrow_right, isVisible = false)
        }
    }
}