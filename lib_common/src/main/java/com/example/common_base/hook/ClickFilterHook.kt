package com.example.common_base.hook

import android.util.Log
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect

/**
 * Description:aop拦截多次点击按钮导致异常
 */
@Aspect
class ClickFilterHook{

    private var sLastclick = 0L
    private val FILTER_TIMEM = 1000L

    /**
     * Pointcuts    切面,即需要处理的问题类型 如:execution(*android.view.View.OnClickListener.onCLick(..))
     * advice       before():在切入点之前操作 after():在切入点之后操作 around():完全替换函数(可以手动再调用原函数)
     * Join Points  切入点 包括函数、变量、代码块
     */
    @Around("execution(* android.view.View.OnClickListener.onClick(..))")
    fun clickFilterHook(joinPoint : ProceedingJoinPoint){
        if (System.currentTimeMillis() - sLastclick >= FILTER_TIMEM){
            sLastclick = System.currentTimeMillis()
            joinPoint.proceed()
        }else{
            Log.d("99788/aspect","已过滤重复点击事件")
        }
    }
    /**
     * 建议clickFilterHook加Object类型的返回值，joinPoint.proceed()改成return joinpoint.proceed(joinpoint.args)，
     * 否则onClick参数应该会为null。我没测试，不过应该跟SpringBoot一样吧。这个库真的棒，谢谢。
     */
}