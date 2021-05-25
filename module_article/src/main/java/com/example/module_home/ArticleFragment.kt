package com.example.module_home

import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common_base.base.mvvm.BaseMvvmFragment
import com.example.common_base.constants.AConstance
import com.example.common_base.performance.TIME_MONITOR_APP_ONCREATE
import com.example.common_base.performance.TimeMonitorManager
import com.example.common_base.web.WebViewActivity
import com.example.common_base.widget.TabLayoutMediator
import com.example.module_home.composite.CompositeFragment
import com.example.module_home.databinding.ArticleFragmentHomeBinding
import com.example.module_home.home.ArticleViewModel
import com.example.module_home.home.HomeFragment
import com.example.module_home.home.adapter.HomeBannerAdapter
import com.example.module_home.home.bean.BannerBean
import com.example.module_home.search.SearchActivity
import com.google.android.material.tabs.TabLayout
import com.youth.banner.indicator.RectangleIndicator
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Home页
 */
@Route(path = AConstance.FRAGMENT_URL_HOME)
class ArticleFragment : BaseMvvmFragment<ArticleFragmentHomeBinding, ArticleViewModel>() {

    private val fragments: MutableList<Fragment> = mutableListOf()
    private val titles: MutableList<String> = mutableListOf("首页", "综合")

    override fun initView(view: View?) {
        fragments.add(HomeFragment())
        fragments.add(CompositeFragment())

        pager.adapter = object :
            FragmentStateAdapter(requireActivity().supportFragmentManager, lifecycle) {
            override fun getItemCount(): Int = fragments.size

            override fun createFragment(position: Int) = fragments[position]
        }

        TabLayoutMediator(tab_layout, pager, object :
            TabLayoutMediator.OnConfigureTabCallback {
            override fun onConfigureTab(tab: TabLayout.Tab?, position: Int) {
                tab?.text = titles[position]
            }
        }).attach()

        viewDataBinding.searchInput.apply {
            queryHint = getString(R.string.str_input_key)
            setOnClickListener {
                startActivity(
                    Intent(
                        requireActivity(),
                        SearchActivity::class.java
                    )
                )
            }
        }

        viewDataBinding.banner.apply {
            addBannerLifecycleObserver(this@ArticleFragment)
            adapter = HomeBannerAdapter(requireContext(), mutableListOf())
            indicator = RectangleIndicator(requireContext())
            setBannerGalleryMZ(10)
            setOnBannerListener { data, _ ->
                WebViewActivity.launch(requireActivity(), (data as BannerBean).url)
            }
        }
        viewModel.getBanner()
        TimeMonitorManager.getTimeMonitor(TIME_MONITOR_APP_ONCREATE)
            .recordingTimeTag("ArticleFragment-initView-end")
    }

    override fun addObserver() {
        super.addObserver()
        viewModel.bannersData.observe(viewLifecycleOwner, {
            viewDataBinding.banner.setDatas(it)
        })
    }

    override fun getLayoutResId(): Int =
        R.layout.article_fragment_home

    override fun createViewModel(): ArticleViewModel {
        return ArticleViewModelFactory().create(ArticleViewModel::class.java)
    }
}


