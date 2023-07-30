package com.wjq.evoSuite;

/**
 * @Program: WJQ
 * @Description: 第一恶
 * @Author: wangjianqiang07
 * @Date: 2021/8/29
 **/
public class FirstClass {


    public FirstClass(TestServiceI testService) {
        this.testService = testService;
    }

    TestServiceI testService;



    public void ddd(){
        testService.add("ddd");
    }



}
