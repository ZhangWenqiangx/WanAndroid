package com.example.module_video.recommend

import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common_base.base.mvvm.BaseMvvmFragment
import com.example.common_base.base.viewmodel.ErrorState
import com.example.common_base.base.viewmodel.SuccessState
import com.example.common_base.widget.LinearItemDecoration
import com.example.module_video.R
import com.example.module_video.VideoViewModelFactory
import com.example.module_video.databinding.FragmentRecommendBinding
import com.example.module_video.recommend.adapter.RecommendVideoMultiAdapter

/**
 * 视频推荐页
 */
class RecommendFragment : BaseMvvmFragment<FragmentRecommendBinding, OpenEyeViewModel>() {

    var mAdapter: RecommendVideoMultiAdapter? = null

    override fun createViewModel(): OpenEyeViewModel {
        return ViewModelProvider(this, VideoViewModelFactory()).get(OpenEyeViewModel::class.java)
    }

    override fun initData() {
        super.initData()
        viewDataBinding.srlRefresh.autoRefresh()
    }

    override fun initView(view: View?) {
        super.initView(view)
        initRecycler()
        initRefresh()
    }

    override fun getLayoutResId(): Int = R.layout.fragment_recommend

    private fun initRefresh() {
        viewDataBinding.srlRefresh.apply {
            setOnRefreshListener {
                viewModel.getRecommendData(true)
            }
            setOnLoadMoreListener {
                viewModel.getRecommendData()
            }
            setEnableLoadMore(true)
            setEnableRefresh(true)
        }
    }

    private fun initRecycler() {
        mAdapter = RecommendVideoMultiAdapter()
        viewDataBinding.rvContent.apply {
            addItemDecoration(
                LinearItemDecoration(requireContext()).color(
                    ContextCompat.getColor(requireContext(), R.color.gray_ea)
                )
                    .height(1f)
                    .margin(12f, 12f)
            )
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }
    }

    override fun addObserver() {
        super.addObserver()

        viewModel.recommentData.observe(this, {
            mAdapter?.setNewInstance(it)
        })

        viewModel.recommentMoreDatas.observe(this, {
            mAdapter?.addData(it)
        })

        viewModel.mStateLiveData.observe(viewLifecycleOwner, {
            when (it) {
                is SuccessState -> {
                    viewDataBinding.srlRefresh.finishRefresh()
                    viewDataBinding.srlRefresh.finishLoadMore()
                }
                is ErrorState -> {
                    viewDataBinding.srlRefresh.finishRefresh(false)
                    viewDataBinding.srlRefresh.finishLoadMore(false)
                }
                else -> {
                }
            }
        })
    }
}