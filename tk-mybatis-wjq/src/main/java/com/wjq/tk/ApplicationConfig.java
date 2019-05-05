package com.wjq.tk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by wangjianqiang on 2019/1/4.
 */
@SpringBootApplication(scanBasePackages = {"com.wjq"} )
@EnableTransactionManagement
public class ApplicationConfig {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfig.class,args);
       // SpringApplication.run(args);
        String h = "hhh";
        System.out.println(h.hashCode()>>>16);

    }

}
