package com.example.module_home.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.common_base.base.mvvm.BaseBindFragment
import com.example.module_home.R
import com.example.module_home.databinding.FragmentHotKeyBinding
import com.example.module_home.search.adapter.HotKeyAdapter
import com.example.module_home.search.adapter.SearchHistoryAdapter
import com.example.module_home.search.bean.HotKeyBean
import com.google.android.flexbox.FlexboxLayoutManager
import kotlinx.android.synthetic.main.fragment_hot_key.*

/**
 * 热词、历史查询
 * todo 1.搜索历史做本地存储
 */
class HotKeyFragment : BaseBindFragment<FragmentHotKeyBinding, SearchViewModel>() {

    private lateinit var mAdapter: HotKeyAdapter
    private lateinit var mHisAdapter: SearchHistoryAdapter

    override fun getLayoutResId(): Int = R.layout.fragment_hot_key

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mAdapter = HotKeyAdapter(R.layout.item_hot_key)
        mHisAdapter = SearchHistoryAdapter(R.layout.item_search_history)

        rv_hot.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = mAdapter
        }

        mAdapter.setOnItemClickListener { adapter, _, position ->
            (activity as SearchActivity).search(msg = (adapter.data[position] as HotKeyBean).name,submit = true)
        }

        rv_history.apply {
            val flexboxLayoutManager = FlexboxLayoutManager(requireContext())
            layoutManager = flexboxLayoutManager
            adapter = mHisAdapter
        }
    }

    override fun addObserver() {
        //热门
        viewModel.hotKeyData.observe(viewLifecycleOwner, Observer {
            mAdapter.setList(it)

            if(it.isNotEmpty()){
                tv_hot_key.visibility = View.VISIBLE
            }else{
                tv_hot_key.visibility = View.GONE
            }
        })
        //历史
        viewModel.historyData.observe(viewLifecycleOwner, Observer {
            mHisAdapter.setList(it)
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = HotKeyFragment()
    }

    override fun createViewModel(): SearchViewModel {
        val viewModel: SearchViewModel by activityViewModels()
        return viewModel
    }
}