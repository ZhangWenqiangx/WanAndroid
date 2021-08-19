package com.example.module_usercenter.fragment

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common_base.base.mvvm.BaseMvvmFragment
import com.example.common_base.constants.AConstance
import com.example.common_base.util.ToastUtil
import com.example.module_usercenter.MineViewModel
import com.example.module_usercenter.R
import com.example.module_usercenter.adapter.MineSettingAdapter
import com.example.module_usercenter.databinding.MineFragmentBinding
import io.flutter.embedding.android.FlutterActivity

@Route(path = AConstance.FRAGMENT_URL_MINE)
class MineFragment : BaseMvvmFragment<MineFragmentBinding, MineViewModel>() {

    private lateinit var mAdapter: MineSettingAdapter

    override fun initView(view: View?) {
        mAdapter = MineSettingAdapter(R.layout.mine_item_setting)
        viewDataBinding.mineRvSetting.apply {
            layoutManager = object : LinearLayoutManager(requireContext()) {
                override fun canScrollVertically(): Boolean = false
            }
            adapter = mAdapter
            isNestedScrollingEnabled = false
            setHasFixedSize(true)
        }

        val settingList = mutableListOf(
            "我的积分",
            "我的分享",
            "我的搜藏",
            "TODO",
            "关于作者",
            "系统设置"
        )
        mAdapter.setNewInstance(settingList)
        mAdapter.setOnItemClickListener { _, _, position ->
            ToastUtil.showToast(requireContext(), position.toString())
        }

        viewDataBinding.mineImageview.apply {
            setOnClickListener {
                startActivity(
                    FlutterActivity.withCachedEngine("engine_id").build(requireContext())
                )
            }

            setOnLongClickListener {
                ARouter.getInstance().build(AConstance.ACTIVITY_URL_LOGIN).navigation()
                true
            }
        }

    }

    override fun getLayoutResId(): Int = R.layout.mine_fragment

    override fun createViewModel(): MineViewModel = MineViewModel()
}
