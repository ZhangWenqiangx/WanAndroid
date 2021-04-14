package com.example.module_usercenter.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.common_base.base.mvvm.BaseMvvmFragment
import com.example.common_base.base.viewmodel.BaseViewModel
import com.example.common_base.constants.AConstance
import com.example.module_usercenter.R
import com.example.module_usercenter.adapter.MineSettingAdapter
import com.example.module_usercenter.databinding.MineFragmentBinding

@Route(path = AConstance.FRAGMENT_URL_MINE)
class MineFragment : BaseMvvmFragment<MineFragmentBinding, BaseViewModel>() {

    private lateinit var mAdapter: MineSettingAdapter

    override fun initView(view: View?) {
        mAdapter = MineSettingAdapter(R.layout.mine_item_setting)
        viewDataBinding.mineRvSetting.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }
    }

    override fun initData() {
        val settingList = mutableListOf("我的积分", "我的分享", "我的搜藏", "TODO", "关于作者", "系统设置")
        mAdapter.setNewInstance(settingList)
    }

    override fun getLayoutResId(): Int = R.layout.mine_fragment

    override fun createViewModel(): BaseViewModel = BaseViewModel()
}
