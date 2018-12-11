package com.wjq.cglib;

import org.springframework.stereotype.Service;

/**
 * Created by wangjianqiang on 2018/9/5.
 */
public class HelloServiceimpl implements HelloService {

    @CgLIb
    public String hello() {
        return world("world");
    }


    public String world(String name) {
        return "hello " + name;
    }
}
