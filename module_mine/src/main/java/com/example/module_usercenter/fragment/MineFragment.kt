package com.example.module_usercenter.fragment

import android.annotation.SuppressLint
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.bumptech.glide.Glide
import com.example.common_base.base.mvvm.BaseMvvmFragment
import com.example.common_base.constants.AConstance
import com.example.common_base.util.ToastUtil
import com.example.common_base.widget.GlideRoundTransform
import com.example.module_usercenter.MineViewModel
import com.example.module_usercenter.MineViewModelFactory
import com.example.module_usercenter.R
import com.example.module_usercenter.adapter.MineSettingAdapter
import com.example.module_usercenter.databinding.MineFragmentBinding
import com.idlefish.flutterboost.FlutterBoost
import com.idlefish.flutterboost.FlutterBoostRouteOptions
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
            "积分排行",
            "我的收藏",
            "TODO",
            "关于作者",
            "系统设置"
        )
        mAdapter.setNewInstance(settingList)
        mAdapter.setOnItemClickListener { _, _, position ->
            ToastUtil.showToast(requireContext(), position.toString())
        }

        viewDataBinding.mineTv.setOnClickListener {
            if (!viewModel.isLogin()) {
                ARouter.getInstance().build(AConstance.ACTIVITY_URL_LOGIN).navigation()
            }
        }

        viewDataBinding.mineImageview.apply {
            setOnClickListener {
                val options = FlutterBoostRouteOptions.Builder()
                    .pageName("login")
                    .arguments(hashMapOf())
                    .requestCode(11)
                    .build()
                FlutterBoost.instance().open(options);
            }
        }

        if (viewModel.isLogin()) {
            viewModel.getUserInfo()
        }
    }

    @SuppressLint("SetTextI18n")
    override fun addObserver() {
        super.addObserver()
        viewModel.userInfo.observe(this, {
            viewDataBinding.mineTv.text = it.userInfo.nickname
            viewDataBinding.mineTvLevel.text = "等级：${it.coinInfo.level}"
            viewDataBinding.mineTvRank.text = "排名：${it.coinInfo.rank}"
        })
    }

    override fun getLayoutResId(): Int = R.layout.mine_fragment

    override fun createViewModel(): MineViewModel {
        return ViewModelProvider(this, MineViewModelFactory()).get(MineViewModel::class.java)
    }
}
