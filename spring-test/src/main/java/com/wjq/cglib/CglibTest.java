package com.wjq.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * Created by wangjianqiang on 2018/9/5.
 */
public class CglibTest {


    public static void main(String[] args) {


        HelloService helloService = null;
       /* ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");

        Map<String,Object> map = context.getBeansWithAnnotation(CgLIb.class);


        helloService = context.getBean(HelloService.class);
        System.out.println(helloService.hello());*/




        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloServiceimpl.class);
        enhancer.setCallback(new MyMethodInterceptor());
        helloService = (HelloServiceimpl) enhancer.create();
        System.out.println(helloService.hello());



    }

}
