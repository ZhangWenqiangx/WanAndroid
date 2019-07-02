package com.example.module_usercenter.activity;

import com.example.common_base.base.BaseMVPActivity;
import com.example.module_usercenter.bean.LoginResult;
import com.example.module_usercenter.contract.LoginContract;
import com.example.module_usercenter.contract.LoginPresenter;
import org.jetbrains.annotations.NotNull;

/**
 * Description:
 */
public class LoginActivitys extends BaseMVPActivity<LoginPresenter> implements LoginContract.View{

    @Override
    protected int getLayoutResId() {
        return 0;
    }

    @Override
    protected LoginPresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void loginSuccess(@NotNull LoginResult loginResult) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
