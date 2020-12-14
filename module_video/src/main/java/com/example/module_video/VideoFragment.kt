package com.example.module_video

import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common_base.base.data.viewmodel.BaseViewModel
import com.example.common_base.base.mvvm.BaseMvvmFragment
import com.example.common_base.constants.AConstance
import com.example.common_base.widget.TabLayoutMediator
import com.example.module_video.databinding.FragmentVideoBinding
import com.example.module_video.recommed.RecommendFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_video.*

/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/14
 *  description :
 */
@Route(path = AConstance.FRAGMENT_URL_VIDEO)
class VideoFragment : BaseMvvmFragment<FragmentVideoBinding, BaseViewModel>() {
    private val fragments: MutableList<Fragment> = mutableListOf()
    private val titles: MutableList<String> = mutableListOf("推荐")

    override fun initView(view: View?) {
        fragments.add(RecommendFragment())

        viewDataBinding.pager.adapter = object :
            FragmentStateAdapter(requireActivity().supportFragmentManager, lifecycle) {
            override fun getItemCount(): Int = fragments.size

            override fun createFragment(position: Int) = fragments[position]
        }

        TabLayoutMediator(tab_layout, viewDataBinding.pager, object :
            TabLayoutMediator.OnConfigureTabCallback {
            override fun onConfigureTab(tab: TabLayout.Tab?, position: Int) {
                tab?.text = titles[position]
            }
        }).attach()
    }

    override fun getLayoutResId(): Int =
        R.layout.fragment_video

    override fun createViewModel(): BaseViewModel {
        return BaseViewModel()
    }
}