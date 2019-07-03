package com.example.module_usercenter.contract;

import com.example.common_base.constants.Constants;
import com.example.common_base.mvp.BasePresenter;
import com.example.common_base.util.SpUtil;

public class LoginPresenter extends BasePresenter<LoginContract.View>
        implements LoginContract.Presenter {

    @Override
    public void login(String username, String password) {

    }

    public void saveUsernamePwd(String name,String pwd) {
        SpUtil.INSTANCE.write(Constants.INSTANCE.getUSER_LOGIN(),Constants.INSTANCE.getUSERNAME(),name);
        SpUtil.INSTANCE.write(Constants.INSTANCE.getUSER_LOGIN(),Constants.INSTANCE.getPASSWORD(),pwd);
    }

    public String readUsernamePwd(String key) {
        return SpUtil.INSTANCE.read(Constants.INSTANCE.getUSER_LOGIN(),key,"");
    }
}
