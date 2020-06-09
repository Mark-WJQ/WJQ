package com.wjq.monitor.execute;

import com.wjq.monitor.annotation.Monitor;
import com.wjq.monitor.result.Result;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wangjianqiang24
 * @date 2020/6/2
 */
@Component
@Monitor
public class TestAop implements TestAopInf<List> {


    @Override
    @Monitor
    public Result monitor(List list){
        System.out.println("--------------------------------");
        return new Result() {
            @Override
            public String getCode() {
                return "0000";
            }

            @Override
            public String getInfo() {
                return "成功";
            }
        };
    }

    public void t1(){
        System.out.println("t1-----------------");
        int i = 1/0;
    }

}
