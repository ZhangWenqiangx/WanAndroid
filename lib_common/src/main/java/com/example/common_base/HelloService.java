package com.example.common_base;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * @author : zhang.wenqiang
 * @date : 2021/4/26
 * description :
 */
public interface HelloService extends IProvider {
    String sayHello(String name);
}
