package com.wjq.beanHandle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wangjianqiang on 2018/10/10.
 */
@Component
public class Boss {


    public Boss() {
    }
    @Autowired
    public Boss(Car car) {
        System.out.println("有参构造");
        this.car = car;
    }

    private Car car;

}
