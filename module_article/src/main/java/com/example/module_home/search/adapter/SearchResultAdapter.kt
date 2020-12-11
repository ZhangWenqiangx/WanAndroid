package com.example.module_home.search.adapter

import android.os.Build
import android.text.Html
import android.text.TextUtils
import androidx.annotation.RequiresApi
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.module_home.R
import com.example.module_home.search.bean.SearchResult

/**
 * @describe :
 *
 * @author zwq 2020/11/20
 */
class SearchResultAdapter(layoutResId: Int) :
    BaseQuickAdapter<SearchResult, BaseViewHolder>(layoutResId),
    LoadMoreModule {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun convert(holder: BaseViewHolder, item: SearchResult) {
        if (!TextUtils.isEmpty(item.author)) {
            holder.setText(R.id.tv_home_author, item.author)
        } else if (!TextUtils.isEmpty(item.shareUser)) {
            holder.setText(R.id.tv_home_author, item.shareUser)
        } else {
            holder.setGone(R.id.tv_home_author, true)
        }

        holder.setText(R.id.tv_home_title, Html.fromHtml(item.title,Html.FROM_HTML_MODE_LEGACY))
            .setText(R.id.tv_home_category, item.superChapterName + "-" + item.chapterName)
            .setText(R.id.tv_home_public_time, item.niceDate)
            .setGone(R.id.tv_home_recent, true)
    }
}