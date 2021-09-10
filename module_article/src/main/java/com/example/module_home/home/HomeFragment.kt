package com.example.module_home.home

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.example.common_base.base.mvvm.BaseMvvmFragment
import com.example.common_base.base.viewmodel.ErrorState
import com.example.common_base.base.viewmodel.SuccessState
import com.example.common_base.constants.FlutterConstance
import com.example.common_base.moudle_service.UserInfoService
import com.example.common_base.performance.TIME_MONITOR_APP_ONCREATE
import com.example.common_base.performance.TimeMonitorManager
import com.example.common_base.util.ToastUtil
import com.example.common_base.web.WebViewActivity
import com.example.common_base.widget.LinearItemDecoration
import com.example.module_home.ArticleViewModelFactory
import com.example.module_home.R
import com.example.module_home.databinding.FragmentFirstPageBinding
import com.example.module_home.home.adapter.RecommendAdapter
import com.example.module_home.home.bean.Article
import com.idlefish.flutterboost.FlutterBoost
import com.idlefish.flutterboost.ListenerRemover
import kotlinx.android.synthetic.main.fragment_first_page.*

/**
 * 文章model首页
 */
class HomeFragment : BaseMvvmFragment<FragmentFirstPageBinding, ArticleViewModel>() {

    private lateinit var mAdapter: RecommendAdapter
    private lateinit var remover: ListenerRemover

    @JvmField
    @Autowired
    var userService: UserInfoService? = null

    override fun createViewModel(): ArticleViewModel {
        return ArticleViewModelFactory().create(ArticleViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecycler()
        initRefresh()
        remover = FlutterBoost.instance()
            .addEventListener(FlutterConstance.FROM_FLUTTER_EVENT_COLLECT) { _, _ ->
                viewModel.getArticles(isRefresh = true)
            }
        TimeMonitorManager.getTimeMonitor(TIME_MONITOR_APP_ONCREATE)
            .recordingTimeTag("HomeFragment-onActivityCreated-end")
    }

    private fun initRefresh() {
        srl_refresh.apply {
            setOnRefreshListener { viewModel.getArticles(isRefresh = true) }
            setOnLoadMoreListener { viewModel.getArticles() }
            setEnableLoadMore(true)
            setEnableRefresh(true)
            autoRefresh()
        }
    }

    private fun initRecycler() {
        mAdapter = RecommendAdapter(R.layout.item_home_recycler).apply {
            addChildClickViewIds(R.id.iv_home_like)
            setOnItemChildClickListener { _, view, position ->
                if (view.id == R.id.iv_home_like) {
                    val article = mAdapter.data[position]
                    article.collect = !article.collect
                    mAdapter.setData(position, article)
                    viewModel.changeCollect(article.collect, article.id)
                }
            }

            setOnItemClickListener { adapter, _, position ->
                WebViewActivity.launch(requireActivity(), (adapter.data[position] as Article).link)
            }
        }

        rv_content.apply {
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
    }

    override fun addObserver() {
        super.addObserver()
        viewModel.articleData.observe(viewLifecycleOwner, {
            mAdapter.setList(it)
        })

        viewModel.mStateLiveData.observe(viewLifecycleOwner, {
            when (it) {
                is SuccessState -> {
                    srl_refresh.finishRefresh()
                    srl_refresh.finishLoadMore()
                }
                is ErrorState -> {
                    srl_refresh.finishRefresh(false)
                    srl_refresh.finishLoadMore(false)
                    ToastUtil.showShortToast(requireContext(), it.message)
                }
                else -> {
                }
            }
        })
    }

    override fun getLayoutResId(): Int = R.layout.fragment_first_page

    override fun onDestroy() {
        super.onDestroy()
        remover.remove()
    }
}