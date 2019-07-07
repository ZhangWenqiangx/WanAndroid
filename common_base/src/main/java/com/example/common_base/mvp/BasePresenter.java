package com.example.common_base.mvp;

import com.example.common_base.base.BaseObserver;
import com.example.common_base.http.RetrofitClient;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

import java.lang.ref.WeakReference;

public class BasePresenter<V extends IView> implements IPresenter<V> {

    //    protected V view;
    protected WeakReference<V> viewRef;
    // 管理订阅关系，用于取消订阅
    protected CompositeDisposable compositeDisposable;

    public BasePresenter() {

    }

    /**
     * 绑定 View ，一般在初始化时调用
     *
     * @param view  被绑定的view
     */
    public void attachView(V view) {
        viewRef = new WeakReference<>(view);
        V v = viewRef.get();
    }

    /**
     * 解除绑定 View,一般在 onDestroy 中调用
     */
    public void detachView() {
        this.viewRef = null;
        unSubscribe();
    }

    /**
     * 是否绑定了View,一般在发起网络请求之前调用
     *
     * @return
     */
    public boolean isViewAttached() {
        return viewRef.get() != null;
    }

    public V getView() {
        return viewRef.get();
    }

    /**
     * 添加订阅
     * @param observable    观察者
     * @param observer 被观察者
     */
    public void addSubscirbe(Observable<?> observable, BaseObserver observer){

        if(compositeDisposable == null){
            compositeDisposable = new CompositeDisposable();
        }

        BaseObserver baseObserver = observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer);

        compositeDisposable.add(baseObserver);
    }

    public void unSubscribe(){
       if(compositeDisposable!=null){
           compositeDisposable.dispose();
       }
    }

    protected <T> T create(Class<T> clazz){
        return RetrofitClient.getInstance().getRetrofit().create(clazz);
    }

}