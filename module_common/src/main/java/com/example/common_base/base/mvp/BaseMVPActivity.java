package com.example.common_base.base.mvp;

import com.example.common_base.base.BaseActivity;

public abstract class BaseMVPActivity<P extends IPresenter> extends BaseActivity implements IView {
    protected P presenter;

    @Override
    protected void initData() {
        presenter = createPresenter();
        // presenter 绑定 view
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    protected abstract P createPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Activity 销毁时取消所有的订阅
        if (presenter != null) {
            presenter.detachView();
            presenter = null;
        }
    }
}
