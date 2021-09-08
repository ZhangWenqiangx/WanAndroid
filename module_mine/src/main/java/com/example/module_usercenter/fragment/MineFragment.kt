package com.example.module_usercenter.fragment

import android.annotation.SuppressLint
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common_base.base.mvvm.BaseMvvmFragment
import com.example.common_base.constants.AConstance
import com.example.common_base.constants.FlutterConstance.FLUTTER_PAGE_LOGIN
import com.example.common_base.constants.FlutterConstance.FROM_FLUTTER_EVENT_LOGIN
import com.example.common_base.constants.FlutterConstance.FLUTTER_ARG_COIN_COUNT
import com.example.module_usercenter.MineViewModel
import com.example.module_usercenter.MineViewModelFactory
import com.example.module_usercenter.R
import com.example.module_usercenter.adapter.MineSettingAdapter
import com.example.module_usercenter.bean.MenuBean
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

        mAdapter = MineSettingAdapter(R.layout.mine_item_setting).apply {
            setOnItemClickListener { _, _, position ->
                onItemClick(mAdapter.data[position])
            }
            setNewInstance(viewModel.generateMenuList())
        }

        viewDataBinding.mineRvSetting.apply {
            layoutManager = object : LinearLayoutManager(requireContext()) {
                override fun canScrollVertically(): Boolean = false
            }
            adapter = mAdapter
            isNestedScrollingEnabled = false
            setHasFixedSize(true)
        }

        viewDataBinding.mineTv.setOnClickListener {
            if (!viewModel.isLogin()) {
                ARouter.getInstance().build(AConstance.ACTIVITY_URL_LOGIN).navigation()
            }
        }

        viewDataBinding.mineImageview.apply {
            setOnClickListener { openRoute(FLUTTER_PAGE_LOGIN) }
        }

        if (viewModel.isLogin()) {
            viewModel.getUserInfo()
        }

        remover = FlutterBoost.instance().addEventListener(FROM_FLUTTER_EVENT_LOGIN) { _, _ ->
            viewModel.getUserInfo()
        }
    }

    private fun onItemClick(item: MenuBean) {
        openRoute(item.routeUrl, item.arguments)
    }

    private fun openRoute(name: String, arguments: Map<String, Any>? = mapOf()) {
        val options = FlutterBoostRouteOptions.Builder()
            .pageName(name)
            .arguments(arguments)
            .build()
        FlutterBoost.instance().open(options)
    }

    @Subscribe
    fun onLoginEvent(event: LoginEvent) {
        viewModel.getUserInfo()
    }

    @SuppressLint("SetTextI18n")
    override fun addObserver() {
        super.addObserver()
        viewModel.userInfo.observe(this, {
            val coinCount = it.userInfo.coinCount.toString()
            mAdapter.data[0].stubTitle = coinCount
            mAdapter.data[0].arguments = mapOf(FLUTTER_ARG_COIN_COUNT to coinCount)
            mAdapter.notifyItemRangeChanged(0,1)

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
