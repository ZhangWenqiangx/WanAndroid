package com.example.module_home.home

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common_base.base.mvvm.BaseMvvmFragment
import com.example.common_base.base.data.viewmodel.ErrorState
import com.example.common_base.base.data.viewmodel.SuccessState
import com.example.common_base.web.WebViewActivity
import com.example.common_base.widget.LinearItemDecoration
import com.example.module_home.R
import com.example.module_home.ArticleViewModelFactory
import com.example.module_home.databinding.FragmentFirstPageBinding
import com.example.module_home.home.adapter.RecommendAdapter
import com.example.module_home.home.adapter.HomeBannerAdapter
import com.example.module_home.home.bean.Article
import com.example.module_home.home.bean.BannerBean
import com.youth.banner.Banner
import com.youth.banner.indicator.RectangleIndicator
import kotlinx.android.synthetic.main.fragment_first_page.*

/**
 * 文章model首页
 */
class HomeFragment : BaseMvvmFragment<FragmentFirstPageBinding, ArticleViewModel>() {

    private lateinit var headerView: View
    private lateinit var mAdapter: RecommendAdapter
    private lateinit var mBanner: Banner<BannerBean, HomeBannerAdapter>

    override fun createViewModel(): ArticleViewModel {
        return ArticleViewModelFactory().create(ArticleViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecycler()
        initBanner()
        initRefresh()
    }

    private fun initRefresh() {
        srl_refresh.apply {
            setOnRefreshListener {
                viewModel.getArticles(isRefresh = true)
                viewModel.getBanner()
            }
            setOnLoadMoreListener { viewModel.getArticles() }
            setEnableLoadMore(true)
            setEnableRefresh(true)
            autoRefresh()
        }
    }

    private fun initBanner() {
        mBanner = headerView.findViewById(R.id.banner)
        mBanner.apply {
            addBannerLifecycleObserver(this@HomeFragment)
            adapter = HomeBannerAdapter(requireContext(), mutableListOf())
            indicator = RectangleIndicator(requireContext())
            setBannerGalleryMZ(10)
            setOnBannerListener { data, _ ->
                WebViewActivity.launch(requireActivity(), (data as BannerBean).url)
            }
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
                    .jumpPositions(arrayOf(0))
            )
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }
        headerView = layoutInflater.inflate(R.layout.layout_home_header, null, false)
        mAdapter.addHeaderView(headerView)

        mAdapter.setOnItemClickListener { adapter, _, position ->
            WebViewActivity.launch(requireActivity(), (adapter.data[position] as Article).link)
        }
    }

    override fun addObserver() {
        super.addObserver()
        viewModel.articleData.observe(viewLifecycleOwner, Observer {
            mAdapter.setList(it)
        })

        viewModel.bannersData.observe(viewLifecycleOwner, Observer {
            mBanner.setDatas(it)
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