package com.example.common_base.web

import android.app.Activity
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.LinearLayout
import com.example.common_base.R
import com.example.common_base.base.BaseActivity
import com.example.common_base.util.dp2px
import kotlinx.android.synthetic.main.activity_web_view.*

const val URL = "url"

/**
 * 通用web
 * todo:右上角设置按钮  分享、收藏
 */
class WebViewActivity : BaseActivity() {

    companion object {
        fun launch(activity: Activity, url: String) {
            val intent = Intent(activity, WebViewActivity::class.java)
            intent.putExtra(URL, url)
            activity.startActivity(intent)
        }
    }

    private lateinit var webView: CommonWebView

    override fun getLayoutResId(): Int = R.layout.activity_web_view

    override fun initView() {
        setStatusColor(this, isTranslate = false, isDarkText = true)

        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.elevation = dp2px(this, 5f)
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener { onBack() }

        webView = CommonWebView(this.applicationContext)
        webView.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        webView.setWebViewCallback(object : CommonWebView.OnWebViewCallback {
            override fun onReceivedTitle(view: WebView?, title: String?) {
                toolbar.title = title
            }
        })
        webView.addLifecycleObserver(this)

        fl_content.addView(webView)
    }

    fun onBack() {
        val canGoBack = webView.canGoBack()
        if (canGoBack) {
            webView.goBack()
        } else {
            finish()
        }
    }

    /**
     * 菜单项点击事件
     */
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.item_more) {
//            showMoreDialog()
        }
        return true
    }

    /**
     * 创建菜单
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_web, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        onBack()
    }

    override fun initData() {
        val stringExtra = intent.getStringExtra(URL)
        webView.loadUrl(stringExtra)
    }
}