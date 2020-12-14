package com.example.module_video.recommed

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.common_base.base.data.viewmodel.BaseViewModel
import com.example.common_base.base.data.viewmodel.ErrorState
import com.example.common_base.base.data.viewmodel.SuccessState
import com.example.common_base.base.mvvm.BaseMvvmFragment
import com.example.module_video.R
import com.example.module_video.databinding.FragmentRecommendBinding

class RecommendFragment : BaseMvvmFragment<FragmentRecommendBinding, BaseViewModel>() {


    override fun createViewModel(): BaseViewModel {
        return BaseViewModel()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecycler()
        initRefresh()
    }

    override fun getLayoutResId(): Int = R.layout.fragment_recommend

    private fun initRefresh() {
//        srl_refresh.apply {
//            setOnRefreshListener {
//                viewModel.getArticles(isRefresh = true)
//                viewModel.getBanner()
//            }
//            setOnLoadMoreListener { viewModel.getArticles() }
//            setEnableLoadMore(true)
//            setEnableRefresh(true)
//            autoRefresh()
//        }
    }

    private fun initRecycler() {
//        mAdapter = RecommendAdapter(R.layout.item_home_recycler)
//        rv_content.apply {
//            addItemDecoration(
//                LinearItemDecoration(requireContext()).color(
//                    ContextCompat.getColor(requireContext(), R.color.gray_ea)
//                )
//                    .height(1f)
//                    .margin(15f, 15f)
//                    .jumpPositions(arrayOf(0))
//            )
//            layoutManager = LinearLayoutManager(requireContext())
//            adapter = mAdapter
//        }
//        headerView = layoutInflater.inflate(R.layout.layout_home_header, null, false)
//        mAdapter.addHeaderView(headerView)
//
//        mAdapter.setOnItemClickListener { adapter, _, position ->
//            WebViewActivity.launch(requireActivity(), (adapter.data[position] as Article).link)
//        }
    }

    override fun addObserver() {
        super.addObserver()

        viewModel.mStateLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is SuccessState -> {

                }
                is ErrorState -> {

                }
                else -> {
                }
            }
        })
    }
}