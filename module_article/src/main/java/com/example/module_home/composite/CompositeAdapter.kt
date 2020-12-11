package com.example.module_home.composite

import android.os.Build
import android.text.Html
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.common_base.widget.GlideRoundTransform
import com.example.module_home.R
import com.example.module_home.composite.bean.Project

/**
 * @describe :
 *
 * @author zwq 2020/11/20
 */
class CompositeAdapter(layoutResId: Int) : BaseQuickAdapter<Project, BaseViewHolder>(layoutResId) {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun convert(holder: BaseViewHolder, item: Project) {
        holder.setText(R.id.tv_title, Html.fromHtml(item.title, Html.FROM_HTML_MODE_LEGACY))
            .setText(R.id.tv_author, item.author)

        Glide.with(holder.itemView)
            .load(item.envelopePic)
            .placeholder(R.drawable.img_def)
            .into(holder.getView(R.id.iv_envelope))
    }
}