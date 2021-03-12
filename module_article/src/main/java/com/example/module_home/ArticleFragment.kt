package com.example.module_home

import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common_base.base.viewmodel.BaseViewModel
import com.example.common_base.base.mvvm.BaseMvvmFragment
import com.example.common_base.constants.AConstance
import com.example.common_base.widget.TabLayoutMediator
import com.example.module_home.composite.CompositeFragment
import com.example.module_home.databinding.FragmentHomeBinding
import com.example.module_home.home.ArticleViewModel
import com.example.module_home.home.HomeFragment
import com.example.module_home.search.SearchActivity
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Home页
 */
@Route(path = AConstance.FRAGMENT_URL_HOME)
class ArticleFragment : BaseMvvmFragment<FragmentHomeBinding, BaseViewModel>() {

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

        iv_search.setOnClickListener {
            startActivity(
                Intent(
                    requireActivity(),
                    SearchActivity::class.java
                )
            )
        }
    }

    override fun getLayoutResId(): Int =
        R.layout.fragment_home

    override fun createViewModel(): BaseViewModel {
        return ArticleViewModelFactory().create(ArticleViewModel::class.java)
    }
}


