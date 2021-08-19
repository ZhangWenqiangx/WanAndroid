package com.example.common_base.web

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.net.http.SslError
import android.util.AttributeSet
import android.view.ViewGroup
import android.webkit.*
import android.widget.FrameLayout
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.example.common_base.util.ToastUtil
import com.example.common_base.util.dp


/**
 *  @author : zhang.wenqiang
 *  @date : 2020/12/3
 *  description :
 */
class CommonWebView : WebView, LifecycleObserver {

    private lateinit var webProgressBar: WebProgressBar
    private var onWebViewCallback: OnWebViewCallback? = null

    constructor(context: Context) : super(context) {
        initWebSetting()
        initProgressBar()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initWebSetting()
        initProgressBar()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initWebSetting()
        initProgressBar()
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun initWebSetting() {
        this.settings.apply {
            javaScriptEnabled = true
            useWideViewPort = true
            loadWithOverviewMode = true
            setSupportZoom(true)
            builtInZoomControls = true
            displayZoomControls = false
            cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
            allowFileAccess = true
            javaScriptCanOpenWindowsAutomatically = true
            loadsImagesAutomatically = true
            defaultTextEncodingName = "utf-8"
        }

        this.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                if (newProgress == 100) {
                    webProgressBar.visibility = GONE
                } else {
                    webProgressBar.visibility = VISIBLE
                    webProgressBar.setProgress(newProgress)
                }
            }

            override fun onReceivedTitle(view: WebView?, title: String?) {
                super.onReceivedTitle(view, title)
                onWebViewCallback?.onReceivedTitle(view, title)
            }
        }

        this.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                return if (url.startsWith("http:") || url.startsWith("https:")) {
                    view.loadUrl(url)
                    false
                } else {
                    try {
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(url)
                        this@CommonWebView.context.startActivity(intent)
                    } catch (e: Exception) {
                        ToastUtil.showShortToast(this@CommonWebView.context, "暂无应用打开此链接")
                    }
                    true
                }
            }

            override fun onReceivedSslError(
                view: WebView,
                handler: SslErrorHandler,
                error: SslError
            ) {
                handler.proceed()
            }
        }
    }

    private fun initProgressBar() {
        webProgressBar = WebProgressBar(context)
        webProgressBar.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            4.dp().toInt()
        )
        addView(webProgressBar)
    }

    fun addLifecycleObserver(owner: LifecycleOwner?) {
        owner?.lifecycle?.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        this.settings.javaScriptEnabled = false
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onResume() {
        this.settings.javaScriptEnabled = true
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        loadDataWithBaseURL(null, "", "text/html", "utf-8", null)
        clearHistory()
        (this.parent as ViewGroup).removeView(this)
        this.destroy()
    }

    fun setWebViewCallback(onWebViewCallback: OnWebViewCallback) {
        this.onWebViewCallback = onWebViewCallback
    }

    interface OnWebViewCallback {
        fun onReceivedTitle(view: WebView?, title: String?)
    }
}