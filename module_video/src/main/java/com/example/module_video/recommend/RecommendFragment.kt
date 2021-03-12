package com.example.module_video.recommend

import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common_base.base.viewmodel.ErrorState
import com.example.common_base.base.viewmodel.SuccessState
import com.example.common_base.base.mvvm.BaseMvvmFragment
import com.example.common_base.widget.LinearItemDecoration
import com.example.module_video.R
import com.example.module_video.data.DefOpenEyeRepository
import com.example.module_video.databinding.FragmentRecommendBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.youth.banner.util.LogUtils

class RecommendFragment : BaseMvvmFragment<FragmentRecommendBinding, OpenEyeViewModel>() {

    var mAdapter: RecommendMuAdapter? = null

    override fun createViewModel(): OpenEyeViewModel {
        return OpenEyeViewModel(DefOpenEyeRepository())
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
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
            autoRefresh()
        }
    }

    private fun initRecycler() {
        mAdapter = RecommendMuAdapter(mutableListOf())
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
        mAdapter?.setOnItemClickListener { _, _, position ->
            LogUtils.d(position.toString())
        }
    }

    override fun addObserver() {
        super.addObserver()

        viewModel.recommentData.observe(this, Observer {
            mAdapter?.setList(it)
        })

        viewModel.mStateLiveData.observe(viewLifecycleOwner, Observer {
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