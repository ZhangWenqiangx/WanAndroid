package com.example.module_usercenter;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.common_base.HelloService;

/**
 * @author : zhang.wenqiang
 * @date : 2021/4/26
 * description :
 */
@Route(path = "/yourservicegroupname/hello", name = "测试服务")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "hello, " + name;
    }

    @Override
    public void init(Context context) {

    }
}
