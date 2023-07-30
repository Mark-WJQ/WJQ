package com.wjq.evoSuite;

/**
 * @Program: WJQ
 * @Description: 测试服务
 * @Author: wangjianqiang07
 * @Date: 2021/8/29
 **/
public class TestService implements TestServiceI{



    @Override
    public void add(String str){
        System.out.println("------------" + str);
    }

}
