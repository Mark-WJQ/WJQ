package com.wjq.monitor.execute;

import org.springframework.stereotype.Component;

/**
 * @author wangjianqiang24
 * @date 2020/6/2
 */
@Component
public class TestAop implements TestAopInf {


    @Override

    public void monitor(){
        System.out.println("--------------------------------");
    }

    public void t1(){
        System.out.println("t1-----------------");
        int i = 1/0;
    }

}
