package com.example.module_home.composite

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.common_base.base.mvvm.BaseMvvmFragment
import com.example.common_base.base.viewmodel.CompleteState
import com.example.common_base.base.viewmodel.ErrorState
import com.example.common_base.base.viewmodel.SuccessState
import com.example.common_base.web.WebViewActivity
import com.example.module_home.ArticleViewModelFactory
import com.example.module_home.R
import com.example.module_home.composite.bean.Project
import com.example.module_home.databinding.FragmentCompositePageBinding
import com.example.module_home.home.ArticleViewModel
import kotlinx.android.synthetic.main.fragment_composite_page.*

private const val CID = "cid"

/**
 * 综合
 */
class CompositePageFragment : BaseMvvmFragment<FragmentCompositePageBinding, ArticleViewModel>() {

    private var mCurPage: Int = 1
    private var cid: Int = 0
    private lateinit var mAdapter: CompositeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cid = arguments?.getInt(CID) ?: 0
    }

    override fun initData() {
        srl_composite.autoRefresh()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRefresh()
        initRecycler()
    }

    private fun initRefresh() {
        srl_composite.apply {
            setOnRefreshListener {
                mCurPage = 1
                viewModel.getTreeNode(mCurPage, cid)
            }
            setOnLoadMoreListener {
                viewModel.getTreeNode(mCurPage + 1, cid)
            }
            setEnableLoadMore(true)
            setEnableRefresh(true)
        }
    }

    private fun initRecycler() {
        mAdapter = CompositeAdapter(R.layout.item_composite)
        rv_page.apply {
            layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
            adapter = mAdapter
        }

        mAdapter.setOnItemClickListener { adapter, _, position ->
            WebViewActivity.launch(requireActivity(), (adapter.data[position] as Project).link)
        }
    }

    override fun addObserver() {
        super.addObserver()
        viewModel.treeNodeData.observe(this, Observer {
            if (mCurPage == 1) {
                mAdapter.setList(it)
            } else {
                mAdapter.addData(it)
            }
        })
        viewModel.mStateLiveData.observe(this, Observer {
            when (it) {
                is SuccessState -> {
                    mCurPage += 1
                    srl_composite.finishRefresh()
                    srl_composite.finishLoadMore()
                }
                is ErrorState -> {
                    mCurPage = 0
                    srl_composite.finishRefresh(false)
                    srl_composite.finishLoadMore(false)
                }
                is CompleteState -> {
                    srl_composite.finishRefreshWithNoMoreData()
                }
                else -> {
                }
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(cid: Int) =
            CompositePageFragment().apply {
                arguments = Bundle().apply {
                    putInt(CID, cid)
                }
            }
    }

    override fun createViewModel(): ArticleViewModel {
        return ArticleViewModelFactory().create(ArticleViewModel::class.java)
    }

    override fun getLayoutResId(): Int = R.layout.fragment_composite_page

}