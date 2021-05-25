package com.example.module_home.home

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common_base.base.mvvm.BaseMvvmFragment
import com.example.common_base.base.viewmodel.ErrorState
import com.example.common_base.base.viewmodel.SuccessState
import com.example.common_base.performance.TIME_MONITOR_APP_ONCREATE
import com.example.common_base.performance.TimeMonitorManager
import com.example.common_base.web.WebViewActivity
import com.example.common_base.widget.LinearItemDecoration
import com.example.module_home.ArticleViewModelFactory
import com.example.module_home.R
import com.example.module_home.databinding.FragmentFirstPageBinding
import com.example.module_home.home.adapter.RecommendAdapter
import com.example.module_home.home.bean.Article
import kotlinx.android.synthetic.main.fragment_first_page.*

/**
 * 文章model首页
 */
class HomeFragment : BaseMvvmFragment<FragmentFirstPageBinding, ArticleViewModel>() {

    private lateinit var mAdapter: RecommendAdapter

    override fun createViewModel(): ArticleViewModel {
        return ArticleViewModelFactory().create(ArticleViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecycler()
        initRefresh()
        TimeMonitorManager.getTimeMonitor(TIME_MONITOR_APP_ONCREATE)
            .recordingTimeTag("HomeFragment-onActivityCreated-end")
    }

    private fun initRefresh() {
        srl_refresh.apply {
            setOnRefreshListener {
                viewModel.getArticles(isRefresh = true)
            }
            setOnLoadMoreListener { viewModel.getArticles() }
            setEnableLoadMore(true)
            setEnableRefresh(true)
            autoRefresh()
        }
    }

    private fun initRecycler() {
        mAdapter = RecommendAdapter(R.layout.item_home_recycler)
        rv_content.apply {
            addItemDecoration(
                LinearItemDecoration(requireContext()).color(
                    ContextCompat.getColor(requireContext(), R.color.gray_ea)
                )
                    .height(1f)
                    .margin(15f, 15f)
            )
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }
        mAdapter.setOnItemClickListener { adapter, _, position ->
            WebViewActivity.launch(requireActivity(), (adapter.data[position] as Article).link)
        }
    }

    override fun addObserver() {
        super.addObserver()
        viewModel.articleData.observe(viewLifecycleOwner, Observer {
            mAdapter.setList(it)
        })

        viewModel.mStateLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is SuccessState -> {
                    srl_refresh.finishRefresh()
                    srl_refresh.finishLoadMore()
                }
                is ErrorState -> {
                    srl_refresh.finishRefresh(false)
                    srl_refresh.finishLoadMore(false)
                }
                else -> {
                }
            }
        })
    }

    override fun getLayoutResId(): Int = R.layout.fragment_first_page

}