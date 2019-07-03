package com.example.common_base.base;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.example.common_base.mvp.IPresenter;
import com.example.common_base.mvp.IView;

public abstract class BaseMVPActivity<P extends IPresenter> extends BaseActivity implements IView {
    protected P presenter;
    private Unbinder unbinder;

    @Override
    protected void initData() {
        presenter = createPresenter();
        // presenter 绑定 view
        if (presenter != null) {
            presenter.attachView(this);
        }
        unbinder = ButterKnife.bind(this);
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
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
