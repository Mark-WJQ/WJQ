package com.impl;

import test.HelloService;
import com.util.RpcService;

/**
 * Created by wangjianqiang on 2017/11/5.
 */
@RpcService(HelloService.class)   //指定远程接口
public class HelloServiceImpl implements HelloService {
    public String hello(String name) {
        return null;
    }
}
