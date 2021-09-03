package com.example.module_usercenter;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.common_base.moudle_service.UserInfoService;
import com.example.common_base.util.UserHelper;

/**
 * @author : zhang.wenqiang
 * @date : 2021/4/26
 * description :
 */
@Route(path = "/moudle/mine", name = "user")
public class UserServiceImpl implements UserInfoService {

    @Override
    public String sayHello(String name) {
        return "hello, " + name;
    }

    @Override
    public Boolean isLogged() {
        return UserHelper.INSTANCE.isLogin();
    }

    @Override
    public void init(Context context) {

    }
}
