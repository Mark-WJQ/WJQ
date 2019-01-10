package com.wjq.tk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by wangjianqiang on 2019/1/4.
 */
@SpringBootApplication(scanBasePackages = "com.wjq")
public class ApplicationConfig {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfig.class);

    }

}
