package com.wjq.cglib;

import org.springframework.stereotype.Service;

/**
 * Created by wangjianqiang on 2018/9/5.
 */
@Service
public class HelloServiceimpl implements HelloService {

    @CgLIb
    public String hello() {
        return world("world");
    }


    public String world(String name) {
        return "hello " + name;
    }


    public void dm1() {
        System.out.println("delcare ---------- HelloServiceimpl");
    }
}
