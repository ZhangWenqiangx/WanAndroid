package com.example.module_video

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common_base.HelloService
import com.example.common_base.base.mvvm.BaseMvvmFragment
import com.example.common_base.base.viewmodel.BaseViewModel
import com.example.common_base.constants.AConstance
import com.example.common_base.util.ToastUtil
import com.example.common_base.widget.TabLayoutMediator
import com.example.module_video.databinding.FragmentVideoBinding
import com.example.module_video.recommend.RecommendFragment
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

    init {
        ARouter.getInstance().inject(this)
    }

    @JvmField
    @Autowired
    var helloService: HelloService? = null

    override fun initView(view: View?) {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ToastUtil.showToast(requireContext(), helloService?.sayHello("videoFragment"))
    }

    override fun initData() {
        super.initData()
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