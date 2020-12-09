package com.example.module_home.search

import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common_base.base.mvvm.BaseBindFragment
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

        viewModel.searchKey.observe(viewLifecycleOwner, Observer {
            viewModel.searchByKey(it)
        })

        viewModel.searchData.observe(viewLifecycleOwner, Observer {
            srl_refresh.finishRefresh()
            srl_refresh.finishLoadMore()
            mAdapter.setList(it)
        })
    }

    override fun addObserver() {

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SearchResultFragment()
    }

    override fun createViewModel(): SearchViewModel {
        val viewModel: SearchViewModel by activityViewModels()
        return viewModel
    }
}