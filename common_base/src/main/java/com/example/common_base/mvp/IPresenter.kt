package com.example.common_base.mvp

/**
 * Description:
 */
interface IPresenter<V: IView> {
    /**
     * 绑定 View ，一般在初始化时调用
     *
     * @param view
     */
    fun attachView(view: V)

    /**
     * 解除绑定 View,一般在 onDestroy 中调用
     */
    fun detachView()

    /**
     * 是否绑定了View,一般在发起网络请求之前调用
     *
     * @return
     */
    fun isViewAttached(): Boolean

    fun getView(): V
}