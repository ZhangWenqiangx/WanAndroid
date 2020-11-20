package com.example.module_home.ui

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common_base.base.BaseMvpFragment
import com.example.module_home.FirstPageAdapter
import com.example.module_home.FirstPageContract
import com.example.module_home.FirstPagePresenter
import com.example.module_home.R
import com.example.module_home.bean.Article
import kotlinx.android.synthetic.main.fragment_first_page.*

class FirstPageFragment : BaseMvpFragment<FirstPagePresenter>(),
    FirstPageContract.View {

    private lateinit var adapter: FirstPageAdapter

    private var mCurPage = 0

    override fun initView(view: View?) {
        adapter = FirstPageAdapter(R.layout.item_home_recycler)
        adapter.loadMoreModule.apply {}

        rv_content.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapter
        }
    }

    override fun initData() {
        super.initData()
        presenter.getArticles(mCurPage)
    }

    override fun onGetArticles(page: Int, list: List<Article>?) {
        adapter.loadMoreModule.loadMoreComplete()
        mCurPage = page + 1
        adapter.setNewInstance(list = list?.toMutableList())
    }

    override fun getLayoutResId(): Int = R.layout.fragment_first_page

    override fun createPresenter(): FirstPagePresenter = FirstPagePresenter()
}