package com.example.common_base.moudle_service;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * @author : zhang.wenqiang
 * @date : 2021/4/26
 * description :
 */
public interface UserInfoService extends IProvider {
    String sayHello(String name);

    /**
     * @return 是否登录
     */
    Boolean isLogged();
}
