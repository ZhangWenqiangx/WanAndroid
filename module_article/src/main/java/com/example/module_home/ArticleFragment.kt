package com.example.module_home

import android.content.Intent
import android.content.res.Resources
import android.os.Build
import android.os.Debug
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common_base.base.mvvm.BaseMvvmFragment
import com.example.common_base.constants.AConstance
import com.example.common_base.performance.TIME_MONITOR_APP_ONCREATE
import com.example.common_base.performance.TimeMonitorManager
import com.example.common_base.web.WebViewActivity
import com.example.module_home.composite.CompositeFragment
import com.example.module_home.databinding.ArticleFragmentHomeBinding
import com.example.module_home.home.ArticleViewModel
import com.example.module_home.home.HomeFragment
import com.example.module_home.home.adapter.HomeBannerAdapter
import com.example.module_home.home.bean.BannerBean
import com.example.module_home.search.SearchActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.youth.banner.indicator.RectangleIndicator
import kotlinx.android.synthetic.main.article_fragment_home.*
import kotlin.random.Random

/**
 * Home页
 */
@Route(path = AConstance.FRAGMENT_URL_HOME)
class ArticleFragment : BaseMvvmFragment<ArticleFragmentHomeBinding, ArticleViewModel>() {

    private val fragments: MutableList<Fragment> = mutableListOf()
    private val titles: MutableList<String> = mutableListOf("首页", "综合")

    @RequiresApi(Build.VERSION_CODES.M)
    override fun initView(view: View?) {
        fragments.add(HomeFragment())
        fragments.add(CompositeFragment())

        // GC使用的总耗时，单位是毫秒
        val runtimeStat = Debug.getRuntimeStat("art.gc.gc-time")
        // 阻塞式GC的总耗时
        val runtimeStat1 = Debug.getRuntimeStat("art.gc.blocking-gc-time")

        Log.d("99788", "GC使用的总耗时:$runtimeStat /阻塞式GC的总耗时:$runtimeStat1")

        pager.adapter = object :
            FragmentStateAdapter(requireActivity().supportFragmentManager, lifecycle) {
            override fun getItemCount(): Int = fragments.size

            override fun createFragment(position: Int) = fragments[position]
        }

        TabLayoutMediator(tab_layout, pager) { tab, position ->
            tab.text = titles[position]
        }.attach()

        viewDataBinding.searchInput.apply {
            queryHint = getString(R.string.str_input_key)
            setOnClickListener {
                val randomNumber = Random.nextInt(0, 101)
                 when {
                    randomNumber < 33 -> funA()
                    randomNumber < 66 -> test()
                    else -> {
                        startActivity(
                            Intent(
                                requireActivity(),
                                SearchActivity::class.java
                            )
                        )
                    }
                }
            }
        }

        viewDataBinding.banner.apply {
            val screenWidth: Int = Resources.getSystem().displayMetrics.widthPixels
            val screenHeight: Int = Resources.getSystem().displayMetrics.heightPixels
            val height = (screenWidth.coerceAtMost(screenHeight) * (9f / 16f)).toInt()
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                height
            )
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

    private fun method(i: Int) {
        if (i == 1) {
            println("1*1=1")
        } else {
            for (j in 1 until i) {
                print(j.toString() + "*" + i + "=" + j * i + " ")
            }
            println()
            method(i - 1)
        }
    }

    private fun test() {
        for (i in 0..999999) {
            val a = "1${i + 1}"
            var b = a.plus("12")
        }
        method(9)
        for (i in 0..999999) {
            val a = "2${i + 1}"
            var b = a.plus("11")
        }
        funC()
    }

    fun funA() {
        Thread.sleep(110)
        funB()
    }

    fun funB() {
        Thread.sleep(812)
        funC()
    }

    fun funC() {
        Thread.sleep(101)
    }

    override fun addObserver() {
        super.addObserver()
        viewModel.bannersData.observe(viewLifecycleOwner) {
            viewDataBinding.banner.setDatas(it)
        }
    }

    override fun getLayoutResId(): Int =
        R.layout.article_fragment_home

    override fun createViewModel(): ArticleViewModel {
        return ArticleViewModelFactory().create(ArticleViewModel::class.java)
    }
}


