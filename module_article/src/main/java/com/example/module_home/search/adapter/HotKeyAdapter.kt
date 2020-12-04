package com.example.module_home.search.adapter

import android.graphics.Typeface
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.module_home.R
import com.example.module_home.search.bean.HotKeyBean

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/4
 *  description :
 */
class HotKeyAdapter(layoutResId: Int) :
    BaseQuickAdapter<HotKeyBean, BaseViewHolder>(layoutResId),
    LoadMoreModule {

    override fun convert(holder: BaseViewHolder, item: HotKeyBean) {

        if (item.order == 1) {
            holder.setImageResource(R.id.iv_hot, R.mipmap.icon_fire)
        }

        if (item.order in 1..3) {
            holder.getView<TextView>(R.id.tv_order).typeface =
                Typeface.defaultFromStyle(Typeface.BOLD)
        }

        holder.setText(R.id.tv_order, item.order.toString())
            .setText(R.id.tv_title, item.name)
    }
}