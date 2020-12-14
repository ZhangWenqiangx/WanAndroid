package com.example.common_base.base.mvp;

import com.example.common_base.base.BaseFragment;

/**
 * @author zwq 2020/11/20
 * @describe :
 */
public abstract class BaseMvpFragment<P extends IPresenter> extends BaseFragment implements IView {
    protected P presenter;

    @Override
    public void initData() {
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    protected abstract P createPresenter();

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoading() {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detachView();
            presenter = null;
        }
    }
}
