package com.example.module_home.search

import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common_base.base.mvvm.BaseBindFragment
import com.example.common_base.base.viewmodel.ErrorState
import com.example.common_base.base.viewmodel.SuccessState
import com.example.common_base.web.WebViewActivity
import com.example.common_base.widget.LinearItemDecoration
import com.example.module_home.R
import com.example.module_home.databinding.FragmentSearchResultBinding
import com.example.module_home.search.adapter.SearchResultAdapter
import com.example.module_home.search.bean.SearchResult
import kotlinx.android.synthetic.main.fragment_search_result.*

/**
 * 搜索结果页
 */
class SearchResultFragment : BaseBindFragment<FragmentSearchResultBinding, SearchViewModel>() {

    private lateinit var mAdapter: SearchResultAdapter

    override fun getLayoutResId(): Int = R.layout.fragment_search_result

    override fun initView(view: View?) {
        mAdapter = SearchResultAdapter(R.layout.item_home_recycler)

        srl_refresh.apply {
            setOnRefreshListener { viewModel.searchByKey(viewModel.searchKey.value!!, true) }
            setOnLoadMoreListener { viewModel.searchByKey(viewModel.searchKey.value!!) }
            setEnableLoadMore(true)
            setEnableRefresh(true)
        }

        rv_search.apply {
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
            WebViewActivity.launch(requireActivity(), (adapter.data[position] as SearchResult).link)
        }
    }

    override fun addObserver() {
        viewModel.searchKey.observe(viewLifecycleOwner, Observer {
            srl_refresh.autoRefresh()
        })

        viewModel.searchData.observe(viewLifecycleOwner, Observer {
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

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (hidden) {
            viewModel.clearSearchData()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SearchResultFragment()
    }

    override fun createViewModel(): SearchViewModel {
        val viewModel: SearchViewModel by activityViewModels()
        return viewModel
    }
}