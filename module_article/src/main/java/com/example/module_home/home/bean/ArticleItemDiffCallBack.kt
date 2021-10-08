package com.example.module_home.home.bean

import android.text.TextUtils
import androidx.recyclerview.widget.DiffUtil

/**
 *  author : zhang.wenqiang
 *  date : 2021/10/8
 *  description :
 */
class ArticleItemDiffCallBack(private val old: List<Article>, val new: List<Article>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int = old.size

    override fun getNewListSize(): Int = new.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        old[oldItemPosition].id == new[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        TextUtils.equals(old[oldItemPosition].title, new[newItemPosition].title)
}