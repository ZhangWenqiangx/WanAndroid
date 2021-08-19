package com.example.common_base.base

import android.app.Application
import android.content.Context
import android.os.Looper
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common_base.R
import com.example.common_base.performance.BlockPrinter
import com.example.common_base.hotfix.HotFix
import com.example.common_base.performance.TIME_MONITOR_APP_ONCREATE
import com.example.common_base.performance.TimeMonitorManager
import com.example.common_base.widget.refresh.ClassicsHeader
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor


/**
 * Description:
 */
open class BaseApplication : Application() {

    companion object {
        lateinit var sApplication: Application
    }

    private lateinit var flutterEngine: FlutterEngine

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

        flutterEngine = FlutterEngine(this).apply {
            this.dartExecutor.executeDartEntrypoint(DartExecutor.DartEntrypoint.createDefault())
            FlutterEngineCache.getInstance().put("engine_id", this)
        }

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

    override fun onTerminate() {
        flutterEngine.destroy()
        super.onTerminate()
    }
}