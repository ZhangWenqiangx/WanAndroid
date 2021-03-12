package com.example.module_usercenter.fragment


import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common_base.base.BaseFragment
import com.example.common_base.constants.AConstance
import com.example.module_usercenter.R
import kotlinx.android.synthetic.main.mine_fragment.*

@Route(path = AConstance.FRAGMENT_URL_MINE)
class MineFragment : BaseFragment() {

    override fun initView(view: View?) {
        iv_avatar.setOnClickListener {
            ARouter.getInstance()
                .build(AConstance.ACTIVITY_URL_LOGIN).navigation()
        }
    }

    override fun initData() {
    }

    override fun getLayoutResId(): Int =
        R.layout.mine_fragment
}
