package com.example.module_gank.presenter;

import com.example.common_base.base.BaseObserver;
import com.example.common_base.mvp.BasePresenter;
import com.example.module_gank.api.GankApi;
import com.example.module_gank.bean.MeiziResult;
import com.example.module_gank.contract.MeiZiContract;

import java.util.List;

/**
 * Description:
 */
public class MeiZiPresenter extends BasePresenter<MeiZiContract.View> implements MeiZiContract.Presenter {
    @Override
    public void getMeiZiList(int pageSize, int page) {
        addSubscirbe(create(GankApi.class).getMeiZiList(pageSize, page), new BaseObserver<List<MeiziResult>>(getView()) {

            @Override
            protected void onSuccess(List<MeiziResult> data) {
                if (isViewAttached()) {
                    getView().onMeiZiList(data);
                }
            }
        });
    }
}
