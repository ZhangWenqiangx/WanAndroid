package com.example.common_base.base;

import com.example.common_base.http.ApiException;
import com.example.common_base.http.ExceptionHandler;
import com.example.common_base.mvp.IView;
import io.reactivex.observers.DisposableObserver;

/**
 * Description:数据请求的类
 */
public abstract class BaseObserver<T> extends DisposableObserver<Result<T>> {

    private IView baseView;

    public BaseObserver() {

    }

    public BaseObserver(IView baseView) {
        this.baseView = baseView;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(baseView != null){
            baseView.showLoading();
        }
    }

    /**
     * 请求事件回调
     * @param result
     */
    @Override
    public void onNext(Result<T> result) {

        if(baseView!=null){
            baseView.hideLoading();
        }

        int errorCode = result.getErrorCode();

        boolean error = result.isError();
        String errorMsg = result.getErrorMsg();

        //gank 返回boolean
        if(!error){
            T results = result.getResults();
            onSuccess(results);
        }else if (errorCode == 0 || errorCode == 200){
            //wandroid 返回的是0 or 200
            T results = result.getData();
            onSuccess(results);
        }else {
            onError(new ApiException(errorCode,errorMsg));
        }

    }

    /**
     * 请求数据的成功的回调
     * @param data
     */
    protected abstract void onSuccess(T data);

    /**
     * 数据异常处理
     * @param e
     */
    @Override
    public void onError(Throwable e) {
        ExceptionHandler.Companion.handlerException(e);
    }

    @Override
    public void onComplete() {
        if(baseView != null){
            baseView.hideLoading();
        }
    }

}
