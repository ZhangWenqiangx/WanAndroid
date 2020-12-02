package com.example.module_home.ui

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common_base.base.mvvm.BaseVMFragment
import com.example.common_base.util.ToastUtil
import com.example.common_base.widget.LinearItemDecoration
import com.example.module_home.FirstPageViewModel
import com.example.module_home.R
import com.example.module_home.ViewModelCreater
import com.example.module_home.adapter.FirstPageAdapter
import com.example.module_home.adapter.HomeBannerAdapter
import com.example.module_home.bean.BannerBean
import com.youth.banner.Banner
import com.youth.banner.indicator.RectangleIndicator
import kotlinx.android.synthetic.main.fragment_first_page.*

/**
 * 文章首页
 */
class FirstPageFragment : BaseVMFragment<FirstPageViewModel>() {

    private lateinit var headerView: View
    private lateinit var mAdapter: FirstPageAdapter
    private lateinit var mBanner: Banner<BannerBean, HomeBannerAdapter>

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
            addBannerLifecycleObserver(this@FirstPageFragment)
            adapter = HomeBannerAdapter(requireContext(), mutableListOf())
            indicator = RectangleIndicator(requireContext())
            setBannerGalleryMZ(10)
            setOnBannerListener { data, position ->
                ToastUtil.showCenterToast(requireContext(), position.toString() + data.toString())
            }
        }
    }

    private fun initRecycler() {
        mAdapter = FirstPageAdapter(R.layout.item_home_recycler)
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

        mAdapter.setOnItemClickListener { _, _, position ->
            ToastUtil.showCenterToast(requireContext(), position.toString())
        }
    }

    override fun addObserver() {
        super.addObserver()
        viewModel.articleData.observe(viewLifecycleOwner, Observer {
            srl_refresh.finishRefresh()
            srl_refresh.finishLoadMore()
            mAdapter.setList(it)
        })

        viewModel.bannersData.observe(viewLifecycleOwner, Observer {
            mBanner.setDatas(it)
        })
    }

    override fun getViewModelClass(): Class<FirstPageViewModel> = FirstPageViewModel::class.java

    override fun getFactory(): ViewModelProvider.Factory = ViewModelCreater()

    override fun getLayoutId(): Int = R.layout.fragment_first_page
}