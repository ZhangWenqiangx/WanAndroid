package com.example.module_main.ui.fragment


import android.support.v4.app.Fragment
import android.view.View
import android.widget.ImageView
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common_base.base.BaseFragment
import com.example.common_base.widget.ZoomScrollView
import com.example.module_main.R
import kotlinx.android.synthetic.main.fragment_mine.*

/**
 * A simple [Fragment] subclass.
 *
 */
class MineFragment : BaseFragment() {

    private lateinit var backGround: ImageView
    private lateinit var scrollView: ZoomScrollView

    override fun initView(view: View?) {
        backGround = view!!.findViewById(R.id.iv_avatar_background)
        scrollView = view.findViewById(R.id.sv_scroll)
    }

    override fun initData() {
        scrollView.setZoomView(backGround)

        iv_mine_about.setOnClickListener { ARouter.getInstance().build("/gank/ImageMeiziActivity").navigation() }
        iv_mine_favorite.setOnClickListener { ARouter.getInstance().build("/main/FavoriteActivity").navigation() }
        iv_mine_meizi.setOnClickListener { ARouter.getInstance().build("/main/AboutActivity").navigation() }

    }

    override fun getLayoutResId(): Int = R.layout.fragment_mine


}
