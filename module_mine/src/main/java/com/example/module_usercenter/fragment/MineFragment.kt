package com.example.module_usercenter.fragment

import android.annotation.SuppressLint
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common_base.base.mvvm.BaseMvvmFragment
import com.example.common_base.constants.AConstance
import com.example.common_base.constants.FlutterConstance.FLUTTER_PAGE_COIN_LIST
import com.example.common_base.constants.FlutterConstance.FLUTTER_PAGE_LOGIN
import com.example.common_base.constants.FlutterConstance.FROM_FLUTTER_EVENT_LOGIN
import com.example.common_base.constants.FlutterConstance.FLUTTER_ARG_COIN_COUNT
import com.example.common_base.util.ToastUtil
import com.example.module_usercenter.MineViewModel
import com.example.module_usercenter.MineViewModelFactory
import com.example.module_usercenter.R
import com.example.module_usercenter.adapter.MineSettingAdapter
import com.example.module_usercenter.databinding.MineFragmentBinding
import com.example.module_usercenter.event.LoginEvent
import com.idlefish.flutterboost.FlutterBoost
import com.idlefish.flutterboost.FlutterBoostRouteOptions
import com.idlefish.flutterboost.ListenerRemover
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

@Route(path = AConstance.FRAGMENT_URL_MINE)
class MineFragment : BaseMvvmFragment<MineFragmentBinding, MineViewModel>() {

    private lateinit var mAdapter: MineSettingAdapter
    private lateinit var remover: ListenerRemover

    override fun initView(view: View?) {
        EventBus.getDefault().register(this)
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
            onItemClick(position)
        }

        viewDataBinding.mineTv.setOnClickListener {
            if (!viewModel.isLogin()) {
                ARouter.getInstance().build(AConstance.ACTIVITY_URL_LOGIN).navigation()
            }
        }

        viewDataBinding.mineImageview.apply {
            setOnClickListener {
                val options = FlutterBoostRouteOptions.Builder()
                    .pageName(FLUTTER_PAGE_LOGIN)
                    .arguments(hashMapOf())
                    .requestCode(11)
                    .build()
                FlutterBoost.instance().open(options)
            }
        }

        if (viewModel.isLogin()) {
            viewModel.getUserInfo()
        }

        remover = FlutterBoost.instance().addEventListener(FROM_FLUTTER_EVENT_LOGIN) { _, _ ->
            viewModel.getUserInfo()
        }
    }

    private fun onItemClick(position: Int) {
        val options: FlutterBoostRouteOptions
        when (position) {
            0 -> {
                options = FlutterBoostRouteOptions.Builder()
                    .pageName(FLUTTER_PAGE_COIN_LIST)
                    .arguments(mapOf(FLUTTER_ARG_COIN_COUNT to coinCount.toString()))
                    .requestCode(11)
                    .build()
                FlutterBoost.instance().open(options)
            }
            else -> {

            }
        }

        ToastUtil.showToast(requireContext(), position.toString())
    }

    @Subscribe
    fun onLoginEvent(event: LoginEvent) {
        viewModel.getUserInfo()
    }

    private var coinCount: Int? = null

    @SuppressLint("SetTextI18n")
    override fun addObserver() {
        super.addObserver()
        viewModel.userInfo.observe(this, {
            coinCount = it.userInfo.coinCount
            viewDataBinding.mineTv.text = it.userInfo.nickname
            viewDataBinding.mineTvLevel.text = "等级：${it.coinInfo.level}"
            viewDataBinding.mineTvRank.text = "排名：${it.coinInfo.rank}"
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        remover.remove()
        EventBus.getDefault().unregister(this)
    }

    override fun getLayoutResId(): Int = R.layout.mine_fragment

    override fun createViewModel(): MineViewModel {
        return ViewModelProvider(this, MineViewModelFactory()).get(MineViewModel::class.java)
    }
}
