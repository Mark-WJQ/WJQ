package com.wjq.config;

import com.wjq.Car1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wjq
 * @version 1.0.0
 * @ClassName Application.java
 * @createTime 2020年02月18日 09:51:00
 */
@SpringBootApplication(scanBasePackages = "com.wjq")
public class Application {


    @Autowired
    Car1 car1;

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);

    }



}
