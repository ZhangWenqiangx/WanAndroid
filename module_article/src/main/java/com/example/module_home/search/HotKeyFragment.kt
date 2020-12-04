package com.example.module_home.search

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.common_base.base.mvvm.BaseBindFragment
import com.example.common_base.util.ToastUtil
import com.example.module_home.R
import com.example.module_home.databinding.FragmentHotKeyBinding
import com.example.module_home.search.adapter.HotKeyAdapter
import com.example.module_home.search.adapter.SearchHistoryAdapter
import com.google.android.flexbox.FlexboxLayoutManager
import kotlinx.android.synthetic.main.fragment_hot_key.*

/**
 * 热词、历史查询
 */
class HotKeyFragment : BaseBindFragment<FragmentHotKeyBinding>() {

    private lateinit var footerView: View
    private val viewModel: SearchViewModel by activityViewModels()

    private lateinit var mAdapter: HotKeyAdapter
    private lateinit var mHisAdapter: SearchHistoryAdapter

    override fun getLayoutResId(): Int = R.layout.fragment_hot_key

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAdapter = HotKeyAdapter(R.layout.item_hot_key)
        mHisAdapter = SearchHistoryAdapter(R.layout.item_search_history)
        footerView = layoutInflater.inflate(R.layout.layout_history_footer, null, false)
        footerView.findViewById<TextView>(R.id.tv_clear).setOnClickListener {
            ToastUtil.showShortToast(requireContext(),"click")
        }
//        mHisAdapter.addFooterView(footerView)

        rv_hot.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = mAdapter
        }

        rv_history.apply {
            val flexboxLayoutManager = FlexboxLayoutManager(requireContext())
            layoutManager = flexboxLayoutManager
            adapter = mHisAdapter
        }

        //热门
        viewModel.hotKeyData.observe(viewLifecycleOwner, Observer {
            mAdapter.setList(it)
        })
        //历史
        viewModel.historyKeyData.observe(viewLifecycleOwner, Observer {
//            mHisAdapter.setList(it)
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = HotKeyFragment()
    }

}