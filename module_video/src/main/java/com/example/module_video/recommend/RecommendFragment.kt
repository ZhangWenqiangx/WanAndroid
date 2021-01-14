package com.example.module_video.recommend

import android.os.Bundle
import android.widget.AbsListView.OnScrollListener.SCROLL_STATE_IDLE
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.common_base.base.data.viewmodel.ErrorState
import com.example.common_base.base.data.viewmodel.SuccessState
import com.example.common_base.base.mvvm.BaseMvvmFragment
import com.example.common_base.widget.LinearItemDecoration
import com.example.module_video.R
import com.example.module_video.data.DefOpenEyeRepository
import com.example.module_video.databinding.FragmentRecommendBinding

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