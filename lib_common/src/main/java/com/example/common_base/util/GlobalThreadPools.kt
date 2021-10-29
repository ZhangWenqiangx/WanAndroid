package com.example.common_base.util

import com.example.lib_trace.util.LogUtils
import java.util.concurrent.*
import java.util.concurrent.atomic.AtomicInteger

/**
 * 全局使用的线程池
 */
object GlobalThreadPools {
    //初始化线程池
    private fun initThreadPool() {
        THREAD_POOL_EXECUTOR = object : ThreadPoolExecutor(
            CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE_SECONDS.toLong(), TimeUnit.SECONDS,
            sPoolWorkQueue, sThreadFactory, RejectedHandler()
        ) {
            override fun execute(command: Runnable) {
                super.execute(command)
                LogUtils.e(TAG, "ActiveCount=$activeCount")
                LogUtils.e(TAG, "PoolSize=$poolSize")
                LogUtils.e(TAG, "Queue=" + queue.size)
            }
        }
    }

    private class RejectedHandler : RejectedExecutionHandler {
        override fun rejectedExecution(r: Runnable, executor: ThreadPoolExecutor) {
            //可在这里做一些提示用户的操作
//            Log.v("+++","is over the max task...");
        }
    }

    fun execute(command: Runnable?) {
        THREAD_POOL_EXECUTOR!!.execute(command)
    }

    private val TAG = GlobalThreadPools::class.java.simpleName
    private var THREAD_POOL_EXECUTOR: ExecutorService? = null //线程池
    private val CPU_COUNT = Runtime.getRuntime().availableProcessors() //CPU数量
    private val CORE_POOL_SIZE = CPU_COUNT //核心线程数
    private val MAXIMUM_POOL_SIZE = CPU_COUNT * 2 //最大线程数
    private const val KEEP_ALIVE_SECONDS = 60 //线程闲置后的存活时间
    private val sPoolWorkQueue: BlockingQueue<Runnable> = LinkedBlockingQueue(CPU_COUNT) //任务队列
    private val sThreadFactory: ThreadFactory = object : ThreadFactory {
        //线程工厂
        private val mCount = AtomicInteger(1)
        override fun newThread(r: Runnable): Thread {
            return Thread(r, "MangoTask #" + mCount.getAndIncrement())
        }
    }

    init {
        initThreadPool()
    }
}