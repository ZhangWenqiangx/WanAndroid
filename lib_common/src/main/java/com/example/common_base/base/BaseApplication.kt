package com.example.common_base.base

import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Looper
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common_base.R
import com.example.common_base.constants.FlutterConstance.FLUTTER_PAGE_WEB
import com.example.common_base.performance.BlockPrinter
import com.example.common_base.hotfix.HotFix
import com.example.common_base.performance.TIME_MONITOR_APP_ONCREATE
import com.example.common_base.performance.TimeMonitorManager
import com.example.common_base.web.URL
import com.example.common_base.web.WebViewActivity
import com.example.common_base.widget.refresh.ClassicsHeader
import com.idlefish.flutterboost.FlutterBoost
import com.idlefish.flutterboost.FlutterBoostDelegate
import com.idlefish.flutterboost.FlutterBoostRouteOptions
import com.idlefish.flutterboost.containers.FlutterBoostActivity
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.embedding.android.FlutterActivityLaunchConfigs


/**
 * Description:
 */
open class BaseApplication : Application() {

    companion object {
        lateinit var sApplication: Application
    }

    init {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator { context, layout ->
            layout.setPrimaryColorsId(R.color.trans_10, R.color.black_999)
            ClassicsHeader(context)
        }

        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, _ ->
            ClassicsFooter(context).setDrawableSize(20f)
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        TimeMonitorManager.resetTimeMonitor(TIME_MONITOR_APP_ONCREATE)
    }

    override fun onCreate() {
        super.onCreate()
        sApplication = this
        initArouter()
        HotFix.init(this)
        Looper.getMainLooper()
            .setMessageLogging(BlockPrinter(applicationContext))

        FlutterBoost.instance().setup(this, object : FlutterBoostDelegate {
            override fun pushNativeRoute(options: FlutterBoostRouteOptions) {
                if(options.pageName().equals(FLUTTER_PAGE_WEB)){
                    val intent = Intent(
                        FlutterBoost.instance().currentActivity(),
                        WebViewActivity::class.java
                    )
                    intent.putExtra(URL,options.arguments()["url"].toString())
                    FlutterBoost.instance().currentActivity()
                        .startActivityForResult(intent, options.requestCode())
                }
            }

            override fun pushFlutterRoute(options: FlutterBoostRouteOptions) {
                val intent: Intent = FlutterBoostActivity.CachedEngineIntentBuilder(
                    FlutterBoostActivity::class.java
                )
                    .backgroundMode(FlutterActivityLaunchConfigs.BackgroundMode.transparent)
                    .destroyEngineWithActivity(false)
                    .uniqueId(options.uniqueId())
                    .url(options.pageName())
                    .urlParams(options.arguments())
                    .build(FlutterBoost.instance().currentActivity())
                FlutterBoost.instance().currentActivity().startActivity(intent)
            }
        }) { }

        TimeMonitorManager.getTimeMonitor(TIME_MONITOR_APP_ONCREATE)
            .recordingTimeTag("aplication-onCreate-end")
    }

    private fun initArouter() {
        if (isDebug()) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }

    private fun isDebug(): Boolean = true
}