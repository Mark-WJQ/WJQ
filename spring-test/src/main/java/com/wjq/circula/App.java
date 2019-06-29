package com.wjq.circula;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


/**
 *
 * spring循环依赖问题
 *
 *
 *
 *
 *
 */

@ComponentScan
public class App {


    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);


    }

}
