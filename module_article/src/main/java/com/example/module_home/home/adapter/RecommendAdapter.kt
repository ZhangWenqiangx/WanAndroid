package com.example.module_home.home.adapter

import android.os.Build
import android.text.Html
import android.text.TextUtils
import android.view.ViewTreeObserver
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.common_base.performance.TIME_MONITOR_APP_ONCREATE
import com.example.common_base.performance.TimeMonitorManager
import com.example.module_home.R
import com.example.module_home.home.bean.Article

/**
 * @describe :
 *
 * @author zwq 2020/11/20
 */
class RecommendAdapter(layoutResId: Int) : BaseQuickAdapter<Article, BaseViewHolder>(layoutResId) {
    var mHasRecorded: Boolean = false

    @RequiresApi(Build.VERSION_CODES.N)
    override fun convert(holder: BaseViewHolder, item: Article) {
        var tip: String? = null
        if (item.type == 1) {
            tip = "置顶"
        } else if (item.fresh) {
            tip = "新"
        }
        if (!TextUtils.isEmpty(item.author)) {
            holder.setText(R.id.tv_home_author, item.author)
        } else if (!TextUtils.isEmpty(item.shareUser)) {
            holder.setText(R.id.tv_home_author, item.shareUser)
        } else {
            holder.setGone(R.id.tv_home_author, true)
        }

        holder.setText(R.id.tv_home_title, Html.fromHtml(item.title, Html.FROM_HTML_MODE_LEGACY))
            .setText(R.id.tv_home_category, item.superChapterName)
            .setText(R.id.tv_home_public_time, item.niceShareDate)
            .setGone(
                R.id.tv_home_recent,
                !((item.type == 1 || item.fresh) && !TextUtils.isEmpty(tip))
            )
            .setText(R.id.tv_home_recent, tip)
            .setImageResource(
                R.id.iv_home_like,
                if (item.collect) R.drawable.ic_like else R.drawable.ic_like_not
            )

        if (holder.layoutPosition == 1 && !mHasRecorded) {
            mHasRecorded = true
            holder.getView<TextView>(R.id.tv_home_title).viewTreeObserver.addOnPreDrawListener(
                object : ViewTreeObserver.OnPreDrawListener {
                    override fun onPreDraw(): Boolean {
                        holder.getView<TextView>(R.id.tv_home_title).viewTreeObserver.removeOnPreDrawListener(
                            this
                        )
                        TimeMonitorManager.getTimeMonitor(TIME_MONITOR_APP_ONCREATE)
                            .end("on rv show--end", true)
                        return true
                    }
                });
        }
    }
}