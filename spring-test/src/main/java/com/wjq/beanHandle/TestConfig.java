package com.wjq.beanHandle;

import com.wjq.beanHandle.declareParents.Declare;
import com.wjq.cglib.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by wangjianqiang on 2018/9/20.
 */
public class TestConfig {


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);
        HelloService helloService = context.getBean(HelloService.class);

        System.out.println(helloService.hello());

        Declare declare = (Declare) helloService;
        declare.dm1();



    }
}
