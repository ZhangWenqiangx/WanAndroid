package com.example.module_home.adapter

import android.text.TextUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.module_home.R
import com.example.module_home.bean.Article

/**
 * @describe :
 *
 * @author zwq 2020/11/20
 */
class FirstPageAdapter(layoutResId: Int) : BaseQuickAdapter<Article, BaseViewHolder>(layoutResId),
    LoadMoreModule {
    override fun convert(holder: BaseViewHolder, item: Article) {
        var tip: String? = null
        if (item.type == 1) {
            tip = "置顶"
        } else if (item.fresh) {
            tip = "最新"
        }

        if (!TextUtils.isEmpty(item.author)) {
            holder.setText(R.id.tv_home_author, item.author)
        } else if (!TextUtils.isEmpty(item.shareUser)) {
            holder.setText(R.id.tv_home_author, item.shareUser)
        } else {
            holder.setGone(R.id.tv_home_author, true)
        }

        holder.setText(R.id.tv_home_title, item.title)
            .setText(R.id.tv_home_category, item.superChapterName)
            .setText(R.id.tv_home_public_time, item.niceShareDate)
            .setGone(
                R.id.tv_home_recent,
                !((item.type == 1 || item.fresh) && !TextUtils.isEmpty(tip))
            )
            .setText(R.id.tv_home_recent, tip)
    }
}