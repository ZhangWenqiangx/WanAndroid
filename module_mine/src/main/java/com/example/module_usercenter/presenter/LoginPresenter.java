package com.example.module_usercenter.presenter;

import com.example.common_base.base.mvp.BaseObserver;
import com.example.common_base.base.mvp.BasePresenter;
import com.example.module_usercenter.api.UserCenterApiService;
import com.example.module_usercenter.bean.LoginResult;
import com.example.module_usercenter.contract.LoginContract;

import org.jetbrains.annotations.NotNull;

public class LoginPresenter extends BasePresenter<LoginContract.View>
        implements LoginContract.Presenter {

    @Override
    public void login(@NotNull String username, @NotNull String password) {

        addSubscirbe(create(UserCenterApiService.class).login(username, password),
                new BaseObserver<LoginResult>(getView()) {
                    @Override
                    protected void onSuccess(LoginResult data) {
                        if (isViewAttached()) {
                            getView().loginSuccess(data);
                        }
                    }
                });
    }
}
